package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;

import java.util.Optional;

public interface ProtocoloService {
    Protocolo save(ProtocoloDTO protocolo);
    Optional<Protocolo> findById(String id);
}


