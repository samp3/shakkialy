/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.movealgos;

/**
 *
 * @author sampc
 */
public class Pawn {

    /**
     * r kertoo rivin, missa nappula sijaitsee, c sarakkeen.
     */
    static int r, c;

    /* * oldpiece pitaa vanhaa nappulaa(joka syodaan)
     * muistissa, list on palautettava lista, jossa on kaikki mahdolliset siirrot kyseiselle
     * nappulalle.
     */
    static String oldPiece, list = "";

    /**
     * Metodi palauttaa laudalla sijaitsevan sotilaan kaikki mahdolliset
     * siirrot. Parametri i kertoo metodille, missä nappula sijaitsee.
     *
     * @param i
     * @return
     */
    public static String legalPawnMoves(int i) {

        r = i / 8;
        c = i % 8;

        eatAndPromote(i);
        moveOneSquare(i);
        promoteNoCapture(i);
        moveTwoSquares(i);

        return list;
    }

    /**
     * Syöminen ja syöminen + promote
     *
     * @param i
     */
    public static void eatAndPromote(int i) {
        
        
    }

    /**
     * Pawn liikkuu yhden squaren
     *
     * @param i
     */
    public static void moveOneSquare(int i) {
     
    }

    /**
     * Pawn promote ilman, että syö nappulaa
     *
     * @param i
     */
    public static void promoteNoCapture(int i) {
        
    }

    /**
     * Pawn liikkuu 2 ruutua
     *
     * @param i
     */
    public static void moveTwoSquares(int i) {
      
    }
}
