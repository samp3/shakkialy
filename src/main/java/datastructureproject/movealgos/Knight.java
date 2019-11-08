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
public class Knight {

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
     * Metodi palauttaa laudalla sijaitsevan hevosen kaikki mahdolliset siirrot.
     * Parametri i kertoo metodille, missä nappula sijaitsee.
     *
     * @param i
     * @return
     */
    public static String legalKnightMoves(int i) {
        r = i / 8;
        c = i % 8;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                verticalMovement(j, k);
                horizontalMovement(j, k);
            }
        }
        return list;
    }

    /**
     * liikutaan vaakatason suuntaan
     *
     * @param j
     * @param k
     */
    public static void verticalMovement(int j, int k) {

    }

    /**
     * liikutaan pystytason suuntaan
     *
     * @param j
     * @param k
     */
    public static void horizontalMovement(int j, int k) {

    }
}
