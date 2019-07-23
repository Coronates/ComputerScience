package com.endava;

public class vogelMethod {

        int[] demanda = {30, 20, 70, 30, 60};
        int[] oferta = {50, 60, 50, 50};
        int[][] costos = {{16, 16, 13, 22, 17}, {14, 14, 13, 19, 15},
                {19, 19, 20, 23, 50}, {50, 12, 50, 15, 11}};
        int nFilas = oferta.length;
        int nColumnas = demanda.length;
        boolean[] filaTerminada = new boolean[nFilas];
        boolean[] columnaTerminada = new boolean[nColumnas];
        int[][] result = new int[nFilas][nColumnas];

    //int remanente = sumaOferta(oferta);

    public vogelMethod() {

    }
    public int [] largestPenalty(int longi1, int longi2, boolean esFila ){
        int diferenciaMax= Integer.MIN_VALUE;
        int indexDiffMax, costoMin, indexCostoMin=-1;


    }




}
