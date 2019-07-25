package com.endava;
/*algoritmo que representa el metodo Vogel*/

public class vogelMethod {

        int[] demanda = {};
        int[] oferta = {};
        int[][] pesos = {};
        int nColumnas;
        int nFilas;
        boolean[] filaTerminada;
        boolean[] columnaTerminada;
        int[][] pesosFinal;

    public vogelMethod(int[] supply, int[] demand, int [][] weight) {
        this.oferta=supply;
        this.demanda=demand;
        this.pesos=weight;
        int ofertaTotal=0;
        nColumnas = demanda.length;
        nFilas = oferta.length;
         filaTerminada = new boolean[nFilas];
         columnaTerminada = new boolean[nColumnas];
         pesosFinal = new int[nFilas][nColumnas];

        sumatoria s=new sumatoria();
        ofertaTotal=s.sumatoria(oferta);
        while (ofertaTotal>0){
            int[] unidad= filaVsCol();
            int indexMaxDiff=unidad[2];
            int indexMinCost=unidad[3];
            int allocator = Math.min(demanda[indexMinCost], oferta[indexMaxDiff]);
            demanda[indexMinCost] -= allocator;
            if (demanda[indexMinCost] == 0)
                columnaTerminada[indexMinCost] = true;

            oferta[indexMaxDiff] -= allocator;
            if (oferta[indexMaxDiff] == 0)
                filaTerminada[indexMaxDiff] = true;

            pesosFinal[indexMaxDiff][indexMinCost] = allocator;
            ofertaTotal -= allocator;


        }
        System.out.println("    A   B   C   D   E");
        for(int i =0; i<nFilas; i++){
            System.out.print((" "));
            for (int j = 0; j < nColumnas; ++j)
                System.out.print(pesosFinal[i][j]+"   ");
            System.out.println(" ");

        }


    }
    /* este metodo busca restar las dos unidades de distancia mas pequeñas para cada fila y columna
        adquiriendo el Penalty, retorna ademas del penalti, el valor del peso minimo y su posicion*/

    public int[] penalty( int j, int longitud, boolean esFila){
        int min= Integer.MAX_VALUE;
        int min2= Integer.MAX_VALUE;
        int indexMin=-1;
        for(int i=0; i<longitud; i++){
            boolean listo;
            if (esFila) {
                listo = columnaTerminada[i];
            } else {
                listo = filaTerminada[i];
            }
            if (listo) {
                continue;
            }
            /*se hallan los dos valores mas pequeños, ya sea de una fila o columna
             empiezan los dos minimos siendo "infinito", después el primer numero es mas pequeño, pero antes de igualarlo a min1 se debe guardar el que ahora es el segundo mas pequeño en m2 */
            int peso = esFila ? pesos[j][i] : pesos[i][j];
            if (peso < min) {
                min2 = min;
                min = peso;
                indexMin = i;
            }
            else if (peso < min2){
                min2 = peso;
            }
        }

      return new int[] {min2 - min, min, indexMin};
    }


    public int[] largestPenalty(int longi1, int longi2, boolean esFila ){
        int diferenciaMax= Integer.MIN_VALUE;
        int indexDiffMax= -1;
        int costoMin=-1;
        int indexCostoMin=-1;

        for (int i =0; i<longi1; i++ ){
            boolean listo;
            if (esFila){
                listo=filaTerminada[i];
            }else{
                listo=columnaTerminada[i];
            }
            if (listo){
                continue;
            }
            int[] localPenalty = penalty(i, longi2, esFila);
            if (localPenalty[0] > diferenciaMax) {
                diferenciaMax = localPenalty[0];
                indexDiffMax = i;
                costoMin = localPenalty[1];
                indexCostoMin = localPenalty[2];
            }


        }
        if (esFila) {
            return new int[]{diferenciaMax,costoMin, indexDiffMax, indexCostoMin };
        }else {
            return new int[]{diferenciaMax,costoMin,indexCostoMin, indexDiffMax};
        }
    }
    public int[] filaVsCol(){
        int lp1[]=largestPenalty(nFilas,nColumnas,true);
        int lp2[]=largestPenalty(nColumnas,nFilas,false);
        int option=-1;
        //comparar los penalties maximos.
        if(lp1[0] == lp2[0]){
            option=0;
        }else if(lp1[0] > lp2[0]){
            option=1;
        }
        switch(option){
            case 0: //rompo el tie, cojo arbitrariamente una de las dos
                if (lp1[1]<lp2[1]){
                    return lp1;
                }else{
                    return lp2;
                }
            case 1: //la diferencia o penalty del segundo es mas alto
                return lp2;
            default:
                return lp1;//retorno el primero

        }
    }


}
