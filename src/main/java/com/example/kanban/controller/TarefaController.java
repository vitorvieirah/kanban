package com.example.kanban.controller;

import com.example.kanban.controller.dto.StatusRequest;
import com.example.kanban.model.Tarefa;
import com.example.kanban.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public Tarefa cadastrar(@RequestBody Tarefa novaTarefa) {
        return this.service.cadastrar(novaTarefa);
    }

    @GetMapping
    public List<Tarefa> listarPorStatus() {
        return this.service.listarPorStatus();
    }

    @GetMapping("/prioridade")
    public List<Tarefa> listarPorPrioridadeStatus() {
        return this.service.listarPorPrioridadeStatus();
    }

    @GetMapping("/prioridade/data-limite")
    public List<Tarefa> consultarPorPrioridadeDataLimite() {
        return this.service.consultarPorPrioridadeDataLimite();
    }

    @GetMapping("/relatorio")
    public List<Tarefa> getRelatorio() {
        return this.service.getRelatorio();
    }

    @PatchMapping("/{id}/move")
    public Tarefa mudarDeStatus(@RequestBody StatusRequest novoStatus, @PathVariable("id") Long id) {
        return this.service.mudarDeStatus(id, novoStatus.getStatus());
    }

    @PutMapping("/{id}")
    public Tarefa alterar(@RequestBody Tarefa novosDados, @PathVariable("id") Long id) {
        return this.service.alterar(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        this.service.deletar(id);
    }
}
