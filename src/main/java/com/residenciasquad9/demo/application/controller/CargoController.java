package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.application.serviceimpl.CargoImplService;
import com.residenciasquad9.demo.domain.dto.CargoDTO;
import com.residenciasquad9.demo.domain.entites.Cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    private final CargoImplService cargoService;

    @Autowired
    public CargoController(CargoImplService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable Long id) {  // Alterado para Long
        Optional<Cargo> cargo = cargoService.findById(id);
        return cargo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargos() {
        return ResponseEntity.ok(cargoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Cargo> createCargo(@RequestBody CargoDTO cargoDTO) {
        Cargo cargo = cargoService.save(cargoDTO);
        return ResponseEntity.ok(cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable Long id, @RequestBody CargoDTO cargoDTO) {  // Alterado para Long
        try {
            Cargo updatedCargo = cargoService.update(id, cargoDTO);
            return ResponseEntity.ok(updatedCargo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Long id) {  // Alterado para Long
        try {
            cargoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

