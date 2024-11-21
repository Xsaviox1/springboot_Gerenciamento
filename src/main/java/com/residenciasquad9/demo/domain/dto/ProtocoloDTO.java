package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.entites.Cliente;
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProtocoloDTO {

    private String idProtocolo;            // ID do protocolo
    private Long numeroProtocolo;          // Número único do protocolo
    private Date dataAbertura;             // Data de abertura do protocolo
    private Date dataPrazo;                // Data do prazo do protocolo
    private String descricao;              // Descrição do protocolo
    private TipoProtocolo tipoProtocolo;   // Tipo do protocolo (Enum)
    private Status status;                 // Status do protocolo (Enum)
    private Cliente cliente;               // Objeto Cliente ao invés do ID

}

