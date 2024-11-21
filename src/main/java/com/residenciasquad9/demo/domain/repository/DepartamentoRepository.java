package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    boolean existsByNome(String nome);

    <T> ScopedValue<T> findByNome(String departamento);
}
