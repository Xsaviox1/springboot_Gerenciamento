package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.ClienteDTO;
import com.residenciasquad9.demo.domain.entites.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    // Salvar cliente
    Cliente save(ClienteDTO clienteDTO);

    // Buscar cliente por ID
    Optional<Cliente> findById(Long id);

    // Atualizar cliente
    Cliente update(Long id, ClienteDTO clienteDTO);

    // Verificar se o cliente é anônimo
    boolean isAnonimo(Cliente cliente);

    // Buscar todos os clientes
    List<Cliente> findAll();

    // Deletar cliente por ID
    void deleteById(Long id);
}

