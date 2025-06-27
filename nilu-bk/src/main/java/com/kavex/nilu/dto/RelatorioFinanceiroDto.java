package com.kavex.nilu.dto;

import java.math.BigDecimal;

public record RelatorioFinanceiroDto(
        String nomeCostureira,
        BigDecimal totalReceitaGerada,
        BigDecimal totalPagoEmComissoes
) {
}
