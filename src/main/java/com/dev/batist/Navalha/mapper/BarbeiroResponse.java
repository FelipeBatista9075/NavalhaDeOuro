package com.dev.batist.Navalha.mapper;

public record BarbeiroResponse(
        Long id,
        String nome,
        String email,
        String especialidade,
        String nivel,
        boolean ativo
){}