package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.DepartamentoDTO;
import com.residenciasquad9.demo.domain.entities.Departamento;
import com.residenciasquad9.demo.domain.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoService.findById(id);
        return departamento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        List<Departamento> departamentos = departamentoService.findAll();
        return ResponseEntity.ok(departamentos);
    }

    @PostMapping
    public ResponseEntity<Departamento> createDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = departamentoService.save(departamentoDTO);
        return ResponseEntity.ok(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody DepartamentoDTO departamentoDTO) {
        Departamento updatedDepartamento = departamentoService.update(id, departamentoDTO);
        return updatedDepartamento != null ? ResponseEntity.ok(updatedDepartamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id) {
        departamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

