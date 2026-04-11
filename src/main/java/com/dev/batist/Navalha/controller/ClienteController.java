package com.dev.batist.Navalha.controller;


import com.dev.batist.Navalha.model.Cliente;
import com.dev.batist.Navalha.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/walk-in")
    public ResponseEntity<Cliente> criarWalkIn(@RequestParam(required = false) String nome,@RequestParam String telefone) {
        if (telefone == null || telefone.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Cliente cliente = clienteService.criarWalkIn(nome, telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }
}
