
import chess.bot.ChessBot;
import chess.engine.GameState;
import datastructureproject.movealgos.*;

public class ShakkialyBot implements ChessBot {

//PAKOLLISET PALIKAT: minmax+alphabeta+progressive deepening(l�ytyy aina jokin vastaus)
//TODELLA HY�DYLLINEN: UNEVEN TREE DEVELOPMENT. Eli jos jokin puun haara n�ytt� p��tyv�n esim shakkimattiin--> mee syvemm�lle.
//HY�DYLLISET JOITA VOI KURSSIN J�LKEEN TEHD�: parallel computing(varmaan enemmin k�j� juttui tjtn), opening book, endgame.
    @Override
    public String nextMove(GameState gamestate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Hakee kaikki mahdolliset siirrot. N�it� tarvitaan puun generoimiseen.
    */
    public static String allLegalMoves() {
        String list = "";
        /*for (int i = 0; i < 64; i++) { // ruudut l�pi
            
            switch (board[i / 8][i % 8]) { //pit�� hakea p�yt�tilanne t�h�n
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
