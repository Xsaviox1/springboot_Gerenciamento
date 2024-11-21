package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.ContaDTO;
import com.residenciasquad9.demo.domain.entites.Conta;
import com.residenciasquad9.demo.domain.service.ContaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<Conta> salvarConta(@RequestBody ContaDTO contaDTO) {
        Conta conta = contaService.save(contaDTO);
        return ResponseEntity.ok(conta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarContaPorId(@PathVariable int id) {
        Optional<Conta> contaOpt = contaService.findById(id);
        return contaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Conta> buscarContaPorCpf(@PathVariable String cpf) {
        Conta conta = contaService.buscarContaPorCPF(cpf);
        return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
    }

    @GetMapping("/agencia/{agencia}/numero/{numeroConta}")
    public ResponseEntity<Conta> buscarContaPorAgenciaENumero(@PathVariable String agencia, @PathVariable String numeroConta) {
        Conta conta = contaService.buscarContaPorAgenciaENumero(agencia, numeroConta);
        return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
    }
}

