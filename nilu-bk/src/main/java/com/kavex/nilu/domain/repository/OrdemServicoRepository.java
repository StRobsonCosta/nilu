package com.kavex.nilu.domain.repository;

import com.kavex.nilu.domain.model.OrdemServico;
import com.kavex.nilu.dto.RelatorioFinanceiroDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, UUID> {

    @Query("""
    SELECT new br.com.ateliecostura.dto.RelatorioFinanceiroDto(
        c.nome,
        SUM(o.valorTotal),
        SUM(o.comissaoCostureira)
    )
    FROM OrdemServico o
    JOIN o.costureira c
    WHERE o.dataRecebimento BETWEEN :inicio AND :fim
    GROUP BY c.nome
""")
    List<RelatorioFinanceiroDto> gerarRelatorio(LocalDate inicio, LocalDate fim);
}
