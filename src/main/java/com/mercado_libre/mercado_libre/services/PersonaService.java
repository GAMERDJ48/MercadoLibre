package com.mercado_libre.mercado_libre.services;

import com.mercado_libre.mercado_libre.entities.Persona;

import java.util.List;

public interface PersonaService {
    Persona save(Persona entity) throws Exception;
    List<Persona> findAll() throws Exception;
    Persona findById(Long id) throws Exception;
    Persona update(Persona persona, Long id) throws Exception;
    boolean delete(Long id) throws Exception;
    String getStats() throws Exception;
}
