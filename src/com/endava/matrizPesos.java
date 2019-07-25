package com.endava;

public class matrizPesos {
    int matrizFinal[][]={};

    public matrizPesos(int[][] matrizFinal) {
        this.matrizFinal = matrizFinal;
    }
    public matrizPesos() {
    }

    public int[][] getMatrizFinal() {
        return matrizFinal;
    }

    public void setMatrizFinal(int x, int y, int resultado) {
        matrizFinal[x][y]=resultado;
        matrizFinal[y][x]=resultado;


    }
}
