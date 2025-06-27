package com.kavex.nilu.domain.service;

import com.kavex.nilu.domain.model.EtapaAjuste;
import com.kavex.nilu.domain.model.OrdemServico;
import com.kavex.nilu.domain.repository.OrdemServicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrdemServicoService {

    private final OrdemServicoRepository ordemRepo;
    private final EmailService emailService;

    @Transactional
    public OrdemServico atualizarEtapa(UUID id, EtapaAjuste novaEtapa) {
        var ordem = ordemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada"));

        ordem.setEtapa(novaEtapa);

        if (novaEtapa == EtapaAjuste.PRONTO) {
            ordem.setDataConclusao(LocalDateTime.now());
            emailService.enviarEmail(
                    ordem.getContato(),
                    "Roupa pronta!",
                    "Olá, sua roupa está pronta para retirada no ateliê."
            );
        }

        return ordemRepo.save(ordem);
    }

    @Transactional
    public OrdemServico salvarOrdem(OrdemServico ordem) {
        var costureira = ordem.getCostureira();
        var comissao = ordem.getValorTotal()
                .multiply(costureira.getPercentualComissao())
                .divide(BigDecimal.valueOf(100));

        ordem.setComissaoCostureira(comissao);
        return ordemRepo.save(ordem);
    }
}
