package com.kavex.nilu.application.usecase;


import com.kavex.nilu.domain.model.Tarefa;
import com.kavex.nilu.domain.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CriarTarefaUseCase {

    private final TarefaRepository tarefaRepository;

    public void executar(Tarefa tarefa) {
        tarefa.setDataInicio(LocalDateTime.now());
        tarefa.setStatus("EM_ANDAMENTO");
        tarefaRepository.save(tarefa);
    }
}
