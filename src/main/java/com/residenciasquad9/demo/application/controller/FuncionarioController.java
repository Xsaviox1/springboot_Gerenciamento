package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.FuncionarioDTO;
import com.residenciasquad9.demo.domain.entites.Funcionario;
import com.residenciasquad9.demo.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Criar Funcionario
    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioService.criarFuncionario(funcionarioDTO);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    // Atribuir Protocolo ao Funcionario
    @PutMapping("/{cpf}/protocolo/{protocoloId}")
    public ResponseEntity<Funcionario> atribuirProtocolo(@PathVariable String cpf, @PathVariable String protocoloId) {
        Funcionario funcionario = funcionarioService.atribuirProtocoloAoFuncionario(cpf, protocoloId);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    // Atribuir Cargo ao Funcionario
    @PutMapping("/{cpf}/cargo/{cargoId}")
    public ResponseEntity<Funcionario> atribuirCargo(@PathVariable String cpf, @PathVariable Long cargoId) {
        Funcionario funcionario = funcionarioService.atribuirCargoAoFuncionario(cpf, cargoId);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    // Atribuir Departamento ao Funcionario
    @PutMapping("/{cpf}/departamento/{departamento}")
    public ResponseEntity<Funcionario> atribuirDepartamento(@PathVariable String cpf, @PathVariable String departamento) {
        Funcionario funcionario = funcionarioService.atribuirDepartamentoAoFuncionario(cpf, departamento);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }
}



