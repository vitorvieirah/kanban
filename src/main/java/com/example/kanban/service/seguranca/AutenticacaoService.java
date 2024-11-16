package com.example.kanban.service.seguranca;

import com.example.kanban.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AutenticacaoService {

    private final TokenService tokenService;

    public String gerarToken(Usuario usuario) {
        return tokenService.geradorToken(usuario.getUsername());
    }

    public String validaToken(String token) {
        return tokenService.validaToken(token);
    }



}
