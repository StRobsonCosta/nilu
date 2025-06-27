package com.kavex.nilu.controller;

import com.kavex.nilu.domain.repository.OrdemServicoRepository;
import com.kavex.nilu.dto.RelatorioFinanceiroDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final OrdemServicoRepository repository;

    @GetMapping("/financeiro")
    public List<RelatorioFinanceiroDto> relatorioFinanceiro(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        return repository.gerarRelatorio(inicio, fim);
    }
}
