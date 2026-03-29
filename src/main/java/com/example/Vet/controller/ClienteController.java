package com.example.Vet.controller;

import com.example.Vet.entities.Cliente;
import com.example.Vet.repository.ClienteRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping()
    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Cliente> list(@PathVariable Long id) {
        return Collections.singletonList(clienteRepository.findById(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }

    @PutMapping({"/{id}"})
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteUpdate = clienteRepository.findById(id).orElse(null);

        if (clienteUpdate != null) {

            clienteUpdate.setNome(cliente.getNome());
            clienteUpdate.setTelefone(cliente.getTelefone());
            clienteUpdate.setEmail(cliente.getEmail());

            return clienteRepository.save(clienteUpdate);

        }
            return null;
    }





}