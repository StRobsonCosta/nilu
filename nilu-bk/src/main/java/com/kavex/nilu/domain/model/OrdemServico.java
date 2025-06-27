package com.kavex.nilu.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdemServico {

    @Id @GeneratedValue
    private UUID id;
    private String cliente;
    private String contato;
    private LocalDateTime dataRecebimento;
    private LocalDateTime dataEntregaPrevista;
    private LocalDateTime dataConclusao;
    private BigDecimal valorTotal;
    private BigDecimal comissaoCostureira;

    @Enumerated(EnumType.STRING)
    private EtapaAjuste etapa;

    @ManyToOne
    private Costureira costureira;

}
