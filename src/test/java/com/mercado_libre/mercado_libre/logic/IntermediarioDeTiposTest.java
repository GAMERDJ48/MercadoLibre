package com.mercado_libre.mercado_libre.logic;

import com.mercado_libre.mercado_libre.exceptions.ArregloException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class IntermediarioDeTiposTest {
    @Test
    void convertString(){
        String dna="";
        assertThrows(ArregloException.class, ()->IntermediarioDeTipos.convertString(dna));

    }
}
