/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.appbenzineres;

/**
 *
 * @author jsola
 */
public class AppEAC5P3 {

    public static final int NUM_BENZINERES = 15;

    static final int ENREGISTRAR = 1;
    static final int MOSTRAR = 2;
    static final int ORDENADES_SP = 3;
    static final int ORDENADES_DIESEL = 4;
    static final int SORTIR = 5;

    private boolean fi = true;
    private boolean intro = true;
    private boolean idPle = true;
    private boolean arrayCometes = true;
    EstructuraBenzineres estructuraTaula = new EstructuraBenzineres();

    public static void main(String[] args) {

        AppEAC5P3 prg = new AppEAC5P3();
        prg.inici();
    }

    private void inici() {

        while (arrayCometes == true) {//Crida la clase per emplenar els arrays de cometes.
            estructuraTaula.inicialitzaBenzineres();
            estructuraTaula.inicialitzaTaulaPreus();
            arrayCometes = false;
        }
        while (fi == true) {
            UtilsES.mostrarMenu();
            tractarMenu();
            intro = true;
        }
    }

    public void tractarMenu() {//Funció per tractar el menú
        idPle = true;
        while (intro == true) {//Quan l'id queda ple ja no en pot entrar, això es en cas de que l'id existeix
            int opcions = UtilsES.demanarEnter(UtilsES.MENU_TRIAR_OPCIO, UtilsES.MISSATGE_ERROR_NO_ENTER);
            if ((opcions < 0) || opcions >= 6) {
                intro = false;
                UtilsES.mostrarError(UtilsES.OPCIO_NO_VALIDA);//La variable mostrarà un error de opció incorrecte
            } else {
                switch (opcions) {//Condicional del menú
                    case ENREGISTRAR://Opció 1, enregistra una benzinera
                        enregistrar();//Crida a la funció per enregistrar
                        intro = false;
                        break;
                    case MOSTRAR://Opciò per invocar mostrar benzineres
                        mostrar();//Crida a la funció permostrarel llistat de benzineres.
                        intro = false;
                        break;
                    case ORDENADES_SP://Opciò per ordenar benzineres per preu benzina sense plom.
                        ordenadesSP();//Crida a la funció per ordenar les benzineres per preu benzina sense plom.
                        intro = false;
                        break;
                    case ORDENADES_DIESEL://Opciò per ordenar benzineres per preu gasoil.
                        ordenadesDiesel();//Crida a la funció perordenar les benzineres per preu gasoil.
                        intro = false;
                        break;
                    case SORTIR://Opcó per sortir del programa
                        intro = false;
                        fi = false;
                        UtilsES.mostrarMissatges(UtilsES.MISSATGE_ACOMIAT);//Mostra l'acomiat
                        break;
                }
            }
        }
    }

    public void enregistrar() { //Funciò que va cridant les clases per enregistrar una benzinera.

        int res;
        String introduirString;
        while (idPle == true) {
            fi = true;
            idPle = true;
            introduirString = estructuraTaula.introduccioDades(idPle);
            // introduirString = UtilsES.demanarString(UtilsES.MISSATGE_INTRODUIR_STRING, UtilsES.MISSTAGE_NO_INTRUIT_RES);//Primer invoca la introducció de l'id
            res = UtilsBenzineres.cercaBenzinera(introduirString, estructuraTaula.dadesBenzineres);//Una vegada introduït l'id recerca la benzinera per si existeix
            if (res == UtilsES.ERROR) {//Condicionals per mostrar errors
                UtilsES.mostrarError(UtilsES.MISSATGE_ERROR_COLISIO);
                idPle = true;
            } else {
                res = UtilsBenzineres.cercaPosBuida(estructuraTaula.dadesBenzineres);//Si la benzinera no es troba a l'array contiua per cercar una posició a l'array
                if (res == UtilsES.ERROR) {
                    UtilsES.mostrarError(UtilsES.MISSATGE_ERROR_NOESPAI);
                } else {
                    idPle = false;
                    estructuraTaula.introduccioDades(idPle);
                    //Invoquem la introducció de dades per la resta de dades
                    //Si tot està bé, enregistrarà tot
                    UtilsBenzineres.enregistrarBenzinera(estructuraTaula.idBenzinera, estructuraTaula.codiPostal, estructuraTaula.nomPropietari, estructuraTaula.preuSP, estructuraTaula.preuDiesel, estructuraTaula.dadesBenzineres, estructuraTaula.preusBenzina);
                    fi = true;
                    UtilsES.mostrarIngresOK(estructuraTaula.idBenzinera, res); //Mostrarà ok per pantalla
                }
            }
        }
    }

    public void mostrar() {//Funciò que crida les clases per mostar les benzineres.

        UtilsES.mostrarLlistatBenzineres(estructuraTaula.dadesBenzineres, estructuraTaula.preusBenzina);//Index per mostrar el titol de llistat per pantalla
        intro = false;
    }

    public void ordenadesSP() {//Funciò que crida les clases per ordenar les benzineres per preu benzina sense plom.

        int[] index = UtilsBenzineres.indexBenzineresPerPreuCombustible(estructuraTaula.preusBenzina, UtilsBenzineres.PREU_SP);
        estructuraTaula.reordenaTaulesPerIndex(index);
        UtilsES.mostrarLlistatBenzineres(estructuraTaula.dadesBenzineres, estructuraTaula.preusBenzina);
    }

    public void ordenadesDiesel() {//Funciò que crida les clases per ordenar les benzineres per preu gasoil.

        int[] index = UtilsBenzineres.indexBenzineresPerPreuCombustible(estructuraTaula.preusBenzina, UtilsBenzineres.PREU_DI);
        estructuraTaula.reordenaTaulesPerIndex(index);
        UtilsES.mostrarLlistatBenzineres(estructuraTaula.dadesBenzineres, estructuraTaula.preusBenzina);
    }
}
