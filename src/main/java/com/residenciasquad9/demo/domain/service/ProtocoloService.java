package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.entites.Funcionario; // Assumindo que Funcionario seja uma entidade relacionada
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;

import java.util.Date;
import java.util.Optional;

public interface ProtocoloService {

    // Abrir protocolo - considerando cliente anônimo ou titular e atribuindo um funcionário
    Protocolo abrirProtocolo(ProtocoloDTO protocoloDTO, Funcionario funcionario);

    // Consultar data de um protocolo específico
    Optional<Date> consultarDataProtocolo(String id);

    // Atualizar o tipo de protocolo
    Protocolo atualizarTipoProtocolo(String id, TipoProtocolo novoTipo);

    // Atualizar o status de um protocolo
    Protocolo atualizarStatusProtocolo(String id, Status novoStatus);

    // Consultar o histórico de um protocolo
    Object consultarHistoricoProtocolo(String id);

    // Salvar protocolo - pode ser um protocolo existente ou novo
    Protocolo save(ProtocoloDTO protocoloDTO);

    // Buscar protocolo por ID
    Optional<Protocolo> findById(String id);

    // Criar um status de protocolo (assumindo que esse método seja necessário para manipular status no futuro)
    Protocolo criarStatusProtocolo(String id, Status status);

    // Calcular o prazo com base no tipo de protocolo
    Date calcularPrazo(TipoProtocolo tipoProtocolo, Date dataAbertura);
}
