package com.mercado_libre.mercado_libre.logic;

import com.mercado_libre.mercado_libre.exceptions.ArregloException;

public class IntermediarioDeTipos {
    public static String[] convertString(String cadena) throws ArregloException {
        if(cadena.equals("") || cadena==null){
            throw new ArregloException("El arreglo esta vacio");
        }
        int tamanio=-1;

        do{
            tamanio++;
            if(cadena.length()<=tamanio){
                throw new ArregloException("El arreglo NO presenta el formato correcto");
            }
        }while(cadena.charAt(tamanio)!=',');

        var arreglo = new String[tamanio];
        int anterior=0;
        tamanio=0;
        int i;
        String aux;
        for (i=0; i<cadena.length(); i++){
            char caracter = cadena.charAt(i);
            if(caracter==','){
                aux = cadena.substring(anterior, i);
                if(aux.length()==arreglo.length){
                    arreglo[tamanio] = aux;
                    anterior=i+1;
                    tamanio++;
                }else{
                    throw new ArregloException("El arreglo NO es cuadrado");
                }
            }else{
                if(!(caracter=='G' || caracter=='A' || caracter=='C' || caracter=='T')){
                    throw new ArregloException("El arreglo NO presenta caracteres validos");
                }
            }
        }
        aux=cadena.substring(anterior,i);
        if(aux.length()==arreglo.length){
            arreglo[tamanio]=aux;
        }else{
            throw new ArregloException("El arreglo NO es cuadrado");
        }
        return arreglo;
    }
}
