package com.residenciasquad9.demo.application.controller;


import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.entites.Funcionario;
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import com.residenciasquad9.demo.domain.service.ProtocoloService;
import com.residenciasquad9.demo.domain.service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/protocolos")
public class ProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/abrir")
    public ResponseEntity<Protocolo> abrirProtocolo(@RequestBody ProtocoloDTO protocoloDTO, @RequestParam String cpf) {
        Optional<Funcionario> funcionarioOpt = Optional.ofNullable(funcionarioService.findById(cpf));
        if (funcionarioOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();
            Protocolo protocolo = protocoloService.abrirProtocolo(protocoloDTO, funcionario);
            return ResponseEntity.ok(protocolo);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/data")
    public ResponseEntity<Date> consultarDataProtocolo(@PathVariable String id) {
        Optional<Date> data = protocoloService.consultarDataProtocolo(id);
        return data.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/tipo")
    public ResponseEntity<Protocolo> atualizarTipoProtocolo(@PathVariable String id, @RequestBody TipoProtocolo novoTipo) {
        Protocolo protocolo = protocoloService.atualizarTipoProtocolo(id, novoTipo);
        return protocolo != null ? ResponseEntity.ok(protocolo) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Protocolo> atualizarStatusProtocolo(@PathVariable String id, @RequestBody Status novoStatus) {
        Protocolo protocolo = protocoloService.atualizarStatusProtocolo(id, novoStatus);
        return protocolo != null ? ResponseEntity.ok(protocolo) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/historico")
    public ResponseEntity<List<String>> consultarHistoricoProtocolo(@PathVariable String id) {
        List<String> historico = (List<String>) protocoloService.consultarHistoricoProtocolo(id);
        return historico != null ? ResponseEntity.ok(historico) : ResponseEntity.notFound().build();
    }
}




