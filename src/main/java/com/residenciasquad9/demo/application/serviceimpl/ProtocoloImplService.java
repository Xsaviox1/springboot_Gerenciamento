package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.entites.Funcionario;
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import com.residenciasquad9.demo.domain.repository.ProtocoloRepository;
import com.residenciasquad9.demo.domain.service.ProtocoloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProtocoloImplService implements ProtocoloService {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    @Override
    public Protocolo abrirProtocolo(ProtocoloDTO protocoloDTO, Funcionario funcionario) {
        Protocolo protocolo = new Protocolo();
        protocolo.setTipoProtocolo(protocoloDTO.getTipoProtocolo());
        protocolo.setStatus(Status.NOVO);
        protocolo.setCliente(protocoloDTO.getCliente());
        protocolo.setFuncionario(funcionario);  // Atribuindo o protocolo a um funcionário
        protocolo.setDataAbertura(new Date());

        // Calculando o prazo com base no tipo de protocolo
        Date prazo = TipoProtocolo.valueOf(protocoloDTO.getTipoProtocolo().name()).calcularPrazo(protocolo.getDataAbertura());
        protocolo.setPrazo(prazo);

        return protocoloRepository.save(protocolo);
    }

    @Override
    public Optional<Date> consultarDataProtocolo(String id) {
        Optional<Protocolo> protocolo = protocoloRepository.findById(id);
        return protocolo.map(Protocolo::getDataAbertura);
    }

    @Override
    public Protocolo atualizarTipoProtocolo(String id, TipoProtocolo novoTipo) {
        Optional<Protocolo> protocoloOpt = protocoloRepository.findById(id);
        if (protocoloOpt.isPresent()) {
            Protocolo protocolo = protocoloOpt.get();
            protocolo.setTipoProtocolo(novoTipo);
            protocolo.setPrazo(TipoProtocolo.valueOf(novoTipo.name()).calcularPrazo(protocolo.getDataAbertura()));
            return protocoloRepository.save(protocolo);
        }
        return null;
    }

    @Override
    public Protocolo atualizarStatusProtocolo(String id, Status novoStatus) {
        Optional<Protocolo> protocoloOpt = protocoloRepository.findById(id);
        if (protocoloOpt.isPresent()) {
            Protocolo protocolo = protocoloOpt.get();
            protocolo.setStatus(novoStatus);
            return protocoloRepository.save(protocolo);
        }
        return null;
    }

    @Override
    public Object consultarHistoricoProtocolo(String id) {
        // O histórico pode ser armazenado como uma lista no próprio Protocolo ou em outra tabela (dependendo da modelagem)
        Optional<Protocolo> protocolo = protocoloRepository.findById(id);
        return protocolo.map(Protocolo::getHistorico).orElse(null);
    }

    @Override
    public Protocolo save(ProtocoloDTO protocoloDTO) {
        Protocolo protocolo = new Protocolo();
        protocolo.setTipoProtocolo(protocoloDTO.getTipoProtocolo());
        protocolo.setStatus(Status.NOVO);
        protocolo.setCliente(protocoloDTO.getCliente());
        protocolo.setDataAbertura(new Date());
        return protocoloRepository.save(protocolo);
    }

    @Override
    public Optional<Protocolo> findById(String id) {
        return protocoloRepository.findById(id);
    }

    @Override
    public Protocolo criarStatusProtocolo(String id, Status status) {
        Optional<Protocolo> protocoloOpt = protocoloRepository.findById(id);
        if (protocoloOpt.isPresent()) {
            Protocolo protocolo = protocoloOpt.get();
            protocolo.setStatus(status);
            return protocoloRepository.save(protocolo);
        }
        return null;
    }

    @Override
    public Date calcularPrazo(TipoProtocolo tipoProtocolo, Date dataAbertura) {
        return tipoProtocolo.calcularPrazo(dataAbertura);
    }
}
