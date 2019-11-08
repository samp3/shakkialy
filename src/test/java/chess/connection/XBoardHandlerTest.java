package chess.connection;

import chess.bot.TestBot;
import chess.engine.GameState;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import java.io.ByteArrayInputStream;

public class XBoardHandlerTest {
    private TestBot bot;
    private BufferedReader in;
    public XBoardHandlerTest() {
    }

    @Before
    public void setUp() {
        this.bot = new TestBot();   
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void xBoardHandlerDoesntCrashOnStartupAsWhite() {
        String data = "protover\n" + "new\n" + "white \n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();
        
        assert(true);
        
    }
   
    @Test
    public void xBoardHandlerDoesntCrashOnStartupAsWhiteWithBlankInputIncluded() {
        String data = "protover\n" + "new\n" + "white \n" + "\n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();
        
        assert(true);
        
    }

    @Test
    public void xBoardHandlerDoesntCrashOnStartupAsWhiteWithBlankInputBeforeProtover() {
        String data = "\n" + "protover\n" + "new\n" + "white \n" + "\n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();
        
        assert(true);
        
    }
    @Test
    public void xBoardHandlerDoesntCrashOnStartupAsBlack() {
        String data = "protover\n" + "new\n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();

        assert(true);
        
    }

    @Test
    public void xBoardHandlerDoesntCrashOnStartupAsBlackWithOpeningMove() {
        String data = "protover\n" + "new\n"  + "usermove e2e4\n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();
        
        assert(true);
        
    }
    @Test
    public void xBoardHandlerIsAbleToHandleIncomingMoves() {
        String data = "protover \n" + "new \n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();
        xb.handleMove("e2e4");
   

        GameState gs = xb.getGameState();
        assert(gs.moves.contains("e2e4"));
    }

    @Test
    public void xBoardHandlerIsAbleToHandleTimeForPlayer() {
        String data = "protover \n" + "new \n" + "time 30000\n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();
        
        assertEquals((long) 300000, xb.getGameState().getRemainingTime());
    }

    @Test
    public void xBoardHandlerIsAbleToHandleTimeForOpponent() {
        String data = "protover \n" + "new \n" + "otim 20000\n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();


        assertEquals((long) 200000, xb.getGameState().getRemainingTimeOpponent());
    }
    @Test
    public void xBoardHandlerIsAbleToMakeNewMoves() {
        String data = "protover \n" + "new \n" + "endloop \n";
        
        this.in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));

        XBoardHandler xb = new XBoardHandler(bot, in);
        xb.run();
        xb.nextMove();

        GameState gs = xb.getGameState();
        assert(gs.moves.size() == 1);
    }
}
