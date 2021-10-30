package com.mercado_libre.mercado_libre.controllers;

import com.mercado_libre.mercado_libre.entities.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonaController {
    ResponseEntity<?> save(@RequestBody Persona entity);
    ResponseEntity<?> getAll();
    ResponseEntity<?> getOne(@PathVariable Long id);
    ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona persona);
    ResponseEntity<?> delete(@PathVariable Long id);
    ResponseEntity<?> getStats();
}
