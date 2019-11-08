package chess.bot;

import chess.engine.GameState;

public interface ChessBot {
    String nextMove(GameState gamestate);
}
