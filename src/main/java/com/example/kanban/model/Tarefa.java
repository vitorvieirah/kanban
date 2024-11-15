package com.example.kanban.model;


import com.example.kanban.model.enums.Prioridade;
import com.example.kanban.model.enums.StatusTarefa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Tarefa")
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    private String descricao;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Column(name = "data_limite")
    private LocalDate dataLimite;

    public void alterar(Tarefa novosDados) {
        this.titulo = novosDados.getTitulo();
        this.descricao = novosDados.getDescricao();
        this.status = novosDados.getStatus();
        this.prioridade = novosDados.getPrioridade();
        this.dataLimite = novosDados.getDataLimite();
    }
}
