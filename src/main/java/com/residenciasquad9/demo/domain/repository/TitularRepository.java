package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Titular;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TitularRepository extends JpaRepository<Titular, Long> {

    Optional<Titular> findByCpf(String cpf);
}
