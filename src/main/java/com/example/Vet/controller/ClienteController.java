package com.example.Vet.controller;

import com.example.Vet.entities.Cliente;
import com.example.Vet.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        cliente = new Cliente(null, "João Carlos", "89898989", "joãoc@email.com");
        return clienteRepository.save(cliente);
    }

    @GetMapping()
    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

}