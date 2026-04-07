package com.dev.batist.Navalha.service;

import com.dev.batist.Navalha.model.Usuario;
import com.dev.batist.Navalha.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizar(Usuario usuario) {
        if (usuario.getId() == null || !usuarioRepository.existsById(usuario.getId())) {
            throw new IllegalArgumentException("Usuário não encontrado para atualização");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarSenha(Usuario usuario) {
        if (usuario.getId() == null || !usuarioRepository.existsById(usuario.getId())) {
            throw new IllegalArgumentException("Usuário não encontrado para atualização de senha");
        }
        Usuario usuarioExistente = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado para atualização de senha"));
        usuarioExistente.setSenha(usuario.getSenha());
        return usuarioRepository.save(usuarioExistente);
    }

    public boolean emailExiste(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }
}
