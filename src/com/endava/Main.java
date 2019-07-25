package com.endava;

public class Main {

    static int[] demanda = {190};
    static int[] oferta = {80, 40, 50, 20};
    static int[][] pesos = {{0, 1, 3, 22, 17}, {14, 14, 13, 19, 15},
            {29, 10, 150, 33, 50}, {0, 12, 50, 15, 11}};
    static int[][] totales={};


    public static void main(String[] args) {
	// write your code here
      //vogelMethod vvm= new vogelMethod(oferta,demanda,pesos);
        //String grafo = "C:\\Users\\LENOVO\\IdeaProjects\\ComputerScience\\src\\files\\ChallengeGraph";
        String grafo = "C:\\Users\\acoronado\\IdeaProjects\\ComputerSciences\\src\\files\\ChallengeGraph";
        leerArchivo lA=new leerArchivo();
        String resultado=lA.leerArchivo(grafo);
        System.out.println(resultado);
        matrizPesos mP=new matrizPesos();

        totales= lA.tabla();
        System.out.println(totales.length);



        for (int i=0; i<totales.length;i++){
            for (int j=0; j<totales.length;j++){
                System.out.print(totales[i][j]);
            }
            System.out.println(" ");
        }




        // Adding edges one by one.


    }
//    public int[][] getMatrix(){
//
//
//    }
}
