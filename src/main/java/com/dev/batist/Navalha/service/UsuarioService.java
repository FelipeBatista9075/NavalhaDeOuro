package com.dev.batist.Navalha.service;

import com.dev.batist.Navalha.mapper.NavalhaMapper;
import com.dev.batist.Navalha.mapper.UsuarioResponse;
import com.dev.batist.Navalha.model.Usuario;
import com.dev.batist.Navalha.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    //private final PasswordEncoder encoder;
    private final NavalhaMapper navalhaMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, NavalhaMapper navalhaMapper) {
        this.usuarioRepository = usuarioRepository;
        this.navalhaMapper = navalhaMapper;
    }

    public UsuarioResponse buscarPorId(Long id){
        return navalhaMapper.toResponse(buscarEntidadePorId(id));
    }
    public Usuario buscarEntidadePorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + email));
    }

    public List<UsuarioResponse> findAll() {
        return usuarioRepository.findAll().stream()
                .map(navalhaMapper::toResponse)
                .toList();
    }

    public UsuarioResponse atualizarUsuario(Long id, String email, String nome){
        Usuario usuario = buscarEntidadePorId(id);

        if(usuario.getEmail().equals(email)){
            if (usuarioRepository.existsByEmail(email)) {
                throw new RuntimeException("Email já cadastrado para outro usuário");
            }
            usuario.setEmail(email);
        }
        usuario.setNome(nome);
        return navalhaMapper.toResponse(usuarioRepository.save(usuario));
    }

    public void trocarSenha(Long id, String senhaAtual, String novaSenha){
        Usuario usuario = buscarEntidadePorId(id);
        if (!senhaAtual.equals(usuario.getSenha())) {
            throw new RuntimeException("Senha atual incorreta");
        }
        usuario.setSenha(novaSenha);
        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id){
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
        usuarioRepository.deleteById(id);
    }
    public boolean emailExiste(String emial){
        return usuarioRepository.existsByEmail(emial);
    }
}
