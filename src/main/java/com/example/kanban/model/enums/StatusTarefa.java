package com.example.kanban.model.enums;

public enum StatusTarefa {
    A_FAZER(1),
    EM_PROGRESSO(2),
    CONCLUIDO(3);

    private int numero;

    StatusTarefa(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
