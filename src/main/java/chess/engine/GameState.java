/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.engine;

import java.util.ArrayList;
import java.util.Arrays;
import chess.model.Side;
import java.util.stream.Collectors;

import org.json.JSONObject;

/**
 * Stores the state of a game of chess
 * Provides access to currently available moves
 */
public class GameState {
    
    public String id;
    
    public String playingBlack;
    public String playingWhite;
    
    public Side playing;
    public Side turn = Side.WHITE;
    
    // Stores the remaining time in milliseconds
    public long whiteTime;
    public long blackTime;
    
    public ArrayList<String> moves;
    
    public GameState() {
        this.moves = new ArrayList();
    }
    
    public int getMoveCount() {
        return moves.size();
    }
    
    public int getTurnCount() {
        return 1 + moves.size() / 2;
    }
    
    public String getLatestMove() {
        return this.moves.get(this.moves.size() - 1);
    }
    
    public long getRemainingTime() {
        if (playing == Side.WHITE) {
            return this.whiteTime;
        } else {
            return this.blackTime;
        }
    }
    
    public long getRemainingTimeOpponent() {
        if (playing == Side.WHITE) {
            return this.blackTime;
        } else {
            return this.whiteTime;
        }
    }
    public boolean myTurn() {
        return this.turn == this.playing;
    }
    
    /**
     * Sets time for Player, used by XBoardHandler
     * @param time
     */
    public void setTimePlayer(long time) {
        if (playing == Side.WHITE) {
            this.whiteTime = time;
        } else {
            this.blackTime = time;
        }
    }
    /**
     * Sets time for Opponent, used by XBoardHandler
     * @param time
     */
    public void setTimeOpponent(long time) {
        if (playing == Side.BLACK) {
            this.whiteTime = time;
        } else {
            this.blackTime = time;
        }
    }
    
    /**
     * Sets the current gamestate with moves passed as the parameters.
     * @param moves 0-n moves in UCI format
     */
    public void setMoves(String moves) {
        ArrayList<String> moveList = new ArrayList(Arrays.asList(moves.split(",")));
        this.moves = moveList.stream().map((String string) -> {
            return string.trim().replaceAll("^\\W|\\W$", "");
        }).collect(Collectors
                .toCollection(ArrayList::new));
    }

    // FOLLOWING METHODS ARE USED TO CREATE GAMESTATES FROM JSON
    // THESE METHODS ARE NOT RELEVANT TO CHESS BOT CREATION

    /**
     * Parses a full game state from a gameFull JSON object
     * <b>Note:</b> Use only to gain the initial game state, game state should
     * be updated via updateFromJson()
     *
     * @param json String of JSON data according to https://lichess.org/api#operation/botGameStream
     * @return A full, initial game state
     */
    public static GameState parseFromJson(String json) {
        GameState gameState = new GameState();
        
        JSONObject jsonGameState = new JSONObject(json);
        
        if (jsonGameState.getString("type").equals("gameFull")) {
            gameState.id = jsonGameState.getString("id");
            
            gameState.playingWhite = jsonGameState.getJSONObject("white").optString("id");
            gameState.playingBlack = jsonGameState.getJSONObject("black").optString("id");
            
            String[] moves = jsonGameState.getJSONObject("state").getString("moves").split(" ");
            
            gameState.moves = new ArrayList<>(Arrays.asList(moves));
            
            gameState.whiteTime = jsonGameState.getJSONObject("state").getInt("wtime");
            gameState.blackTime = jsonGameState.getJSONObject("state").getInt("btime");
        }
        
        return gameState;
    }

    /**
     * Update a GameState object from JSON
     *
     * @param json String of JSON data according to https://lichess.org/api#operation/botGameStream
     */
    public void updateFromJson(String json) {
        JSONObject jsonGameState = new JSONObject(json);
        
        if (jsonGameState.getString("type").equals("gameFull")) {
            this.id = jsonGameState.getString("id");
            
            this.playingWhite = jsonGameState.getJSONObject("white").optString("id");
            this.playingBlack = jsonGameState.getJSONObject("black").optString("id");
            
            String[] moves = new String[0];          
            if (!jsonGameState.getJSONObject("state").getString("moves").isEmpty()) {
                moves = jsonGameState.getJSONObject("state").getString("moves").trim().split(" ");
            } 
            
            this.moves = new ArrayList<>(Arrays.asList(moves));
            
            for (String i : this.moves) {
                System.out.println(i);
            }
            
            this.whiteTime = jsonGameState.getJSONObject("state").getInt("wtime");
            this.blackTime = jsonGameState.getJSONObject("state").getInt("btime");
        } else if (jsonGameState.getString("type").equals("gameState")) {
            String[] moves = jsonGameState.getString("moves").split(" ");
            
            this.moves = new ArrayList<>(Arrays.asList(moves));
            
            this.whiteTime = jsonGameState.getInt("wtime");
            this.blackTime = jsonGameState.getInt("btime");
        }     
    }
}
