package com.example.kanban.service;

import com.example.kanban.model.Usuario;
import com.example.kanban.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario cadastrar(Usuario usuario) {
        return this.repository.save(usuario);
    }

    public Usuario consultarPorUsername(String username) {
        Optional<Usuario> usuario = this.repository.findByUsername(username);

        if(usuario.isEmpty()) {
            throw new RuntimeException("Usuario não encontrado");
        }

        return usuario.get();
    }
}
