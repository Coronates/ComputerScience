package com.endava;

public class Dijkstra {
    public void  Dijkstra(int [][] matriz){
        int vertices= matriz.length;
        boolean[] flag=new boolean[vertices];
        int[] distancia= new int[vertices];
        distancia[0]=0;
        for(int i=1; i<vertices;i++){
            distancia[i]= Integer.MAX_VALUE;
        }
        for(int i=0; i<vertices;i++){
            int minimo=traerMinimo(distancia,flag);
            flag[minimo]=true;
            //otros
            for(int j=0; j< vertices; j++){
                if(!flag[j] && matriz[minimo][j]!=0 && distancia[minimo]!=Integer.MAX_VALUE){
                    int sumatoria=matriz[minimo][j]+distancia[minimo];
                    if(sumatoria< distancia[j]){
                        distancia[j]=sumatoria;
                    }
                }
            }
        }
        for(int i=0; i<vertices;i++){
            System.out.println(i+"  "+distancia[i]);

        }


    }

    private int traerMinimo(int[] distancia, boolean[] flag) {
        int min= -1;
        for(int i=0; i<distancia.length;i++){
            if (!flag[i] && (min==-1 || distancia[i]<distancia[min])) {
                 min=i;
                }
            }

        return min;
    }
}
