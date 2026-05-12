package com.dev.batist.Navalha.mapper;

import com.dev.batist.Navalha.model.enums.Roles;

import java.util.List;

public record UsuarioResponse (
        Long id,
        String nome,
        String email,
        List<Roles> roles) {
}
