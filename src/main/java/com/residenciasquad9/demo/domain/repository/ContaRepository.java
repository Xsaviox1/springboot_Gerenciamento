package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
    boolean existsByCpf(String cpf);
    Optional<Conta> findByCpf(String cpf);
    Optional<Conta> findByAgenciaAndNumeroConta(String agencia, String numeroConta);
}
