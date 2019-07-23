package com.endava;
/*algoritmo que representa el metodo Vogel*/

public class vogelMethod {

        int[] demanda = {30, 20, 70, 30, 60};
        int[] oferta = {50, 60, 50, 50};
        int[][] pesos = {{16, 16, 13, 22, 17}, {14, 14, 13, 19, 15},
                {19, 19, 20, 23, 50}, {50, 12, 50, 15, 11}};
        int nFilas = oferta.length;
        int nColumnas = demanda.length;
        boolean[] filaTerminada = new boolean[nFilas];
        boolean[] columnaTerminada = new boolean[nColumnas];
        int[][] result = new int[nFilas][nColumnas];

    //int remanente = sumaOferta(oferta);

    public vogelMethod() {

    }
    /* este metodo busca restar las dos unidades de distancia mas pequeñas para cada fila y columna
        adquiriendo el Penalty, retorna ademas del penalti, el valor del peso minimo y su posicion*/

    public int[] penalty(int longitud, int j, boolean esFila){
        int min= Integer.MAX_VALUE;
        int min2= Integer.MAX_VALUE;
        int indexMin=-1;
        for(int i=0; i<longitud; i++){
            if (esFila ? columnaTerminada[i] : filaTerminada[i])
                continue;
            int peso = esFila ? pesos[j][i] : pesos[i][j];
            if (peso < min) {
                min2 = min;
                min = peso;
                indexMin = i;
            } else if (peso < min2)
                min2 = peso;
        }
        int[] retorno= new int[] {min2 - min, min, indexMin};
      return retorno;
    }


    public int[] largestPenalty(int longi1, int longi2, boolean esFila ){
        int diferenciaMax= Integer.MIN_VALUE;
        int indexDiffMax, costoMin, indexCostoMin= -1;


    }




}
