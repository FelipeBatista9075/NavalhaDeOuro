package com.dev.batist.Navalha.model;

import com.dev.batist.Navalha.model.enums.Especialidade;
import com.dev.batist.Navalha.model.enums.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "barbeiro")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Nivel nivel;
    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private Boolean ativo = true;
}
