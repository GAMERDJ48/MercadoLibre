package com.mercado_libre.mercado_libre.services;

import com.mercado_libre.mercado_libre.entities.Persona;
import com.mercado_libre.mercado_libre.repositories.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonaServiceTest {
    @MockBean
    private PersonaRepository repository;

    @Autowired
    private PersonaServiceImpl service;

    @Test
    void saveTest() {
        String dna = ("GGGGGA,CAAAGC,TAATGT,AAAAGG,CCCCTA,TCACTG");
        try {
            Persona persona = new Persona();
            persona.setDna(dna);
            when(repository.save(persona)).thenReturn(persona);
            assertEquals(service.save(persona).getDna(), persona.getDna());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateTest(){
        String dna = ("GGGGGA,CAAAGC,TAATGT,AAAAGG,CCCCTA,TCACTG");
        String nombre = "Juan Perez";
        Long id = 1L;
        Persona persona = new Persona();
        persona.setDna(dna);
        persona.setNombre(nombre);
        persona.setId(id);
        try {
            when(repository.save(persona)).thenReturn(persona);
            assertEquals(service.update(persona,id).getId(), persona.getId());
            assertEquals(service.update(persona,id).getDna(), persona.getDna());
            assertEquals(service.update(persona,id).getNombre(), persona.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteByIdTest(){
        Long id=500L;
        try {
            assertTrue(service.delete(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getStatsTest(){
        try {
            assertNotNull(service.getStats());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void findById(){
        Long id=1L;
        Persona persona = new Persona();
        persona.setId(id);
        persona.setNombre("Franco");
        when(repository.save(persona)).thenReturn(persona);
        try {
            assertEquals(persona, service.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAll(){
        var personas = new ArrayList<Persona>();
        Persona persona = new Persona("GGGGGA,CAAAGC,TAATGT,AAAAGG,CCCCTA,TCACTG");
        personas.add(persona);
        when(repository.findAll()).thenReturn(personas);
        try {
            assertEquals(service.findAll(), personas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
