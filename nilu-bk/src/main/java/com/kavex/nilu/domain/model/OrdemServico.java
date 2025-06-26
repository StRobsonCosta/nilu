package com.kavex.nilu.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
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
