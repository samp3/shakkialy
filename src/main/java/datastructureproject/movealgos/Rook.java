package datastructureproject.movealgos;

/**
 * Tornin liikkumisalgo. Tarvitaan puun generoimiseen. Palauttaa tornin kaikki
 * mahdolliset siirrot.
 *
 * @author sampc
 */
public class Rook {

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
     * Metodi palauttaa laudalla sijaitsevan tornin kaikki mahdolliset siirrot.
     * Parametri i kertoo metodille, missä nappula sijaitsee.
     *
     * @param i
     * @return
     */
    public static String legalRookMoves(int i) {

        r = i / 8;
        c = i % 8;
        temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            try {
                checkDiagonal(j);
                isNextOpponentDiag(j);
            } catch (Exception e) {
            }
            temp = 1;
            try {
                checkHorizontal(j);
                isNextOpponentHoriz(j);
            } catch (Exception e) {
            }
            temp = 1;
        }
        return list;
    }

    /**
     * tarkastaako onko seuraavalla ruudulla vastustaja(vaakatasossa
     * liikuttaessa)
     *
     * @param j
     */
    public static void isNextOpponentDiag(int j) {

    }

    /**
     * katsoo vaakatason ruudut läpi
     *
     * @param j
     */
    public static void checkDiagonal(int j) {

    }

    /**
     * katsoo pystytason ruudut läpi
     *
     * @param j
     */
    public static void checkHorizontal(int j) {

    }

    /**
     * katsoo onko seuraavavalla ruudulla vastus
     *
     * @param j
     */
    public static void isNextOpponentHoriz(int j) {

    }
}
