package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.repository.ProtocoloRepository;
import com.residenciasquad9.demo.domain.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProtocoloImplService implements ProtocoloService {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    @Override
    public Protocolo save(ProtocoloDTO protocoloDTO) {
        // Convertendo ProtocoloDTO para Protocolo
        Protocolo protocolo = new Protocolo();
        protocolo.setNumeroProtocolo(protocoloDTO.getNumeroProtocolo());
        protocolo.setDataAbertura(protocoloDTO.getDataAbertura());
        protocolo.setDataPrazo(protocoloDTO.getDataPrazo());
        protocolo.setDescricao(protocoloDTO.getDescricao());
        protocolo.setTipoProtocolo(protocoloDTO.getTipoProtocolo());
        protocolo.setStatus(protocoloDTO.getStatus());

        return protocoloRepository.save(protocolo);
    }

    @Override
    public Optional<Protocolo> findById(String id) {
        return protocoloRepository.findById(id);
    }
}
