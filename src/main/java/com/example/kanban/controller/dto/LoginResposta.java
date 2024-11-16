package com.example.kanban.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResposta {

    private String username;
    private String token;
}
