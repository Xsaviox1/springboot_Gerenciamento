package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.entites.Cliente;
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import com.residenciasquad9.demo.domain.repository.ProtocoloRepository;
import com.residenciasquad9.demo.domain.repository.ClienteRepository;
import com.residenciasquad9.demo.domain.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProtocoloImplService implements ProtocoloService {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Protocolo abrirProtocolo(ProtocoloDTO protocoloDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(protocoloDTO.getClienteIdCliente());

        if (!clienteOptional.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        Cliente cliente = clienteOptional.get();

        protocoloDTO.setTipoProtocolo(TipoProtocolo.SOLICITAÇÃO);
        protocoloDTO.setStatus(Status.NOVO);
        protocoloDTO.setDataAbertura(new Date());
        protocoloDTO.setDataPrazo(protocoloDTO.getTipoProtocolo().calcularPrazo(protocoloDTO.getDataAbertura()));

        Protocolo protocolo = converterDtoParaEntidade(protocoloDTO);
        protocolo.setCliente(cliente);

        return protocoloRepository.save(protocolo);
    }

    private Protocolo converterDtoParaEntidade(ProtocoloDTO dto) {
        Protocolo protocolo = new Protocolo();
        protocolo.setNumeroProtocolo(dto.getNumeroProtocolo());
        protocolo.setDataAbertura(dto.getDataAbertura());
        protocolo.setDataPrazo(dto.getDataPrazo());
        protocolo.setDescricao(dto.getDescricao());
        protocolo.setTipoProtocolo(dto.getTipoProtocolo());
        protocolo.setStatus(dto.getStatus());
        return protocolo;
    }

    @Override
    public List<String> consultarHistoricoProtocolo(String id) {
        Protocolo protocolo = protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));

        List<String> historico = new ArrayList<>();
        historico.add("Número do Protocolo: " + protocolo.getNumeroProtocolo());
        historico.add("Tipo do Protocolo: " + protocolo.getTipoProtocolo());
        historico.add("Status: " + protocolo.getStatus());
        historico.add("Data de Abertura: " + protocolo.getDataAbertura());

        return historico;
    }

    @Override
    public Date calcularPrazo(TipoProtocolo tipoProtocolo, Date dataAbertura) {
        return tipoProtocolo.calcularPrazo(dataAbertura);
    }

    @Override
    public Optional<Protocolo> findById(String id) {
        return protocoloRepository.findById(id);
    }

    @Override
    public Protocolo atualizarTipoProtocolo(String id, TipoProtocolo novoTipo) {
        Protocolo protocolo = protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));

        protocolo.setTipoProtocolo(novoTipo);
        return protocoloRepository.save(protocolo);
    }

    @Override
    public Protocolo atualizarStatusProtocolo(String id, Status novoStatus) {
        Protocolo protocolo = protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));

        protocolo.setStatus(novoStatus);
        return protocoloRepository.save(protocolo);
    }

    @Override
    public Protocolo save(ProtocoloDTO protocoloDTO) {
        Protocolo protocolo = converterDtoParaEntidade(protocoloDTO);
        return protocoloRepository.save(protocolo);
    }

    @Override
    public Protocolo criarStatusProtocolo(String id, Status status) {
        Protocolo protocolo = protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));
        protocolo.setStatus(status);
        return protocoloRepository.save(protocolo);
    }

    // Implementação do método que estava faltando: consultarDataProtocolo
    @Override
    public Optional<Date> consultarDataProtocolo(String id) {
        Protocolo protocolo = protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));

        // Retorna a data de abertura do protocolo
        return Optional.ofNullable(protocolo.getDataAbertura());
    }
}

