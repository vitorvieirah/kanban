package com.example.kanban.repository;

import com.example.kanban.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT ta FROM Tarefa ta ORDER BY ta.status")
    List<Tarefa> listarPorStatus();

    @Query("SELECT t FROM Tarefa t ORDER BY t.status, t.prioridade")
    List<Tarefa> listarPorPrioridadeStatus();

    @Query("SELECT t FROM Tarefa t ORDER BY t.dataLimite, t.prioridade")
    List<Tarefa> listarPorPrioridadeDataLimite();
}

