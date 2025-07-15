package com.kavex.nilu.infra;

import com.kavex.nilu.domain.model.Costureira;
import com.kavex.nilu.domain.model.EtapaAjuste;
import com.kavex.nilu.domain.model.OrdemServico;
import com.kavex.nilu.domain.repository.OrdemServicoRepository;
import com.kavex.nilu.domain.service.EmailService;
import com.kavex.nilu.dto.OrdemServicoInputDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Function;

@Component("novaOrdemHandler")
public class NovaOrdemLambda implements Function<OrdemServicoInputDto, String> {
    private final OrdemServicoRepository ordemRepo;
    private final EmailService emailService;

    public NovaOrdemLambda(OrdemServicoRepository ordemRepo, EmailService emailService) {
        this.ordemRepo = ordemRepo;
        this.emailService = emailService;
    }

    @Override
    public String apply(OrdemServicoInputDto dto) {
        var ordem = new OrdemServico();
        ordem.setCliente(dto.cliente());
        ordem.setContato(dto.contato());
        ordem.setEtapa(EtapaAjuste.RECEBIDO);
        ordem.setValorTotal(dto.valorTotal());
        ordem.setDataRecebimento(LocalDateTime.now());
        ordem.setDataEntregaPrevista(dto.dataEntregaPrevista());

        var costureira = new Costureira();
        costureira.setId(UUID.fromString(dto.costureiraId()));
        ordem.setCostureira(costureira);

        ordem.setComissaoCostureira(
                ordem.getValorTotal().multiply(BigDecimal.valueOf(0.4)) // Exemplo ... mudar depois
        );

        ordemRepo.save(ordem);

        emailService.enviarEmail(dto.contato(), "Nova Ordem Criada",
                "Olá, sua ordem foi registrada no Ateliê. Aguarde o aviso de conclusão!");

        return "Ordem criada com sucesso.";
    }
}
