package com.kavex.nilu.controller;

import com.kavex.nilu.domain.service.OrdemServicoService;
import com.kavex.nilu.dto.AtualizaEtapaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ordens")
@RequiredArgsConstructor
public class OrdemServicoController {

    private final OrdemServicoService service;

    @PatchMapping("/{id}/etapa")
    public ResponseEntity<Void> atualizarEtapa(@PathVariable UUID id, @RequestBody AtualizaEtapaRequest dto) {
        service.atualizarEtapa(id, dto.etapa());
        return ResponseEntity.noContent().build();
    }
}
