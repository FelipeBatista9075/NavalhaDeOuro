package com.dev.batist.Navalha.controller;

import com.dev.batist.Navalha.model.Barbeiro;
import com.dev.batist.Navalha.repository.BarbeiroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/barbeiros")
public class BarbeiroController {

    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroController(BarbeiroRepository barbeiroRepository) {
        this.barbeiroRepository = barbeiroRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbeiro> findBarbeiroById(@PathVariable Long id) {
        return barbeiroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Barbeiro> findBarbeiroByEmail(@PathVariable String email) {
        return barbeiroRepository.findAll().stream()
                .filter(barbeiro -> barbeiro.getUsuario() != null && barbeiro.getUsuario().getEmail() != null)
                .filter(barbeiro -> barbeiro.getUsuario().getEmail().equalsIgnoreCase(email))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Barbeiro> saveBarbeiro(@RequestBody Barbeiro barbeiro) {
        Barbeiro savedBarbeiro = barbeiroRepository.save(barbeiro);
        return ResponseEntity.ok(savedBarbeiro);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteBarbeiro(@PathVariable Long id) {
        if (barbeiroRepository.existsById(id)) {
            barbeiroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Barbeiro> updateBarbeiro(@PathVariable Long id, @RequestBody Barbeiro barbeiro) {
        if (!barbeiroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        barbeiro.setId(id);
        Barbeiro updatedBarbeiro = barbeiroRepository.save(barbeiro);
        return ResponseEntity.ok(updatedBarbeiro);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Barbeiro>> findAllBarbeiro() {
        List<Barbeiro> barbeiros = barbeiroRepository.findAll();
        return ResponseEntity.ok(barbeiros);
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<List<Barbeiro>> findBarbeiroByNomeContainingIgnoreCase(@PathVariable String nome) {
        List<Barbeiro> barbeiros = barbeiroRepository.findAll().stream()
                .filter(barbeiro -> barbeiro.getUsuario() != null && barbeiro.getUsuario().getNome() != null)
                .filter(barbeiro -> barbeiro.getUsuario().getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
        return ResponseEntity.ok(barbeiros);
    }
}
