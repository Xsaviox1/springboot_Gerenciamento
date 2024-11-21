package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.entites.Cargo;
import com.residenciasquad9.demo.domain.dto.CargoDTO;

import java.util.Optional;

public interface CargoService {

    // Método para salvar um cargo
    Cargo save(CargoDTO cargo);

    // Método para buscar um cargo por id
    Optional<Cargo> findById(Long id);  // O ID do cargo é Long, como esperado
}
