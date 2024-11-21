package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.entites.Titular;
import java.util.Optional;

public interface TitularService {

    Titular save(Titular titular);

    Optional<Titular> findByCpf(String cpf);

    Optional<Titular> findById(Long id);

    void deleteById(Long id);
}
