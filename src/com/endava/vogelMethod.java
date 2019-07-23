package com.endava;

public class vogelMethod {
    int[] demanda = {30, 20, 70, 30, 60};
    int[] oferta = {50, 60, 50, 50};
    int[][] costos = {{16, 16, 13, 22, 17}, {14, 14, 13, 19, 15},
            {19, 19, 20, 23, 50}, {50, 12, 50, 15, 11}};
    int nFilas = oferta.length;
    int nColumnas = demanda.length;

    int remanente = sumaOferta(oferta);


    public int sumaOferta(int[] supply){
        int remanente=0;
        for (int i=0; i < supply.length; i++){
            remanente+=supply[i];
        }
       return remanente;
    }

}
