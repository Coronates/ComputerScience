package com.endava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class leerArchivo {
    static int matrizPeso[][]={};

    public String leerArchivo(String filePath)
    {
        ArrayList<Integer> pesos = new ArrayList<>();
        ArrayList<String> nodos = new ArrayList<>();
        ArrayList<String> tipos = new ArrayList<>();
        ArrayList<String> origenes = new ArrayList<>();
        ArrayList<String> destinos = new ArrayList<>();


        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String line;
            int cont=0;
            while ((line = br.readLine()) != null)
            {
                String datosCadaLinea[] = line.split(",");

                if (datosCadaLinea.length <= 2) {
                    cont++;
                    nodos.add(datosCadaLinea[0]);
                    tipos.add(datosCadaLinea[1]);
                    Nodo n= new Nodo(cont, datosCadaLinea[0],datosCadaLinea[1]);

                }else{
                    int n=nodos.size();
                    int matrixx[][]= new int[n][n];
                    for (int i=0; i<matrixx.length;i++){
                        for (int j=0; j<matrixx.length;j++){
                            if (matrixx[i][j]==0) {

                            }
                        }
                    }

                    int x= nodos.indexOf(datosCadaLinea[0]);
                    int y= nodos.indexOf(datosCadaLinea[1]);
                    matrixx[x][y]=Integer.parseInt(datosCadaLinea[2]);
                    matrixx[y][x]=Integer.parseInt(datosCadaLinea[2]);

                    origenes.add(datosCadaLinea[0]);
                    destinos.add(datosCadaLinea[1]);
                    pesos.add(Integer.parseInt(datosCadaLinea[2]));
                    Arista ar= new Arista(datosCadaLinea[0],datosCadaLinea[1],Integer.parseInt(datosCadaLinea[2]));

                }
                contentBuilder.append(line).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }






        return contentBuilder.toString();
    }
    public int[][] matrizPesos(int tamano, int fila, int columna, int valor){

        return matrizPeso;
    }
}
