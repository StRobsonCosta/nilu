package com.kavex.nilu.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Costureira {

    @Id @GeneratedValue
    private UUID id;
    private String nome;
    private String email;
    private BigDecimal percentualComissao;
}
