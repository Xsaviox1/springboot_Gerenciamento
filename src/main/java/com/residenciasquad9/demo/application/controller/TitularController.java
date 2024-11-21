package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.entites.Titular;
import com.residenciasquad9.demo.domain.service.TitularService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/titulares")
public class TitularController {

    @Autowired
    private TitularService titularService;

    @PostMapping
    public ResponseEntity<Titular> salvarTitular(@RequestBody Titular titular) {
        Titular salvo = titularService.save(titular);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Titular> buscarTitularPorCpf(@PathVariable String cpf) {
        Optional<Titular> titularOpt = titularService.findByCpf(cpf);
        return titularOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Titular> buscarTitularPorId(@PathVariable Long id) {
        Optional<Titular> titularOpt = titularService.findById(id);
        return titularOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTitular(@PathVariable Long id) {
        titularService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

