/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.connection;

import chess.bot.ChessBot;
import chess.model.Event;
import chess.engine.GameState;
import chess.model.Profile;
import chess.model.Side;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import logging.Logger;

/**
 * Java implementation of the Lichess.org HTTP API for chess bots
 *
 */
public class LichessAPI {

    private final String token;
    private ChessBot bot;
    private String gameId;
    private String playerId;
    private Logger logger;
    private HTTPIOFactory httpFactory;

    private HashMap<String, String> headers;

    public LichessAPI(ChessBot bot, String token) {
        this(bot, token, new Logger().useStdOut(), new HTTPStreamFactory());
    }

    public LichessAPI(ChessBot bot, String token, Logger logger, HTTPIOFactory httpFactory) {
        this.bot = bot;
        this.logger = logger;
        this.httpFactory = httpFactory;

        this.token = token;

        headers = new HashMap<>();

        // Add token to HTTP headers
        headers.put("Authorization", "Bearer " + token);
    }
            
    /**
     * Get Lichess account information
     *
     * @return Profile for the account associated with the given Lichess token
     */
    public Profile getAccount() {
        String json;
        HTTPIO stream = httpFactory.createNew()
                .get("https://lichess.org/api/account")
                .setHeaders(headers)
                .connect();
        
        if (stream.getHTTPStatus() != 200) {
            logger.logError("Lichess returned Error code " + stream.getHTTPStatus() 
                    + ": your Lichess token might be invalid.");
            
            return null;
        }
        
        json = stream.toString();

        try {
            stream.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LichessAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        Profile profile = Profile.parseFromJson(json);

        return profile;
    }

    /**
     * Starts reading Lichess events
     *
     * Accepts all received Challenge events, on GameStart event enters gameplay
     * loop
     */
    public void beginEventLoop() {
        HTTPIO eventStream = httpFactory.createNew()
                .get("https://lichess.org/api/stream/event")
                .setHeaders(headers)
                .connect();
        
        if (eventStream.getHTTPStatus() != 200) {
            logger.logError("Lichess returned Error code " + eventStream.getHTTPStatus() 
                    + ": your Lichess token might be invalid.");
            
            return;
        }
        
        handleEventLoop(eventStream.getIterator());

        try {
            eventStream.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LichessAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleEventLoop(Iterator<String> eventStream) {
        while (eventStream.hasNext()) {
            logger.logMessage("Waiting for Lichess events... (press Ctrl-C if you want to quit playing)");
            
            String line = eventStream.next();

            if (!line.isEmpty()) {
                Event event = Event.parseFromJson(line);

                logger.logMessage("New event: " + event.type + " id: " + event.id);

                switch (event.type) {
                    case Challenge:
                        logger.logMessage("Accepting challenge: " + event.id);
                        System.out.println(acceptChallenge(event.id));
                        break;
                    case GameStart:
                        this.gameId = event.id;

                        openGame();

                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Opens the game event stream and starts playing moves from the bot
     */
    public void openGame() {
        this.playerId = this.getAccount().id;

        logger.logMessage("Game starting: " + gameId);

        HTTPIO gameStream = httpFactory.createNew()
                .get("https://lichess.org/api/bot/game/stream/" + gameId)
                .setHeaders(headers)
                .connect();
        
        if (gameStream.getHTTPStatus() != 200) {
            logger.logError("Lichess returned Error code " + gameStream.getHTTPStatus() 
                    + ": your Lichess token might be invalid.");
            
            return;
        }
        
        playGame(gameStream.getIterator());

        try {
            gameStream.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LichessAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playGame(Iterator<String> gameStream) {
        GameState gs = new GameState();

        boolean gameRunning = true;

        while (gameRunning && gameStream.hasNext()) {
            String line = gameStream.next();
            if (!line.isEmpty()) {
                String move = getNextMove(line, gs, playerId);
                
                if (move == null) {
                    gameRunning = false;
                    logger.logMessage("Bot returned null move - Game ends.");
                } else if (!move.equals("nomove")) {
                    int statusCode = makeMove(move);

                    if (statusCode != 200) {
                        logger.logError("Lichess returned Bad Request status code, illegal move? Move was: " + move 
                                + " Statuscode: " + statusCode);
                    }
                }
            }
        }

    }

    /**
     * Updates gamestate based on given JSON and plays a bot move
     *
     * @param jsonLine A line of JSON data according to
     * https://lichess.org/api#operation/botGameStream
     * @param gamestate The state of the currently running game
     * @param playerId The Lichess ID of the bot
     * @return The move made by the bot in UCI format or "nomove" if the bot
     * cannot make a move
     */
    public String getNextMove(String jsonLine, GameState gamestate, String playerId) {
        if (!jsonLine.isEmpty()) {
            gamestate.updateFromJson(jsonLine);
            
            if (gamestate.playing == null) {
                if (gamestate.playingWhite.equals(playerId)) {
                    gamestate.playing = Side.WHITE;
                } else {
                    gamestate.playing = Side.BLACK;
                }
            }
        }
        logger.logMessage("Moves: " + gamestate.moves.toString());
        
        // White moves are even numbered, black moves are odd numbered
        if (gamestate.getMoveCount() % 2 == 0) {
            gamestate.turn = Side.WHITE;
        } else {
            gamestate.turn = Side.BLACK;
        }
        
        if (gamestate.turn == gamestate.playing) {
            // Call the bot
            String move = bot.nextMove(gamestate);

            if (move == null) {
                logger.logMessage("Bot returned no moves.");

                return null;
            } else {
                logger.logMessage("Bot made move: " + move);
                return move;
            }
        } else {
            return "nomove";
        }
    }

    /**
     * Accept a Lichess challenge
     *
     * @param id The ID of the challenge event
     * @return The HTTP status code of the POST request response
     */
    public int acceptChallenge(String id) {
        HTTPIO stream = httpFactory.createNew()
                .post("https://lichess.org/api/challenge/" + id + "/accept", "")
                .setHeaders(headers)
                .connect();

        return stream.getHTTPStatus();
    }

    /**
     * Decline a Lichess challenge
     *
     * @param id The ID of the challenge event
     * @return The HTTP status code of the POST request response
     */
    public int declineChallenge(String id) {
        HTTPIO stream = httpFactory.createNew()
                .post("https://lichess.org/api/challenge/" + id + "/decline", "")
                .setHeaders(headers)
                .connect();

        return stream.getHTTPStatus();
    }

    /**
     * Make a move in the current Lichess game
     *
     * @param move The chess move in UCI format
     * @return The HTTP status code of the POST request response
     */
    public int makeMove(String move) {
        HTTPIO stream = httpFactory.createNew()
                .post("https://lichess.org/api/bot/game/" + this.gameId + "/move/" + move, "")
                .setHeaders(headers)
                .connect();

        return stream.getHTTPStatus();
    }

    public void setPlayerId(String newPlayerId) {
        this.playerId = newPlayerId;
    }

    public String getPlayerId() {
        return this.playerId;
    }
}
