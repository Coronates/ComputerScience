package com.endava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class leerArchivo {
    static int matrizFinal[][]={};
    static int totales[][] ={};

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
            boolean flag=true;
            matrizPesos mP=new matrizPesos();
            while ((line = br.readLine()) != null)
            {
                String datosCadaLinea[] = line.split(",");

                if (datosCadaLinea.length <= 2) {
                    //cont++;
                    nodos.add(datosCadaLinea[0]);
                    tipos.add(datosCadaLinea[1]);
                    //Nodo n= new Nodo(cont, datosCadaLinea[0],datosCadaLinea[1]);

                }else{
                    int n=nodos.size();
                    int matrixx[][]= metodoPesos(n);
                    if(flag) {
                        mP = new matrizPesos(matrixx);
                        flag=false;
                    }


                    int x= nodos.indexOf(datosCadaLinea[0]);
                    int y= nodos.indexOf(datosCadaLinea[1]);
                    matrixx[x][y]=Integer.parseInt(datosCadaLinea[2]);
                    matrixx[y][x]=Integer.parseInt(datosCadaLinea[2]);
                    mP.setMatrizFinal(x,y,Integer.parseInt(datosCadaLinea[2]));
                    totales= mP.getMatrizFinal();


                    System.out.println(matrixx[x][y]);


                    origenes.add(datosCadaLinea[0]);
                    destinos.add(datosCadaLinea[1]);
                    pesos.add(Integer.parseInt(datosCadaLinea[2]));

                }
                contentBuilder.append(line).append("\n");

            }



        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("//////////"+totales.length);
        return contentBuilder.toString();
    }
    public int[][] metodoPesos(int n){
        int matrizPeso[][]=new int[n][n];
        for (int i=0; i<n;i++){
            for (int j=0; j<n;j++){
                matrizPeso[i][j]=0;
            }
        }

        return matrizPeso;
    }
    public int[][] tabla(){
        return totales;
    }
}
