package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.ClienteDTO;
import com.residenciasquad9.demo.domain.entites.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente save(ClienteDTO clienteDTO);

    Optional<Cliente> findById(Long id);

    Cliente update(Long id, ClienteDTO clienteDTO);

    boolean isAnonimo(Cliente cliente);

    List<Cliente> findAll();

    void deleteById(Long id);
}

