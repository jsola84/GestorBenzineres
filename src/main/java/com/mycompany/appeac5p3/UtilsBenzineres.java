/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbenzineres;

/**
 *
 * @author jsola
 */
public class UtilsBenzineres {

    static final short ERROR = -1;//Generem 3 constants per els diferents errors
    static final short ERROR_COLISIO = -2;
    static final short ERROR_NOESPAI = -3;
    static final int ERROR_OPCIO = -4;
    static final int ID_BENZINERA = 0;
    static final int CODI_POSTAL = 1;
    static final int PROPIETARI = 2;
    static final int PREU_SP = 0;
    static final int PREU_DI = 1;
    static final int NUM_BENZINERES = 15;
    static final int NUM_COMBUSTIBLES = 2;
    static final int NUM_DADES = 3;
    private static int res = 0;//Variable per marcar el numero de filera retornat per el metode cercarPosicioBuida i utilitzat per cercarBenzinera si hi ha un error

    public static int enregistrarBenzinera(String idBenzinera, String codiPostal, String nomPropietari, float preuSP, float preuDiesel, String[][] dadesBenzineres, float[][] preusBenzina) {

        dadesBenzineres[res][ID_BENZINERA] = idBenzinera;//introduïm les dades als array per posició de retorn de espai buit.
        dadesBenzineres[res][CODI_POSTAL] = codiPostal;
        dadesBenzineres[res][PROPIETARI] = nomPropietari;
        preusBenzina[res][PREU_SP] = preuSP;
        preusBenzina[res][PREU_DI] = preuDiesel;

        return res;

    }

    public static int cercaBenzinera(String idBenzinera, String[][] dadesBenzineres) {

        res = 0;
        for (int i = 0; i < NUM_BENZINERES; i++) {//Bucle per recorrer les 15 posicions de l'array
            if (idBenzinera.equalsIgnoreCase(dadesBenzineres[i][ID_BENZINERA])) {//Si l'id de la benzinera es igual a l'id duna posició
                res = ERROR;//Retorna -1, si no, retorna la posició.
            }
        }
        return res;
    }

    public static int cercaPosBuida(String[][] dadesBenzineres) {

        for (int i = 0; i < NUM_BENZINERES; i++) {//Bucle per recorrer l'array de 15 posicions
            if (dadesBenzineres[i][ID_BENZINERA].equalsIgnoreCase("")) {//Si a una posició i troba cometes dobles (""), 
                res = i;//La variable adquireix la posició de l'index del bucle (i)
                i = NUM_BENZINERES;//Acabem el bucle donant el valor total de l'array i així l'atorem
            } else {//Si no hi ha posició buida, 
                res = ERROR;//Retornem -1
            }
        }
        return res;
    }

    private static int cercaPreuMinimCombustible(float[][] preusBenzina, int indexCombustible) {

        float preuMinim = 500;
        int index = 0;
        for (int i = 0; i < NUM_BENZINERES; i++) {

            if (preusBenzina[i][indexCombustible] < preuMinim) {
                preuMinim = preusBenzina[i][indexCombustible];
                index = i;
            }
        }
        return index;
    }

    public static float[][] copiaTaulaFloat(float[][] taulaOriginal) {

        float[][] arrayCopiaFloats = new float[NUM_BENZINERES][NUM_COMBUSTIBLES];
        for (int i = 0; i < NUM_BENZINERES; i++) {//Bucle per recorrer l'array de preus per copiar les dades
            arrayCopiaFloats[i][PREU_SP] = taulaOriginal[i][PREU_SP];
            arrayCopiaFloats[i][PREU_DI] = taulaOriginal[i][PREU_DI];

        }
        return arrayCopiaFloats;
    }

    public static String[][] copiaTaulaString(String[][] taulaOriginal) {

        String[][] arrayCopiaStrings = new String[NUM_BENZINERES][NUM_DADES];
        for (int i = 0; i < NUM_BENZINERES; i++) {//Bucle que recorre el numero de files  per copiar les dades de les benzineres.
            arrayCopiaStrings[i][ID_BENZINERA] = taulaOriginal[i][ID_BENZINERA];
            arrayCopiaStrings[i][CODI_POSTAL] = taulaOriginal[i][CODI_POSTAL];
            arrayCopiaStrings[i][PROPIETARI] = taulaOriginal[i][PROPIETARI];
        }
        return arrayCopiaStrings;
    }

    public static int[] indexBenzineresPerPreuCombustible(float[][] preusBenzina, int indexCombustible) {

        int[] indexBenzineres = new int[NUM_BENZINERES];
        float[][] preusCopiats;
        int index;
        preusCopiats = copiaTaulaFloat(preusBenzina);
        for (int i = 0; i < NUM_BENZINERES; i++) {//Bucle que recorre l'array les files, després la variable index agafa el valor que es crea al métode cercaPreuMinimCombustibles, invocantlo.
            index = cercaPreuMinimCombustible(preusCopiats, indexCombustible);
            indexBenzineres[i] = index;//L'array indexBenzineres agafa el valor que desprén la variable index, per cada iteracció del bucle salta una posició de l'array
            preusCopiats[index][indexCombustible] = 500;//L'array de preusCopiats canvia el seu valor a un valor molt superior per que quan torni a analitzar aquest valor no sigui el mínim.
        }
        return indexBenzineres;
    }
}
