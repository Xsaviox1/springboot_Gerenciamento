package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    boolean existsById(Long id);
}
