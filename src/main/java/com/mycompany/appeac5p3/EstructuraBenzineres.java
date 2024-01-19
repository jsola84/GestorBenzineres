/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appeac5p3;

/**
 *
 * @author jsola
 */
public class EstructuraBenzineres {

    static final int NUM_BENZINERES = 15;

    String[][] dadesBenzineres = new String[NUM_BENZINERES][UtilsES.DADES_BENZINERES];
    float[][] preusBenzina = new float[NUM_BENZINERES][UtilsES.DADES_PREUS];
    String idBenzinera, codiPostal, nomPropietari;
    float preuSP = 0, preuDiesel = 0;

    public String[][] inicialitzaBenzineres() {

        for (int i = 0; i < NUM_BENZINERES; i++) {
            dadesBenzineres[i][UtilsBenzineres.ID_BENZINERA] = "";
            dadesBenzineres[i][UtilsBenzineres.CODI_POSTAL] = "";
            dadesBenzineres[i][UtilsBenzineres.PROPIETARI] = "";
        }
        return dadesBenzineres;
    }

    public float[][] inicialitzaTaulaPreus() {

        for (int i = 0; i < NUM_BENZINERES; i++) {
            preusBenzina[i][UtilsBenzineres.PREU_SP] = 0f;
            preusBenzina[i][UtilsBenzineres.PREU_DI] = 0f;
        }
        return preusBenzina;
    }

    public void reordenaTaulesPerIndex(int[] indexOrdenats) {

        String[][] taulaAuxiliarDadesBenzineres;
        float[][] taulaAuxiliarPreusBenzina;
        taulaAuxiliarDadesBenzineres = UtilsBenzineres.copiaTaulaString(dadesBenzineres);
        taulaAuxiliarPreusBenzina = UtilsBenzineres.copiaTaulaFloat(preusBenzina);

        for (int i = 0; i < NUM_BENZINERES; i++) {
            dadesBenzineres[i][UtilsBenzineres.ID_BENZINERA] = taulaAuxiliarDadesBenzineres[indexOrdenats[i]][UtilsBenzineres.ID_BENZINERA];
            dadesBenzineres[i][UtilsBenzineres.CODI_POSTAL] = taulaAuxiliarDadesBenzineres[indexOrdenats[i]][UtilsBenzineres.CODI_POSTAL];
            dadesBenzineres[i][UtilsBenzineres.PROPIETARI] = taulaAuxiliarDadesBenzineres[indexOrdenats[i]][UtilsBenzineres.PROPIETARI];
            preusBenzina[i][UtilsBenzineres.PREU_SP] = taulaAuxiliarPreusBenzina[indexOrdenats[i]][UtilsBenzineres.PREU_SP];
            preusBenzina[i][UtilsBenzineres.PREU_DI] = taulaAuxiliarPreusBenzina[indexOrdenats[i]][UtilsBenzineres.PREU_DI];
        }
    }

    public String introduccioDades(boolean idPle) {//Funci'o per la introducció de dades

        if (idPle == true) {//Si l'id es dins l'array ja no entra a l'opció
            idBenzinera = UtilsES.demanarString(UtilsES.MISSATGE_INTRODUCCIO_IDBENZINERA, UtilsES.MISSTAGE_NO_INTRUIT_RES);
        } else {
            //Introdució del codi postal
            codiPostal = UtilsES.demanarString(UtilsES.MISSATGE_INTRODUCCIO_CODI_POSTAL, UtilsES.MISSATGE_ERROR_STRING_BUIT);
            //Introducció del nom de propietari
            nomPropietari = UtilsES.demanarString(UtilsES.MISSATGE_INTRODUCCIO_NOM_PROPIETARI, UtilsES.MISSATGE_ERROR_STRING_BUIT);
            //Introducció de benzina sense plom
            preuSP = UtilsES.demanarFloat(UtilsES.MISSATGE_INTRODUCCIO_S_PLOM, UtilsES.MISSATGE_ERROR_NO_FLOAT);
            //Introducció de gasoil
            preuDiesel = UtilsES.demanarFloat(UtilsES.MISSATGE_INTRODUCCIO_GASOIL, UtilsES.MISSATGE_ERROR_NO_FLOAT);
        }
        return idBenzinera;
    }
}
