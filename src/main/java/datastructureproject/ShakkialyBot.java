
import chess.bot.ChessBot;
import chess.engine.GameState;
import datastructureproject.movealgos.*;

public class ShakkialyBot implements ChessBot {

//PAKOLLISET PALIKAT: minmax+alphabeta+progressive deepening(löytyy aina jokin vastaus)
//TODELLA HYÖDYLLINEN: UNEVEN TREE DEVELOPMENT. Eli jos jokin puun haara näyttä päätyvän esim shakkimattiin--> mee syvemmälle.
//HYÖDYLLISET JOITA VOI KURSSIN JÄLKEEN TEHDÄ: parallel computing(varmaan enemmin käjä juttui tjtn), opening book, endgame.
    @Override
    public String nextMove(GameState gamestate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Hakee kaikki mahdolliset siirrot. Näitä tarvitaan puun generoimiseen.
    */
    public static String allLegalMoves() {
        String list = "";
        /*for (int i = 0; i < 64; i++) { // ruudut läpi
            
            switch (board[i / 8][i % 8]) { //pitää hakea pöytätilanne tähän
                case "P":
                    list += Pawn.legalPawnMoves(i);
                    break;
                case "R":
                    list += Rook.legalRookMoves(i);
                    break;
                case "K":
                    list += Knight.legalKnightMoves(i);
                    break;
                case "B":
                    list += Bishop.legalBishopMoves(i);
                    break;
                case "Q":
                    list += Queen.legalQueenMoves(i);
                    break;
                case "A":
                    list += King.legalKingMoves(i);
                    break;
            }
        }
         */
        return list;
    }

}
