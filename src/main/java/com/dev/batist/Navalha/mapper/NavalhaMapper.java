package com.dev.batist.Navalha.mapper;

import com.dev.batist.Navalha.model.Barbeiro;
import com.dev.batist.Navalha.model.Usuario;
import com.dev.batist.Navalha.model.Cliente;

import java.util.Set;

public class NavalhaMapper {

    public UsuarioResponse toResponse(Usuario u) {
        return new UsuarioResponse(
                u.getId(),
                u.getNome(),
                u.getEmail(),
                u.getRoles()
        );
    }

    public BarbeiroResponse toResponse(Barbeiro b) {

        String email = b.getUsuario() != null
                ? b.getUsuario().getEmail()
                : "N/A";

        return new BarbeiroResponse(
                b.getId(),
                b.getNome(),
                email,
                b.getEspecialidade().name(),
                b.getNivel().name(),
                b.getAtivo()
        );
    }

    public ClienteResponse toResponse(Cliente c) {

        String nome = c.getUsuario() != null
                ? c.getUsuario().getNome()
                : "Walk-in";

        String email = c.getUsuario() != null
                ? c.getUsuario().getEmail()
                : "N/A";

        return new ClienteResponse(
                c.getId(),
                nome,
                email,
                c.getTelefone(),
                c.getUsuario() != null
        );
    }
}