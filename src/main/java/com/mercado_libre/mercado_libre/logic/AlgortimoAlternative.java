package com.mercado_libre.mercado_libre.logic;

public class AlgortimoAlternative {
    int cantidadSec=0;

    public boolean isMutant(String[] dna){
        boolean resultado;
        if(dna.length<=3){
            return false;
        }
        resultado=comparacionHorizontal(dna);
        if(resultado) return true;
        resultado=comparacionVertical(dna);
        if(resultado) return true;
        resultado=comparacionOblicuaID(dna);
        if(resultado) return true;
        resultado=comparacionOblicuaDI(dna);
        if(resultado) return true;
        return false;
    }

    private boolean comparacionHorizontal(String [] dna){
        for (int i=0; i<dna.length; i++){
            for(int j=0; j<dna[0].length(); j+=2){
                if(j<(dna.length-2)){
                    if (!(dna[i].charAt(j) != dna[i].charAt(j+2))) {
                        if(dna[i].charAt(j) == dna[i].charAt(j+1)){
                            if(dna[i].charAt(j) == dna[i].charAt(j+3)){
                                cantidadSec++;
                                if(cantidadSec>1)return true;
                                break;
                            }else{
                                if((j-1)>=0 && dna[i].charAt(j) == dna[i].charAt(j-1)){
                                    cantidadSec++;
                                    if(cantidadSec>1)return true;
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

    private boolean comparacionVertical(String [] dna){
        for (int i=0; i<dna.length; i++){
            for(int j=0; j<dna[0].length(); j+=2){
                if(j<(dna.length-2)){
                    if (!(dna[j].charAt(i) != dna[j+2].charAt(i))) {
                        if(dna[j].charAt(i) == dna[j+1].charAt(i)){
                            if(dna[j].charAt(i) == dna[j+3].charAt(i)){
                                cantidadSec++;
                                if(cantidadSec>1)return true;
                                break;
                            }else{
                                if((j-1)>=0 && dna[j].charAt(i) == dna[j-1].charAt(i)){
                                    cantidadSec++;
                                    if(cantidadSec>1)return true;
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

    private boolean comparacionOblicuaID(String[] dna) {
        //------------------Comparacion Oblicua Izquierda a Derecha-----------------//
        boolean repetir;
        int aux = 0;
        final int CASO = 3;
        int largo = dna.length - CASO - 1;
        int repaso = 1, fila,columna;
        do {
            do {
                repetir = true;
                if (repaso == 1) {
                    fila = 0;
                    columna = largo - aux;
                } else {
                    fila = largo - aux;
                    columna = 0;
                }
                for (int i = 0; i <= (CASO + aux); i += 2) {
                    int colum = columna + i;
                    int fil = fila + i;
                    if ((colum) == (fil) && repaso == 1) {
                        repetir = false;  break;
                    }
                    if (((dna.length-CASO)>=colum && repaso==1) || ((dna.length-CASO)>=fil && repaso==0)) {
                        if (dna[fil].charAt(colum) == dna[fil + 2].charAt(colum + 2)) {
                            if (dna[fil].charAt(colum) == dna[fil + 1].charAt(colum + 1)) {
                                if (((fil - 1) >= 0 && (colum - 1) >= 0) && (dna[fil].charAt(colum) == dna[fil - 1].charAt(colum - 1))) {
                                    cantidadSec++;
                                    if(cantidadSec>1)return true;
                                    if (colum == fil) repetir = false;
                                    break;
                                } else {
                                    if (((dna.length - CASO+1) >= (colum + 3) && repaso == 1) || ((dna.length-1) >= (fil + 3) && repaso == 0)) {
                                        if ((dna[fil].charAt(colum) == dna[fil + 3].charAt(colum + 3))) {
                                            cantidadSec++;
                                            if(cantidadSec>1)return true;
                                            if (colum == fil) repetir = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (colum == fil) repetir = false;
                    }
                }
                aux++;
            } while (repetir);
            repaso--;
            aux = 0;
        } while (repaso >= 0);
        return false;
    }

    private boolean comparacionOblicuaDI (String [] dna){
        //-----------------------Comparacion Oblicua de Derecha a izquierda-------------------------------//
        int largo=3, repaso=1, aux=0, contador=0, fila, columna;
        boolean repetir;
        char caracter;
        do {
            do {
                repetir=true;
                if(repaso==1){
                    fila=0;
                    columna=largo + aux;
                }else{
                    fila=dna.length-1-largo-aux;
                    columna=dna.length-1;
                }

                caracter = dna[fila].charAt(columna);

                for (int i = 1; i <= (largo+aux); i++) {
                    int colum=columna-i;
                    int fil=fila+i;
                    if((colum==dna.length-2 && fil==1) && repaso==1){
                        repetir=false;
                        break;
                    }
                    if (caracter != dna[fil].charAt(colum)) {
                        contador = 0;

                        if(((dna.length-largo)>(colum) && repaso==1) || ((dna.length-largo)<=(fil) && repaso!=1)){
                            if((fil+colum)==dna.length-1){
                                repetir=false;
                            }
                            break;
                        }
                        caracter = dna[fil].charAt(colum);

                    } else {
                        contador++;
                    }
                    if (contador == largo) {
                        cantidadSec++;
                        if(cantidadSec>1){
                            return true;
                        }
                        if((fil+colum)==dna.length-1){
                            repetir=false;
                        }
                        break;
                    }
                }
                aux++;
            } while (repetir);
            repaso--;
            aux=0;

        }while(repaso>=0);
        return false;
    }

}
