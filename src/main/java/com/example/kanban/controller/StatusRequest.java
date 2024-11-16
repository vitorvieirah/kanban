package com.example.kanban.controller;

import com.example.kanban.model.enums.StatusTarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StatusRequest {
    private StatusTarefa status;
}
