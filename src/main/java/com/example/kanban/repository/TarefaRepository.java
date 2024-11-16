package com.example.kanban.repository;

import com.example.kanban.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("""
            SELECT ta FROM Tarefa ta 
            ORDER BY 
                CASE ta.status
                    WHEN 'A_FAZER' THEN 1
                    WHEN 'EM_PROGRESSO' THEN 2
                    WHEN 'CONCLUIDO' THEN 3
                END 
            """)
    List<Tarefa> listarPorStatus();

    @Query("""
            SELECT ta FROM Tarefa ta 
            ORDER BY 
                CASE ta.prioridade
                    WHEN 'ALTA' THEN 1
                    WHEN 'MEDIA' THEN 2
                    WHEN 'BAIXA' THEN 3
                END,
                CASE ta.status
                    WHEN 'A_FAZER' THEN 1
                    WHEN 'EM_PROGRESSO' THEN 2
                    WHEN 'CONCLUIDO' THEN 3
                END 
            """)
    List<Tarefa> listarPorPrioridadeStatus();

    @Query("""
            SELECT ta FROM Tarefa ta 
            ORDER BY 
                CASE ta.prioridade
                    WHEN 'ALTA' THEN 1
                    WHEN 'MEDIA' THEN 2
                    WHEN 'BAIXA' THEN 3
                END,
            ta.dataLimite
            """)
    List<Tarefa> listarPorPrioridadeDataLimite();
}

