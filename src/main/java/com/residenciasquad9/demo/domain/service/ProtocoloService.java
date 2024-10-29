package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProtocoloService {
    Protocolo save(ProtocoloDTO protocolo);
    Optional<Protocolo> findById(int id);
}

