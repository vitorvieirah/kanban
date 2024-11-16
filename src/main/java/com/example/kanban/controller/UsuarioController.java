package com.example.kanban.controller;

import com.example.kanban.model.Usuario;
import com.example.kanban.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping()
    public Usuario cadastrar(@RequestBody Usuario novoUsuario) {
        return this.service.cadastrar(novoUsuario);
    }

}
