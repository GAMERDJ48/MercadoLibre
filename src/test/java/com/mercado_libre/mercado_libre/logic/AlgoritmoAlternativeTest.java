package com.mercado_libre.mercado_libre.logic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AlgoritmoAlternativeTest {
    AlgortimoAlternative algoritmo;

    @Test
    void isMutant(){
        String[] dna= {"GGGGGA","CGTTTC","TTAAGT","ATAAAG","CCTTAA","TCATTA"};
        algoritmo=new AlgortimoAlternative();
        boolean resultado = algoritmo.isMutant(dna);
        assertTrue(resultado);
    }
}
