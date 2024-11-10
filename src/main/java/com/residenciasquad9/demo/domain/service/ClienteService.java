package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.entites.Cliente;
import com.residenciasquad9.demo.domain.dto.ClienteDTO;

import java.util.Optional;

public interface ClienteService {
    Cliente save(ClienteDTO cliente);

    Optional<Cliente> findById(int id);
}
