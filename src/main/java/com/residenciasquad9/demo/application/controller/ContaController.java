package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.entites.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/conta")
public class ContaController {
@Autowired
private final ContaService contaService;
public ContaController(ContaService contaService){
    this.contaService = contaService;
}
@GetMapping("/cpf/{cpf}")
    public ResponseEntity<Conta>buscarContaPorCPF(@PathVariable String cpf) {
        Conta conta = contaService.buscarContaPorCPF(cpf);
        if (conta != null) {
            return ResponseEntity.ok(conta);
        }
        return ResponseEntity.notFound().build();
    }
    // Endpoint para buscar conta por agência e número da conta
    @GetMapping("/agencia/{agencia}/numero/{numeroConta}")
    public ResponseEntity<Conta> buscarContaPorAgenciaENumero(@PathVariable String agencia, @PathVariable String numeroConta) {
        Conta conta = contaService.buscarContaPorAgenciaENumero(agencia, numeroConta);
        if (conta != null) {
            return ResponseEntity.ok(conta);
        }
        return ResponseEntity.notFound().build();
    }