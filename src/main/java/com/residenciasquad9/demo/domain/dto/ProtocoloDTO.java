package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProtocoloDTO {

    private Long numeroProtocolo;
    private Date dataAbertura;
    private Date dataPrazo;
    private String descricao;
    private TipoProtocolo tipoProtocolo;
    private Status status;
}
