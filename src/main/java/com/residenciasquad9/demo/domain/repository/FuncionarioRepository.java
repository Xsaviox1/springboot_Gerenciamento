package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
}
