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
public class Bishop {

    /**
     * r kertoo rivin, missa nappula sijaitsee, c sarakkeen. temp:ia
     * kasvatetaan, kun kaydaan ruutuja lapi, etta saadaan ylos kaikki
     * mahdolliset tyhjat ruudut
     */
    static int r, c, temp;
    /**
     * oldpiece pitaa vanhaa nappulaa muistissa, list on palautettava lista,
     * jossa on kaikki mahdolliset siirrot kyseiselle nappulalle.
     */
    static String oldPiece, list = "";

    /**
     * Metodi palauttaa laudalla sijaitsevan lähetin kaikki mahdolliset siirrot.
     * Parametri i kertoo metodille, missä nappula sijaitsee.
     *
     * @param i
     * @return
     */
    public static String legalBishopMoves(int i) {

        r = i / 8;
        c = i % 8;
        temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    checkEmptySquares(j, k);
                    checkIfOpponent(j, k);
                } catch (Exception e) {
                }
                temp = 1;
            }
        }
        return list;
    }

    /**
     * tarkastaako onko ruudussa vastustaja
     *
     * @param j
     * @param k
     */
    public static void checkIfOpponent(int j, int k) {

    }

    /**
     * kay lapi tyhjia ruutuja
     *
     * @param j
     * @param k
     */
    public static void checkEmptySquares(int j, int k) {

    }

}
