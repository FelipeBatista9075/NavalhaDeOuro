package com.dev.batist.Navalha.model;

import com.dev.batist.Navalha.model.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String nome;
    @Column(nullable = false ,unique = true)
    @NotBlank
    @Email
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String senha;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "usuario_role",
            joinColumns = @JoinColumn(
                    name = "usuario_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private List<Roles> roles;
}
