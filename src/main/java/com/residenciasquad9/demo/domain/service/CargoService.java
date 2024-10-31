package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.entites.Cargo;
import com.residenciasquad9.demo.domain.dto.CargoDTO;

import java.util.Optional;

public interface CargoService {
    Cargo save(CargoDTO cargo);

    Optional<Cargo> findById(int id);
}
