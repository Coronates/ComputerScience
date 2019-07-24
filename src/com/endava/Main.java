package com.endava;

public class Main {

    static int[] demanda = {190};
    static int[] oferta = {80, 40, 50, 20};
    static int[][] pesos = {{0, 1, 3, 22, 17}, {14, 14, 13, 19, 15},
            {29, 10, 150, 33, 50}, {0, 12, 50, 15, 11}};


    public static void main(String[] args) {
	// write your code here
      vogelMethod vvm= new vogelMethod(oferta,demanda,pesos);
    }
}
