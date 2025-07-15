package com.kavex.nilu.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrdemServicoInputDto(
        String cliente,
        String contato,
        String costureiraId,
        BigDecimal valorTotal,
        LocalDateTime dataEntregaPrevista
) {
}
