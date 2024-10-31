package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.entites.Protocolo;
import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProtocoloDTO {

    private Long NumeroProtocolo;
    private Date DataAbertura;
    private Date DataPrazo;
    private String Descricao;
    private TipoProtocolo TipoProtocolo;
    private Status Status;
}

