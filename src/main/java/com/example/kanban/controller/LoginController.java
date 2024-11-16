package com.example.kanban.controller;

import com.example.kanban.controller.dto.Login;
import com.example.kanban.controller.dto.LoginResposta;
import com.example.kanban.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {

    private final LoginService service;

    @PostMapping("/login")
    public LoginResposta logar(@RequestBody Login dadosLogin) {
        return service.autenticar(dadosLogin);
    }
}
