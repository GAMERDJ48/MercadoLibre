package com.mercado_libre.mercado_libre.controllers;
import com.mercado_libre.mercado_libre.entities.Persona;
import com.mercado_libre.mercado_libre.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/mutant")
public class PersonaControllerImpl implements PersonaController {
    @Autowired
    protected PersonaServiceImpl servicio;
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Persona entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }//jbkjhkjhkj
    @Override
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona persona){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(persona, id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @Override
    @GetMapping("/stats")
    public ResponseEntity<?> getStats(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.getStats());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
