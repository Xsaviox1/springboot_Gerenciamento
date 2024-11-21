package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.CargoDTO;
import com.residenciasquad9.demo.domain.entites.Cargo;
import com.residenciasquad9.demo.domain.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    // Criar Cargo
    @PostMapping
    public ResponseEntity<Cargo> criarCargo(@RequestBody CargoDTO cargoDTO) {
        Cargo cargo = cargoService.save(cargoDTO);
        return new ResponseEntity<>(cargo, HttpStatus.CREATED);
    }

    // Buscar Cargo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cargo> buscarCargoPorId(@PathVariable Long id) {
        Optional<Cargo> cargo = cargoService.findById(id);
        return cargo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
