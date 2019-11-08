package chess.connection;

import chess.bot.ChessBot;
import chess.engine.GameState;
import java.util.Iterator;
import java.util.List;

public class MockBot implements ChessBot {

    private Iterator<String> movesToMake;

    public MockBot(List<String> moveList) {
        movesToMake = moveList.iterator();
    }

    @Override
    public String nextMove(GameState gamestate) {
        return this.movesToMake.hasNext() ? this.movesToMake.next() : "No more testmoves!";
    }

}
