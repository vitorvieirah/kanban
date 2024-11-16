package com.example.kanban.service;

import com.example.kanban.model.Tarefa;
import com.example.kanban.model.enums.StatusTarefa;
import com.example.kanban.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TarefaService {

    private final TarefaRepository repository;

    public Tarefa cadastrar(Tarefa novaTarefa) {
        LocalDate dataCriacao = LocalDate.now();

        novaTarefa.setDataCriacao(dataCriacao);
        novaTarefa.setStatus(StatusTarefa.A_FAZER);

        return this.repository.save(novaTarefa);
    }

    public List<Tarefa> listarPorStatus() {
        List<Tarefa> tarefaList = this.repository.listarPorStatus();
        return tarefaList;
    }

    public Tarefa mudarDeStatus(Long id, StatusTarefa novoStatus) {
        Tarefa tarefaDomain = consultarPorId(id);
        boolean alterar = false;

        if(novoStatus.equals(StatusTarefa.A_FAZER)
            && tarefaDomain.getStatus().equals(StatusTarefa.EM_PROGRESSO)) {
            alterar = true;
        } else if (novoStatus.equals(StatusTarefa.CONCLUIDO)
                && tarefaDomain.getStatus().equals(StatusTarefa.EM_PROGRESSO)){
            alterar = true;
        } else if (tarefaDomain.getStatus().equals(StatusTarefa.A_FAZER)) {
            alterar = true;
        }

        if(alterar){
            tarefaDomain.setStatus(novoStatus);
        }

        return this.repository.save(tarefaDomain);
    }

    public Tarefa alterar(Long id, Tarefa novosDados) {
        Tarefa tarefaExistente = consultarPorId(id);

        tarefaExistente.alterar(novosDados);

        return this.repository.save(tarefaExistente);
    }

    public void deletar(Long id) {
        this.repository.deleteById(id);
    }

    private Tarefa consultarPorId(Long id) {
        Optional<Tarefa> tarefaExistente = this.repository.findById(id);

        if(tarefaExistente.isEmpty()) {
            System.out.println("Tarefa não encontrada");
        }

        return tarefaExistente.get();
    }

    public List<Tarefa> listarPorPrioridadeStatus() {
        return this.repository.listarPorPrioridadeStatus();
    }

    public List<Tarefa> consultarPorPrioridadeDataLimite() {
        return this.repository.listarPorPrioridadeDataLimite();
    }

    public List<Tarefa> getRelatorio() {
        List<Tarefa> tarefas = this.repository.listarPorStatus();

        return tarefas.stream().filter(tarefa ->
           tarefa.getDataLimite().isBefore(LocalDate.now())
                   && !tarefa.getStatus().equals(StatusTarefa.CONCLUIDO)
        ).toList();
    }
}
