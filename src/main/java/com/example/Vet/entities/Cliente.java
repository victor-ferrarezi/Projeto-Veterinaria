package com.example.Vet.entities;

import com.example.Vet.pets.Pet;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Pet> pets;

}
