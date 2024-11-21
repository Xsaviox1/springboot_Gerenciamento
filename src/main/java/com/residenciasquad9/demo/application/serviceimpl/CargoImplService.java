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

    @Override
    public Cargo save(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        cargo.setTipoCargo(cargoDTO.getTipoCargo());
        return cargoRepository.save(cargo);
    }

    @Override
    public Optional<Cargo> findById(Long id) {  // Alterado para Long
        return cargoRepository.findById(id);
    }

    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    public Cargo update(Long id, CargoDTO cargoDTO) {  // Alterado para Long
        Optional<Cargo> existingCargo = cargoRepository.findById(id);
        if (existingCargo.isPresent()) {
            Cargo cargo = existingCargo.get();
            cargo.setTipoCargo(cargoDTO.getTipoCargo());
            return cargoRepository.save(cargo);
        } else {
            throw new RuntimeException("Cargo não encontrado com ID: " + id);
        }
    }

    public void deleteById(Long id) {  // Alterado para Long
        if (cargoRepository.existsById(id)) {
            cargoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cargo não encontrado com ID: " + id);
        }
    }
}
