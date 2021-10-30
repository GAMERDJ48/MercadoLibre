package com.mercado_libre.mercado_libre.repositories;

import com.mercado_libre.mercado_libre.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
