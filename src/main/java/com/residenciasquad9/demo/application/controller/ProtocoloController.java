package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.application.serviceimpl.ProtocoloImplService;
import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/protocolo")
public class ProtocoloController {
@Autowired
    private ProtocoloService protocoloService;
@GetMapping("/{id}")
public ResponseEntity<Protocolo> getProtocoloById(@PathVariable int id){
    Optional<Protocolo> protocolo= protocoloService.findById(id);
    return protocolo.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}
@PostMapping()
    public Protocolo createProtocolo(@RequestBody ProtocoloDTO protocolo) {
        return protocoloService.save(protocolo);
    }
}
