package com.kavex.nilu.application.usecase;

import com.kavex.nilu.domain.repository.PecaRepository;
import com.kavex.nilu.domain.repository.TarefaRepository;
import com.kavex.nilu.domain.service.NotificacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class ConcluirTarefaUseCase {

    private final TarefaRepository tarefaRepository;
    private final PecaRepository pecaRepository;
    private final NotificacaoService notificacaoService;

    public void executar(Long tarefaId) {
        var tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setDataConclusao(LocalDateTime.now());
        tarefa.setStatus("CONCLUIDA");
        tarefaRepository.save(tarefa);

        var peca = tarefa.getPeca();
        peca.setStatusEntrega("PRONTA");
        pecaRepository.save(peca);

        notificacaoService.notificarCliente(
                peca.getCliente(),
                "Olá! Sua peça está pronta e disponível para retirada no ateliê."
        );
    }
}
