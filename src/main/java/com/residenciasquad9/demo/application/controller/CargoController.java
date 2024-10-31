// CargoController.java
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
    public ResponseEntity<Cargo> getCargoById(@PathVariable int id) {
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
    public ResponseEntity<Cargo> updateCargo(@PathVariable int id, @RequestBody CargoDTO cargoDTO) {
        try {
            Cargo updatedCargo = cargoService.update(id, cargoDTO);
            return ResponseEntity.ok(updatedCargo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable int id) {
        try {
            cargoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
