package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.entites.Titular;
import java.util.Optional;

public interface TitularService {

    // Salvar titular
    Titular save(Titular titular);

    // Buscar titular por CPF
    Optional<Titular> findByCpf(String cpf);

    // Buscar titular por ID
    Optional<Titular> findById(Long id);

    // Deletar titular por ID
    void deleteById(Long id);
}
