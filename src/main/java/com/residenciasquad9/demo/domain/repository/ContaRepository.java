package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    boolean existsByNumeroConta(String numeroConta);
}
