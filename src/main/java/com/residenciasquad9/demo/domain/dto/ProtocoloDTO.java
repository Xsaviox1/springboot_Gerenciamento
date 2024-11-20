package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import lombok.Data;

import java.util.Date;

@Data
public class ProtocoloDTO {

    private String idProtocolo;
    private Long numeroProtocolo;
    private Date dataAbertura;
    private Date dataPrazo;
    private String descricao;
    private TipoProtocolo tipoProtocolo;
    private Status status;
    private Long clienteIdCliente;
}