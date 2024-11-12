package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import com.residenciasquad9.demo.domain.repository.ProtocoloRepository;
import com.residenciasquad9.demo.domain.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProtocoloImplService implements ProtocoloService {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    // Abre um novo protocolo com TipoProtocolo
    @Override
    public Protocolo abrirProtocolo(ProtocoloDTO protocoloDTO) {
        protocoloDTO.setTipoProtocolo(TipoProtocolo.Solicitação);
        protocoloDTO.setStatus(Status.NOVO);
        protocoloDTO.setDataAbertura(new Date());
        protocoloDTO.setDataPrazo(calcularPrazo(protocoloDTO.getTipoProtocolo(), protocoloDTO.getDataAbertura()));
        return protocoloRepository.save(converterDtoParaEntidade(protocoloDTO));
    }

    // Consulta a data de abertura do protocolo
    @Override
    public Optional<Date> consultarDataProtocolo(String id) {
        return protocoloRepository.findById(id).map(Protocolo::getDataAbertura);
    }

    // Atualiza o tipo do protocolo e define o novo prazo
    @Override
    public Protocolo atualizarTipoProtocolo(String id, TipoProtocolo novoTipo) {
        Protocolo protocolo = protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));

        protocolo.setTipoProtocolo(novoTipo);
        protocolo.setDataPrazo(calcularPrazo(novoTipo, protocolo.getDataAbertura()));
        return protocoloRepository.save(protocolo);
    }

    // Atualiza o status do protocolo
    @Override
    public Protocolo atualizarStatusProtocolo(String id, Status novoStatus) {
        Protocolo protocolo = protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));

        protocolo.setStatus(novoStatus);
        return protocoloRepository.save(protocolo);
    }

    // Método auxiliar para calcular prazo com base no TipoProtocolo
    @Override
    public Date calcularPrazo(TipoProtocolo tipoProtocolo, Date dataAbertura) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataAbertura);

        switch (tipoProtocolo) {
            case Reclamação -> calendar.add(Calendar.DAY_OF_MONTH, 5);
            case Elogio -> calendar.add(Calendar.DAY_OF_MONTH, 10);
            case Informação -> calendar.add(Calendar.DAY_OF_MONTH, 7);
            case Solicitação -> calendar.add(Calendar.DAY_OF_MONTH, 7);
            case Consulta -> calendar.add(Calendar.DAY_OF_MONTH, 7);
            case Denuncia -> calendar.add(Calendar.DAY_OF_MONTH, 3);
            case Cancelamento -> calendar.add(Calendar.DAY_OF_MONTH, 2);
            default -> throw new IllegalArgumentException("Tipo de protocolo inválido");
        }

        return calendar.getTime();
    }

    // Salva o protocolo
    @Override
    public Protocolo save(ProtocoloDTO protocoloDTO) {
        return protocoloRepository.save(converterDtoParaEntidade(protocoloDTO));
    }

    // Consulta um protocolo pelo ID
    @Override
    public Optional<Protocolo> findById(String id) {
        return protocoloRepository.findById(id);
    }

    // Cria o status do protocolo
    @Override
    public Protocolo criarStatusProtocolo(String id, Status status) {
        Protocolo protocolo = protocoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));

        protocolo.setStatus(status);
        return protocoloRepository.save(protocolo);
    }

    // Converte ProtocoloDTO para Protocolo
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

    // Consulta o histórico do protocolo
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
}

