package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.DepartamentoDTO;
import com.residenciasquad9.demo.domain.entities.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoService {

    Departamento save(DepartamentoDTO departamentoDTO);

    Optional<Departamento> findById(Long id);

    List<Departamento> findAll();

    Departamento update(Long id, DepartamentoDTO departamentoDTO);

    void deleteById(Long id);
}

