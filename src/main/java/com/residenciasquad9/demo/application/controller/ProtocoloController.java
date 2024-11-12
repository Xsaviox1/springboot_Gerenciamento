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
    public ResponseEntity<Protocolo> atualizarStatusProtocolo(@PathVariable String id, @RequestParam Status novoStatus) {
        Protocolo protocoloAtualizado = protocoloService.atualizarStatusProtocolo(id, novoStatus);
        return ResponseEntity.ok(protocoloAtualizado);
    }

    @GetMapping("/{id}/historico")
    public ResponseEntity<List<String>> consultarHistoricoProtocolo(@PathVariable String id) {
        List<String> historico = protocoloService.consultarHistoricoProtocolo(id);
        return ResponseEntity.ok(historico);
    }
}


