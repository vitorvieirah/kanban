package com.example.kanban.service;

import com.example.kanban.controller.dto.Login;
import com.example.kanban.controller.dto.LoginResposta;
import com.example.kanban.model.Usuario;
import com.example.kanban.service.seguranca.AutenticacaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {


    private final AutenticacaoService autenticacaoService;
    private final UsuarioService usuarioService;

    public LoginResposta autenticar(Login dadosLogin) {
        Usuario usuario = this.usuarioService.consultarPorUsername(dadosLogin.getUsername());

        if (!usuario.getPassword().equals(dadosLogin.getPassword())) {
            throw new RuntimeException("Senha incorreta !");
        }

        String token = this.autenticacaoService.gerarToken(usuario);
        return new LoginResposta(usuario.getUsername(), token);
    }
}
