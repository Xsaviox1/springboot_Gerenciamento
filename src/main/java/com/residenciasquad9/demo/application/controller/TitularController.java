package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.TitularDTO;
import com.residenciasquad9.demo.domain.entites.Titular;
import com.residenciasquad9.demo.domain.service.TitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/titulares")
public class TitularController {

    private final TitularService titularService;

    @Autowired
    public TitularController(TitularService titularService) {
        this.titularService = titularService;
    }

    // Criação de Titular
    @PostMapping
    public ResponseEntity<Titular> createTitular(@RequestBody TitularDTO titularDTO) {
        Titular titular = new Titular();
        titular.setNome(titularDTO.getNome());
        titular.setCpf(titularDTO.getCpf());
        titular.setEmail(titularDTO.getEmail());
        return ResponseEntity.ok(titularService.save(titular));
    }

    // Busca por CPF de Titular
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Titular> getTitularByCpf(@PathVariable String cpf) {
        Optional<Titular> titular = titularService.findByCpf(cpf);
        return titular.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir Titular
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTitular(@PathVariable Long id) {
        titularService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
