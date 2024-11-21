package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.CargoDTO;
import com.residenciasquad9.demo.domain.entites.Cargo;
import com.residenciasquad9.demo.domain.repository.CargoRepository;
import com.residenciasquad9.demo.domain.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoImplService implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Cargo save(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        cargo.setTipoCargo(cargoDTO.getTipoCargo());
        return cargoRepository.save(cargo);
    }

    @Override
    public Optional<Cargo> findById(Long id) {
        return cargoRepository.findById(id);
    }
}

