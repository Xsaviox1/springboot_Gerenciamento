package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}