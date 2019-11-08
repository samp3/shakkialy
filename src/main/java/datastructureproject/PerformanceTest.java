package datastructureproject;

import chess.bot.ChessBot;
import chess.engine.GameState;
import java.util.ArrayList;
import java.util.List;

/**
 * Use this class to write performance tests for your bot.
 * 
 */
public class PerformanceTest {

    private ChessBot bot;
    private List<GameState> gsList = new ArrayList();

    public void setGsList(List<GameState> gsList) {
        this.gsList = gsList;
    }


    public static void main(String[] args) {
        throw new Error("Peformance test, remove this");
        /*
        Set your bot and tests here.
        */
    }

}
