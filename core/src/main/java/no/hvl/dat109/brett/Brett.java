package no.hvl.dat109.brett;

public interface Brett {

    /**
     * Posisjoner hvor stiger er lokalisert på brettet, tallet etter er ruten stigen er knyttet til.
     */
    int[][] stiger = {
            {2, 37},
            {7, 28},
            {12, 31},
            {21, 85},
            {26, 47},
            {41, 61},
            {48, 66},
            {50, 70},
            {69, 71},
            {83, 97}
    };

    /**
     * Posisjoner hvor slanger er lokalisert på brettet, tallet etter er ruten slangen er knyttet til.
     */
    int[][] slanger = {
            {35, 13},
            {38, 6},
            {57, 15},
            {62, 43},
            {67, 53},
            {93, 74},
            {96, 55},
            {99, 78}
    };

    /**
     * @param posisjon 'rutenummer'
     * @return rute som er assosiert med rutenummeret
     */
    Rute getRute(int posisjon);
}
