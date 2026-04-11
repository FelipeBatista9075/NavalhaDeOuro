package com.dev.batist.Navalha.repository;

import com.dev.batist.Navalha.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByUsuarioNome(String nome);
    Optional<Cliente> findByUsuarioEmail(String email);
    Optional<Cliente> findByTelefone(String telefone);
    List<Cliente> findByUsuarioIsNull(String nome);
    List<Cliente> findByUsuarioIsNotNull();
    boolean existsByTelefone(String telefone);
}
