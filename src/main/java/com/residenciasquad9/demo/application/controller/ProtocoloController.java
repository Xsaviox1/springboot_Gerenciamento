package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.ProtocoloDTO;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/protocolo")
public class ProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

    // Método para obter protocolo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Protocolo> getProtocoloById(@PathVariable String id) {
        Optional<Protocolo> protocolo = protocoloService.findById(id);
        return protocolo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para criar um novo protocolo
    @PostMapping
    public ResponseEntity<Protocolo> createProtocolo(@RequestBody ProtocoloDTO protocoloDTO) {
        // Define a data de abertura como a data atual
        Date dataAbertura = new Date();
        protocoloDTO.setDataAbertura(dataAbertura);

        // Define a data de prazo como 3 dias após a data de abertura
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataAbertura);
        calendar.add(Calendar.DAY_OF_MONTH, 3);  // Adiciona 3 dias
        Date dataPrazo = calendar.getTime();
        protocoloDTO.setDataPrazo(dataPrazo);

        // Cria o protocolo no banco de dados
        Protocolo protocolo = protocoloService.save(protocoloDTO);

        // Retorna o protocolo criado com status 200 OK
        return ResponseEntity.status(201).body(protocolo);
    }

    // Método para atualizar um protocolo existente
    @PutMapping("/{id}")
    public ResponseEntity<Protocolo> updateProtocolo(@PathVariable String id, @RequestBody ProtocoloDTO protocoloDTO) {
        Optional<Protocolo> protocoloExistente = protocoloService.findById(id);

        if (protocoloExistente.isPresent()) {
            Protocolo protocolo = protocoloExistente.get();

            // Não altera a data de abertura, mantém a existente
            protocolo.setNumeroProtocolo(protocoloDTO.getNumeroProtocolo());
            protocolo.setDescricao(protocoloDTO.getDescricao());
            protocolo.setTipoProtocolo(protocoloDTO.getTipoProtocolo());
            protocolo.setStatus(protocoloDTO.getStatus());

            // Se a data de prazo não foi informada, define como 3 dias após a data atual
            if (protocoloDTO.getDataPrazo() == null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_MONTH, 3);  // Adiciona 3 dias
                protocolo.setDataPrazo(calendar.getTime());
            } else {
                protocolo.setDataPrazo(protocoloDTO.getDataPrazo());
            }

            // Atualiza o protocolo no banco de dados
            Protocolo protocoloAtualizado = protocoloService.save(protocoloDTO);

            return ResponseEntity.ok(protocoloAtualizado); // Retorna o protocolo atualizado com status 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 caso o protocolo não exista
        }
    }
}


