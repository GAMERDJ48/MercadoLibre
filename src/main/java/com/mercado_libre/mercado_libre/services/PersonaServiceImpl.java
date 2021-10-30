package com.mercado_libre.mercado_libre.services;


import com.mercado_libre.mercado_libre.entities.Persona;
import com.mercado_libre.mercado_libre.logic.AlgortimoAlternative;
import com.mercado_libre.mercado_libre.logic.IntermediarioDeTipos;
import com.mercado_libre.mercado_libre.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository repositorio;

    private AlgortimoAlternative algoritmo;

    public PersonaServiceImpl(PersonaRepository repositorio){
        this.repositorio=repositorio;
        this.algoritmo=new AlgortimoAlternative();
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {

        try{
            boolean resultado = algoritmo.isMutant(IntermediarioDeTipos.convertString(entity.getDna()));
            entity.setMutante(resultado);
            repositorio.save(entity);
            if(resultado){
                return entity;
            }else{
                throw new Exception("No es un mutante");
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception{
        try{
            return repositorio.findAll();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception{
        try{
            Optional<Persona> persona= repositorio.findById(id);
            if(persona.isPresent()) return persona.get();
            else{
                throw new Exception("No se encuentra la entidad");
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Persona persona, Long id) throws Exception{
        try{

            Optional<Persona> personaOptional = repositorio.findById(id);
            Persona p = personaOptional.get();
            boolean resultado = algoritmo.isMutant(IntermediarioDeTipos.convertString(persona.getDna()));
            persona.setMutante(resultado);
            p = repositorio.save(persona);
            return p;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception{
        try{
            if(repositorio.existsById(id)){
                repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("No se encontro la entidad");
            }

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public String getStats() throws Exception{
        try{
            List<Persona> personas = repositorio.findAll();
            int count_mutant=0;
            int count_person=0;
            for(Persona i: personas){
                if(i.isMutante()){
                    count_mutant++;
                }
            }
            float ratio;
            count_person = personas.size()-count_mutant;
            if(count_person==0){
                ratio=0;
            }else{
                ratio = count_mutant/count_person;
            }
            return "count_mutant_dna: "+count_mutant+", count_human_dna: "+count_person+", ratio: "+ratio;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
