package com.dev.batist.Navalha.service;

import com.dev.batist.Navalha.model.Cliente;
import com.dev.batist.Navalha.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public boolean existsByEmail(String email) {
        return clienteRepository.findByUsuarioEmail(email)
                .filter(cliente -> cliente.getUsuario() != null)
                .isPresent();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente criarWalkIn(String nome,String telefone){
        if (telefone == null || telefone.isBlank()) {
            throw new RuntimeException("Telefone é obrigatório");
        }

        String telefoneLimpo = telefone.replaceAll("\\D", "");

        if (telefoneLimpo.length() < 4) {
            throw new RuntimeException("Telefone inválido");
        }

        if (clienteRepository.existsByTelefone(telefoneLimpo)) {
            throw new RuntimeException("Telefone já cadastrado para outro cliente");
        }
        String sufixo = telefoneLimpo.substring(telefoneLimpo.length() - 4);

        if (nome == null || nome.isBlank()) {
            nome = "Walk-in #" + sufixo;
        } else {
            nome = nome + " #" + sufixo;
        }

        Cliente cliente = new Cliente();
        cliente.setTelefone(telefoneLimpo);
        cliente.setNome(nome);

        return clienteRepository.save(cliente);
    }

    public java.util.List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

}
