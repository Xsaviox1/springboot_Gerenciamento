package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {  // Alterado para Long
}