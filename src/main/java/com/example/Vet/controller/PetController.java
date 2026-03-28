package com.example.Vet.controller;

import com.example.Vet.pets.Pet;
import com.example.Vet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @PostMapping
    public Pet salvar(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    @GetMapping()
    public List<Pet> list(){
        return petRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@RequestParam Long id){
        petRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Pet atualizar(@PathVariable Long id, @RequestBody Pet dados){

        Pet pet = petRepository.findById(id).orElse(null);

        if (pet != null) {
            pet.setNome(dados.getNome());
            pet.setEspecie(dados.getEspecie());
            pet.setIdade(dados.getIdade());
            pet.setSexo(dados.getSexo());

            return petRepository.save(pet);
        }

        return null;
    }
}

