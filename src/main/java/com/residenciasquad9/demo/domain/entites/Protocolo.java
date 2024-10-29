package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//trocar para o nome da tabela que vamos usar do BD
@Entity(name = "TB_USERS")
@Table(name = "TB_USERS")
public class Protocolo {
    // Atributos
    private int idProtocolo;
    private long numeroProtocolo;
    private Date dataAbertura;
    private Date dataPrazo;
    private String descricao;
    private TipoProtocolo tipoProtocolo;
    private Status status;
}

