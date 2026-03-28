package com.example.Vet.pets;


import com.example.Vet.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    private String nome;
    private String especie;
    private int idade;
    private String sexo;

    @ManyToOne
    @JsonIgnore
    private Cliente cliente;


}

