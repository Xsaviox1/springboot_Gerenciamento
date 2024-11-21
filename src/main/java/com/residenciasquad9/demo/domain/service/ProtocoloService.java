package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProtocoloService {

    Protocolo abrirProtocolo(ProtocoloDTO protocoloDTO);

    Optional<Date> consultarDataProtocolo(String id);

    Protocolo atualizarTipoProtocolo(String id, TipoProtocolo novoTipo);

    Protocolo atualizarStatusProtocolo(String id, Status novoStatus);

    List<String> consultarHistoricoProtocolo(String id);

    Protocolo save(ProtocoloDTO protocoloDTO);

    Optional<Protocolo> findById(String id);

    Protocolo criarStatusProtocolo(String id, Status status);

    Date calcularPrazo(TipoProtocolo tipoProtocolo, Date dataAbertura);
}

