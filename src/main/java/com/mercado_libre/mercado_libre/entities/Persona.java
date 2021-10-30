package com.mercado_libre.mercado_libre.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Persona {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nombre;
    @Lob @Column(name = "dna", nullable = false)
    private String dna;
    private boolean mutante;

    public Persona(String dna){
        this.dna=dna;
    }
}
