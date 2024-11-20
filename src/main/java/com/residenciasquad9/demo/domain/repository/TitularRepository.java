package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Titular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitularRepository extends JpaRepository<Titular, Integer> {
    boolean existsByCpf(String cpf);
}