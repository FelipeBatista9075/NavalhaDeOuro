package com.dev.batist.Navalha.mapper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BarbeiroRequest(
        @NotNull Long id,
        @NotNull String especialidade,
        @NotNull String nivel,
        @NotBlank String cpf
){}


