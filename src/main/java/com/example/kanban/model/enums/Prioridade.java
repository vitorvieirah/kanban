package com.example.kanban.model.enums;





public enum Prioridade {
    BAIXA(3),
    MEDIA(2),
    ALTA(1);

    private int numero;

    Prioridade(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
