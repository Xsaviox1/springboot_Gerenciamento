package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.ContaDTO;
import com.residenciasquad9.demo.domain.entites.Conta;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ContaService {
    Conta save(ContaDTO conta);
    Optional<Conta> findById(int id);
}

