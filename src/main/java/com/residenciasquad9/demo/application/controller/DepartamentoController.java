package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.DepartamentoDTO;
import com.residenciasquad9.demo.domain.entities.Departamento;
import com.residenciasquad9.demo.domain.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Departamento> createDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = departamentoService.save(departamentoDTO);
        return ResponseEntity.ok(departamento);
    }
}