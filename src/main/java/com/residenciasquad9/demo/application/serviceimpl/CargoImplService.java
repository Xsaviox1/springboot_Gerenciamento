// CargoImplService.java
package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.CargoDTO;
import com.residenciasquad9.demo.domain.entites.Cargo;
import com.residenciasquad9.demo.domain.repository.CargoRepository;
import com.residenciasquad9.demo.domain.service.CargoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CargoImplService implements CargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoImplService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    // Cria ou salva um novo Cargo
    @Override
    public Cargo save(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        cargo.setTipoCargo(cargoDTO.getTipoCargo());
        return cargoRepository.save(cargo);
    }

    // Busca um Cargo pelo ID
    @Override
    public Optional<Cargo> findById(int id) {
        return cargoRepository.findById(id);
    }

    // Retorna todos os Cargos
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    // Atualiza um Cargo existente
    public Cargo update(int id, CargoDTO cargoDTO) {
        Optional<Cargo> existingCargo = cargoRepository.findById(id);
        if (existingCargo.isPresent()) {
            Cargo cargo = existingCargo.get();
            cargo.setTipoCargo(cargoDTO.getTipoCargo());
            return cargoRepository.save(cargo);
        } else {
            throw new RuntimeException("Cargo não encontrado com ID: " + id);
        }
    }

    // Exclui um Cargo pelo ID
    public void deleteById(int id) {
        if (cargoRepository.existsById(id)) {
            cargoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cargo não encontrado com ID: " + id);
        }
    }
}
