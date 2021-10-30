package com.mercado_libre.mercado_libre.logic;

public class Algoritmo {
    //Esta constante indica la cantidad de letras seguidas sin contar la primera para formar una secuencia que cumpla con un mutante
    public static final int CASO=3;
    int contador;
    int fila;
    int columna;
    char caracter;
    int cantidadSec=0;
    String [] dna;

    public boolean isMutant(String[] arreglo){
        dna = arreglo;
        if(dna.length<=CASO){
            return false;
        }

        comparacionHorizontal();
        if(cantidadSec>1)return true;
        comparacionVertical();
        if(cantidadSec>1)return true;
        comparacionOblicuaDI();
        if(cantidadSec>1)return true;
        comparacionOblicuaID();
        if(cantidadSec>1)return true;
        return false;
    }

    private void comparacionOblicuaID(){
        //------------------Comparacion Oblicua Izquierda a Derecha-----------------//
        boolean repetir;
        int aux=0;
        //Variable que indica el comienzo de la letra a comparar
        int largo=dna.length - CASO-1;
        //Repaso es para repetir el mismo proceso pero empezando del otro lado de la matriz
        int repaso=1;
        contador=0;
        do {
            do {
                repetir=true;
                if(repaso==1){
                    fila=0;
                    columna=largo - aux;
                }else{
                    fila=largo - aux;
                    columna=0;
                }

                caracter = dna[fila].charAt(columna);

                for (int i = 1; i <= (CASO+aux); i++) {

                    int colum=columna+i;
                    int fil=fila+i;
                    if((colum)==(fil) && repaso==1){
                        repetir=false;
                        break;
                    }
                    if (caracter != dna[fil].charAt(colum)) {
                        contador = 0;

                        if(((dna.length-CASO)<=(colum) && repaso==1) || ((dna.length-CASO)<=(fil) && repaso!=1)){
                            if(colum==fil){
                                repetir=false;
                            }
                            break;
                        }
                        caracter = dna[fil].charAt(colum);

                    } else {
                        contador++;
                    }
                    if (contador == CASO) {
                        cantidadSec++;

                        if(cantidadSec>=2){
                            return;
                        }
                        if(colum==fil){
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
    }

    private void comparacionOblicuaDI (){
        //-----------------------Comparacion Oblicua de Derecha a izquierda-------------------------------//
        int largo=CASO;
        int repaso=1;
        int aux=0;
        contador=0;
        boolean repetir;
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

                for (int i = 1; i <= (CASO+aux); i++) {
                    int colum=columna-i;
                    int fil=fila+i;
                    if((colum==dna.length-2 && fil==1) && repaso==1){
                        repetir=false;
                        break;
                    }
                    if (caracter != dna[fil].charAt(colum)) {
                        contador = 0;

                        if(((dna.length-CASO)>(colum) && repaso==1) || ((dna.length-CASO)<=(fil) && repaso!=1)){
                            if((fil+colum)==dna.length-1){
                                repetir=false;
                            }
                            break;
                        }
                        caracter = dna[fil].charAt(colum);

                    } else {
                        contador++;
                    }
                    if (contador == CASO) {
                        cantidadSec++;
                        if(cantidadSec>1){
                            return;
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
    }

    private void comparacionHorizontal (){


        //-------------Comparacion Horizontal---------------//

        for (int i=0; i<dna.length; i++){
            caracter=dna[i].charAt(0);
            columna=0;
            contador=0;
            for(int j=1; j<dna[0].length(); j++){
                //Es para que si en la columna actual quedan menos de 3 letras no siga comparando esa fila
                if ((dna[0].length() - columna) <= CASO) {
                    break;
                }
                //Si son diferentes las letras comparadas
                if (caracter != dna[i].charAt(j)) {
                    caracter = dna[i].charAt(j);
                    columna = j;
                    contador = 0;
                }
                //Si son iguales
                else {
                    contador++;
                }
                //Cuando contador es igual a CASO significa que encontra una secuencia seguida de (CASO+1) letras iguales
                if (contador == CASO) {
                    //EN CASO DE QUE SE NECESITE COMPROBAR LA VERACIDAD DEL ALGORITMO descomentar la siguente linea:
                    //System.out.println("COMPARACION HORIZONTAL ----- Caracter= " + caracter);
                    cantidadSec++;
                    if(cantidadSec>1){
                        return;
                    }
                    break;
                }

            }
        }
    }

    private  void comparacionVertical(){
        //---------------------Comparacion Vertical----------------------------//
        //Es lo mismo que en la comparacion horizontal, solo cambian algunos detalles

        for (int i=0; i<dna[0].length(); i++){
            caracter=dna[0].charAt(i);
            fila=0;
            contador=0;
            for(int j=1; j<dna.length; j++){
                if ((dna.length - fila) <= CASO) {
                    break;
                }
                if(caracter!=dna[j].charAt(i)){
                    caracter=dna[j].charAt(i);
                    contador=0;
                    fila=j;
                }else{
                    contador++;
                }
                if(contador==CASO){
                    //System.out.println("COMPARACION VERTICAL ---- Caracter= "+caracter);
                    cantidadSec++;
                    if(cantidadSec>1){
                        return;
                    }
                    break;
                }
            }
        }

    }

}