package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CargoRepository extends JpaRepository <Cargo, Integer>{
}
