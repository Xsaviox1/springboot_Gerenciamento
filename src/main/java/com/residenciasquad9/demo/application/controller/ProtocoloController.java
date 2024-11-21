package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/protocolo")
public class ProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

    @GetMapping("/{id}")
    public ResponseEntity<Protocolo> getProtocoloById(@PathVariable String id) {
        Optional<Protocolo> protocolo = protocoloService.findById(id);
        return protocolo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/abrir")
    public ResponseEntity<Protocolo> abrirProtocolo(@RequestBody ProtocoloDTO protocoloDTO) {
        Protocolo protocolo = protocoloService.abrirProtocolo(protocoloDTO);
        return ResponseEntity.status(201).body(protocolo);
    }

    @GetMapping("/{id}/data")
    public ResponseEntity<Date> consultarDataProtocolo(@PathVariable String id) {
        Optional<Date> data = protocoloService.consultarDataProtocolo(id);
        return data.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Protocolo> atualizarStatus(@PathVariable String id, @RequestBody Status status) {
        Protocolo protocolo = protocoloService.atualizarStatusProtocolo(id, status);
        return ResponseEntity.ok(protocolo);
    }

    @GetMapping("/{id}/historico")
    public ResponseEntity<List<String>> consultarHistorico(@PathVariable String id) {
        List<String> historico = protocoloService.consultarHistoricoProtocolo(id);
        return ResponseEntity.ok(historico);
    }
}



