package com.dev.batist.Navalha.mapper;

public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        boolean possuiUsuario
) {
}
