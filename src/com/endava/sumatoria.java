package com.endava;

public class sumatoria {
    //metodo que hace la sumatoria total del vector de la oferta o demanda y lo retorna
    public int sumatoria(int[] vector){
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            suma += vector[i];
        }
        return suma;
    }
}
