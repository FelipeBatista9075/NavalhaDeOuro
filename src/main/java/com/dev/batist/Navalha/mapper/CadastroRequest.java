package com.dev.batist.Navalha.mapper;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CadastroRequest(
        @NotNull String nome,
        @NotNull @Email String email,
        @NotNull String senha
) {
}
