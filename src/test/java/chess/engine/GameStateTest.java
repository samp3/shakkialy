/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.engine;

import chess.model.Testdata;
import chess.model.Side;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sami
 */
public class GameStateTest {
    
    public GameStateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    public String gameStateFullJson = Testdata.gameStateFullJson;
    public String gameStateJson = Testdata.gameStateJson;
    public String gameStateJsonShort = Testdata.gameStateJsonShort;
    
    @Test
    public void gameStateParsesJson() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        
        assert (true);
    }
    
    @Test
    public void gameStateParsesSingleLineJson() {
        GameState gameState = GameState.parseFromJson(gameStateJsonShort);
        
        assert (true);
    }
    
    @Test
    public void gameStateIdReadCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        
        assertEquals(gameState.id, "NCCbuaQM");
    }
    
    @Test
    public void gameStatePlayersReadCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        
        assertEquals(gameState.playingWhite, "lovlas");
        assertEquals(gameState.playingBlack, "leela");       
    }
    
    @Test
    public void gameStateMovesReadCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        String s = "e2e4 c7c5 f2f4 d7d6 g1f3 b8c6 f1c4 g8f6 d2d3 g7g6 e1g1 f8g7";
        ArrayList<String> moves = new ArrayList<>(Arrays.asList(s.split(" ")));
        
        assertEquals(gameState.moves, moves);
    }
    
    @Test
    public void gameStateMovesUpdateCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        
        gameState.updateFromJson(gameStateJson);
        String s = "e2e4 c7c5 f2f4 d7d6 g1f3 b8c6 f1c4 g8f6 d2d3 g7g6 e1g1 f8g7 b1c3";
        ArrayList<String> moves = new ArrayList<>(Arrays.asList(s.split(" ")));
        
        assertEquals(gameState.moves, moves);
    }
    
    @Test
    public void gameStateUpdateFromGameFullWorks() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        
        gameState.updateFromJson(gameStateFullJson);
        
        assert (true);
    }

    @Test
    public void gameStateUpdateFromEmptyMovesWorks() {
        GameState gameState = GameState.parseFromJson(gameStateJsonShort);
        
        gameState.updateFromJson(gameStateJsonShort);
        
        assert (true);
    }
    
    @Test
    public void gameStateReadsWhiteAndBlackTimesCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        
        assert(gameState.whiteTime == 7598040);
        assert(gameState.blackTime == 8395220);   
    }

    @Test
    public void gameStateReadsRemainingTimeCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        gameState.playing = Side.WHITE;
        
        assert(gameState.getRemainingTime() == 7598040);
    }
    
    @Test
    public void gameStateReadsOpponentTimeCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        gameState.playing = Side.WHITE;
        
        assert(gameState.getRemainingTimeOpponent() == 8395220);
    }

    @Test
    public void gameStateGivesMyTurnCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        
        gameState.playing = Side.WHITE;
        assert(gameState.myTurn() == true);
        
        gameState.playing = Side.BLACK;
        assert(gameState.myTurn() == false);
    }
    
    @Test
    public void gameStateGivesCorrectMoveCount() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);

        assert(gameState.getMoveCount() == 12);
    }

    @Test
    public void gameStateGivesLatestMoveCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);

        assert(gameState.getLatestMove().equals("f8g7"));
    }
    
    @Test
    public void gameStateGivesCorrectTurnCount() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);

        assert(gameState.getTurnCount() == 7);
    }
    
    @Test
    public void gameStateSetWhiteTimeCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        gameState.playing = Side.WHITE;
        long someTime = 3;
        gameState.setTimePlayer(someTime);
        assert(gameState.getRemainingTime() == 3);
    }  

    @Test
    public void gameStateSetBlackOpponentTimeCorrectly() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        gameState.playing = Side.WHITE;
        long someTime = 3;
        gameState.setTimeOpponent(someTime);
        assert(gameState.getRemainingTimeOpponent() == 3);
    }  
    
    @Test
    public void setMovesSetsMovesCorrectly(){
        GameState gameState = new GameState();
        gameState.setMoves("a1,a1,a1");
        gameState.moves.forEach(moveString -> {
            assertTrue("Setting moves without brackets", moveString.equals("a1"));
        });
    }
    
    @Test
    public void setMovesSetsMovesCorrectlyWithBrackets(){
        GameState gameState = new GameState();
        gameState.setMoves("(a1,[a1,{a1,a1),a1],a1}");
        gameState.moves.forEach(moveString -> {
            assertTrue("Setting moves without brackets", moveString.equals("a1"));
        });
    }
}
