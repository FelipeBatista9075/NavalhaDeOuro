package com.dev.batist.Navalha.service;

import com.dev.batist.Navalha.model.Barbeiro;
import com.dev.batist.Navalha.repository.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository) {
        this.barbeiroRepository = barbeiroRepository;
    }

    public Barbeiro salvar(Barbeiro barbeiro) {
        return barbeiroRepository.save(barbeiro);
    }

    public Barbeiro atualizar(Barbeiro barbeiro) {
        if (barbeiro.getId() == null || !barbeiroRepository.existsById(barbeiro.getId())) {
            throw new IllegalArgumentException("Barbeiro não encontrado para atualização");
        }
        return barbeiroRepository.save(barbeiro);
    }

    public List<Barbeiro> findByNomeContainingIgnoreCase(String nome) {
        return barbeiroRepository.findAll().stream()
                .filter(barbeiro -> barbeiro.getUsuario() != null && barbeiro.getUsuario().getNome() != null)
                .filter(barbeiro -> barbeiro.getUsuario().getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }

    public List<Barbeiro> getAllBarbeiros() {
        return barbeiroRepository.findAll();
    }

    public void deleteBarbeiro(Long id) {
        barbeiroRepository.deleteById(id);
    }
}
