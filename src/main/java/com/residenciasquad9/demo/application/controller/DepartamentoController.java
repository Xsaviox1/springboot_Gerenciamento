package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.DepartamentoDTO;
import com.residenciasquad9.demo.domain.entites.Departamento;
import com.residenciasquad9.demo.domain.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    // Criar Departamento
    @PostMapping
    public ResponseEntity<Departamento> criarDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = departamentoService.save(departamentoDTO);
        return new ResponseEntity<>(departamento, HttpStatus.CREATED);
    }

    // Buscar Departamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoService.findById(id);
        return departamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todos os Departamentos
    @GetMapping
    public ResponseEntity<List<Departamento>> buscarTodosDepartamentos() {
        List<Departamento> departamentos = departamentoService.findAll();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    // Atualizar Departamento
    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = departamentoService.update(id, departamentoDTO);
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    // Deletar Departamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
        departamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


