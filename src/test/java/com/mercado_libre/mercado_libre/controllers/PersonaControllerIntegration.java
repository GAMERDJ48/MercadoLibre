package com.mercado_libre.mercado_libre.controllers;


import com.mercado_libre.mercado_libre.MercadoLibreApplication;
import com.mercado_libre.mercado_libre.services.PersonaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//
@SpringBootTest(classes = MercadoLibreApplication.class)
@AutoConfigureMockMvc
public class PersonaControllerIntegration  {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaServiceImpl service;

    @Test
    void saveTest() throws Exception {
        mockMvc.perform(post("/api/v1/mutant/").content("{\n" +
                                "\"dna\":\"GGGGGA,CAAAGC,TAATGT,AAAAGG,CCCCTA,TCACTG\"\n" +
                                "}")
                            .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk());
    }

    @Test
    void getStatsTest() throws Exception{
        mockMvc.perform(get("/api/v1/mutant/stats")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllTest() throws Exception{
        mockMvc.perform(get("/api/v1/mutant/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateTest() throws Exception{
        mockMvc.perform(put("/api/v1/mutant/1")
                        .content("{\n" +
                                "    \"id\": 1,\n" +
                                "    \"nombre\":\"Franco\",\n" +
                                "    \"dna\":\"AGAT,TGAT,GGTT,GGTT\"\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /*
    @Test
    void deleteTest() throws Exception{
        Long id=7L;
        Persona persona=new Persona();
        persona.setId(id);
        persona.setNombre("Raul");
        persona.setDna("GGGGGA,CAAAGC,TAATGT,AAAAGG,CCCCTA,TCACTG");
        service.save(persona);
        mockMvc.perform(delete("/api/v1/mutant/"+id, id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

     */
}
