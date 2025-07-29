package com.kavex.nilu.controller;

import com.kavex.nilu.application.usecase.ConcluirTarefaUseCase;
import com.kavex.nilu.application.usecase.CriarTarefaUseCase;
import com.kavex.nilu.domain.model.Tarefa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final CriarTarefaUseCase criarTarefaUseCase;
    private final ConcluirTarefaUseCase concluirTarefaUseCase;

    @PostMapping
    public ResponseEntity<Void> criarTarefa(@RequestBody Tarefa tarefa) {
        criarTarefaUseCase.executar(tarefa);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/concluir")
    public ResponseEntity<Void> concluirTarefa(@PathVariable Long id) {
        concluirTarefaUseCase.executar(id);
        return ResponseEntity.ok().build();
    }
}
