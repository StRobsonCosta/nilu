package com.kavex.nilu.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

public class Costureira {

    @Id @GeneratedValue
    private UUID id;
    private String nome;
    private String email;
    private BigDecimal percentualComissao;
}
