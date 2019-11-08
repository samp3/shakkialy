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
public class KingSafety {

    static int temp;

    static boolean truth = true;

    /**
     * Pit‰‰ huomioida kokoajan, onko kuningas turvassa
     *
     * @return
     */
    public static boolean kingIsSafe() {

        temp = 1;
        bishopAndQueen();
        rookAndQueen();
        knight();
        pawnAndKing();
        return truth;
    }

    /**
     * Katsoo kuninkaasta viistoon kulkevat reitit.
     */
    public static void bishopAndQueen() {

    }

    /**
     * Katsoo kuninkaasta vaakatasoon ja pystysuuntaan kulkevat reitit
     */
    public static void rookAndQueen() {

    }

    /**
     * Katsoo uhkaako heppa kuningasta
     */
    public static void knight() {

    }

    /**
     * Katsoo uhkaako sotilas tai kuningas
     */
    public static void pawnAndKing() {

    }
}
