package com.residenciasquad9.demo.domain.repository;

import com.residenciasquad9.demo.domain.entites.Protocolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtocoloRepository extends JpaRepository<Protocolo, String> {
    boolean existsByNumeroProtocolo(Long numeroProtocolo);
}
