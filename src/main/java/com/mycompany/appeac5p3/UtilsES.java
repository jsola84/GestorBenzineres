/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.appbenzineres;

import java.util.Scanner;

/**
 *
 * @author jsola
 */
public class UtilsES {

    static final String MENU_OPCIO = "Per favor, premi la opció desitjada:";
    static final String MENU_OPCIO_1 = "1) Enregistrar nova benzinera.";
    static final String MENU_OPCIO_2 = "2) Mostrar dades benzineres.";
    static final String MENU_OPCIO_3 = "3) Ordenar la llista per preu Benzina S/P.";
    static final String MENU_OPCIO_4 = "4) Ordenar la llista per preu Diesel.";
    static final String MENU_OPCIO_SORTIR = "5) Sortir";
    static final String MENU_TRIAR_OPCIO = "Introdueixi un valor per opció";

    static final String MISSATGE_INTRODUIR_STRING = "Introdueix un valor per variable text";
    static final String MISSTAGE_INTRODUIR_FLOAT = "Introdueïx un valor per variable float";
    static final String MISSTATGE_INTRODUIR_ENTER = "Introdueïx un valor per variable enter";

    static final String MISSATGE_INGRES_OK = "Dades benzinera correctament introduida ";
    static final String MISSTAGE_CONTINUACIO_INGRES_OK = " a la posició ";
    static final String MISSATGE_ERROR_COLISIO = "Error - Id benzinera existent:";
    static final String MISSATGE_ERROR_NOESPAI = "Error - Espai insuficient";
    static final String MISSATGE_ERROR_NO_ENTER = "Error - El valor introduït no es un enter";
    static final String MISSATGE_ERROR_NO_FLOAT = "Error - El valor introduït no es un valor real";
    static final String OPCIO_NO_VALIDA = "La opcio es incorrecte!";
    static final String MISSTAGE_NO_INTRUIT_RES = "No has introduït res";
    static final String MISSATGE_ERROR_STRING_BUIT = "Per favor introdueix alguna cosa, gràcies";

    static final String MISSATGE_INTRODUCCIO_IDBENZINERA = "Intrudeïx el codi de la benzinera:";
    static final String MISSATGE_INTRODUCCIO_CODI_POSTAL = "Introdueïx el codi postal:";
    static final String MISSATGE_INTRODUCCIO_NOM_PROPIETARI = "Introdueïx el nom del propietari:";
    static final String MISSATGE_INTRODUCCIO_S_PLOM = "Preu benzina sense plom:";
    static final String MISSATGE_INTRODUCCIO_GASOIL = "Preu gasoil:";

    static final String MISSATGE_INTRODUIDA = "Benzinera ben introduïda";
    static final String MISSATGE_ACOMIAT = "Moltes gràcies! Fins aviat!";
    static final String ERROR_HEADER = "ERROR";
    static final int NUM_BENZINERES = 15;
    static final int MOSTRA_LLISTAT = 2;
    static final int DADES_BENZINERES = 3;
    static final int DADES_PREUS = 2;

    static final String MISSATGE_SEPARADOR = ("--------------------------------------------------------------------------------");
    static final String TITOL_GESTIO = "GESTIO BENZINERES";
    static final String TITOL_LLISTAT = "LLISTAT DE BENZINERES";
    static final String TITOL_DADES = "IDBENZINERA\tCODI POSTAL\tNOM PROPIETARI\tPREU S/P\tPREU DIESEL";
    static final String ESPAIS = " ";

    static final short ERROR = -1;//Generem 3 constants per els diferents errors
    static final short ERROR_COLISIO = -2;
    static final short ERROR_NOESPAI = -3;
    static final int ERROR_OPCIO = -4;

    public static void mostrarMenu() {//Funció que mostra menú per pantalla

        System.out.println(ESPAIS);
        System.out.println(MENU_OPCIO);
        System.out.println(MENU_OPCIO_1);
        System.out.println(MENU_OPCIO_2);
        System.out.println(MENU_OPCIO_3);
        System.out.println(MENU_OPCIO_4);
        System.out.println(MENU_OPCIO_SORTIR);
        System.out.println(ESPAIS);
    }

    public static void mostrarError(String textError) {//Funció per mostrar els errors per pantalla

        System.out.println(MISSATGE_SEPARADOR);
        System.out.println(ERROR_HEADER);
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println(textError);
        System.out.println(ESPAIS);

    }

    public static void mostrarIngresOK(String idBenzinera, int pos) { // Mostra un missatge d’inserció correcta de benzinera, amb el seu identificador i la filera de la matriu en la que es troba.
        System.out.println(MISSATGE_INGRES_OK + idBenzinera + MISSTAGE_CONTINUACIO_INGRES_OK + pos);
    }

    public static void mostrarLlistatBenzineres(String[][] dadesBenzineres, float[][] preusBenzina) {//Funció per imprimir titols i els array de dades

        System.out.println(ESPAIS);
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println(TITOL_LLISTAT);
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println(TITOL_DADES);
        System.out.println(MISSATGE_SEPARADOR);

        for (int i = 0; i < NUM_BENZINERES; i++) {//Bucles per mostrar les dades dels array
            if (!dadesBenzineres[i][UtilsBenzineres.ID_BENZINERA].equalsIgnoreCase("")) {

                System.out.printf(dadesBenzineres[i][UtilsBenzineres.ID_BENZINERA] + "      \t" + dadesBenzineres[i][UtilsBenzineres.CODI_POSTAL] + "      \t" + dadesBenzineres[i][UtilsBenzineres.PROPIETARI] + "      \t" + preusBenzina[i][UtilsBenzineres.PREU_SP] + "         \t" + preusBenzina[i][UtilsBenzineres.PREU_DI]);
                System.out.println(ESPAIS);
            }
        }
    }

    public static void mostrarMissatges(String missatge) {

        System.out.println(missatge);

    }

    public static String demanarString(String missatge, String missatgeError) {
        boolean buit = false;
        String usuariText = " ";
        Scanner scan = new Scanner(System.in);
        while (buit == false) {
            mostrarMissatges(missatge);
            usuariText = scan.nextLine();

            if (usuariText.isEmpty()) {

                mostrarError(MISSATGE_ERROR_STRING_BUIT);
                System.out.println(missatgeError);
            } else {
                buit = true;
            }
        }
        return usuariText;
    }

    public static float demanarFloat(String missatge, String missatgeError) {

        Scanner scanner = new Scanner(System.in);
        boolean esCorrecte;
        float usuariFloat = 0;
        do {
            mostrarMissatges(missatge);
            esCorrecte = scanner.hasNextFloat();
            if (esCorrecte) {
                usuariFloat = scanner.nextFloat();
            } else {
                scanner.next();
                mostrarError(missatgeError);
            }
        } while (!esCorrecte);
        return usuariFloat;
    }

    public static int demanarEnter(String missatge, String missatgeError) {
        mostrarMissatges(missatge);
        Scanner lector = new Scanner(System.in);
        boolean esCorrecte;
        int usuariInt = 0;
        do {
            esCorrecte = lector.hasNextInt();
            if (esCorrecte) {
                usuariInt = lector.nextInt();
            } else {
                lector.next();
                mostrarError(missatgeError);
                System.out.println("");
                mostrarMenu();
                mostrarMissatges(missatge);
            }
        } while (!esCorrecte);
        return usuariInt;
    }
}
