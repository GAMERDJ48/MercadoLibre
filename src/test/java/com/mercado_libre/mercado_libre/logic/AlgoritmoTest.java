package com.mercado_libre.mercado_libre.logic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AlgoritmoTest {
    Algoritmo algoritmo;

    @Test
    void isMutantTest(){
        algoritmo = new Algoritmo();
        String[] dna = {"GTGCGA","CAGTGC","TTATGT","AGAACG","CCGCTA","TCACTG"};
        boolean resultado = algoritmo.isMutant(dna);
        assertFalse(resultado);

        String[] dna1 = {"GGGGGA","CAGTGC","TTATGT","AGATCG","CCGTTA","TCACTG"};
        resultado = algoritmo.isMutant(dna1);
        assertTrue(resultado);
    }


}
