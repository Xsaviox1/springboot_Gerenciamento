package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "Protocolo")
public class Protocolo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_protocolo")
        private String idProtocolo;

        @Column(name = "numero_protocolo", nullable = false, unique = true)
        private Long numeroProtocolo;

        @Column(name = "data_abertura", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date dataAbertura;

        @Column(name = "data_prazo", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date dataPrazo;

        @Column(name = "descricao", length = 1500, nullable = false)
        private String descricao;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_protocolo", nullable = false)
        private TipoProtocolo tipoProtocolo;

        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false)
        private Status status;

        // Relacionamento com Cliente (Titular ou Anônimo)
        @ManyToOne
        @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente")
        private Cliente cliente;

    public void setPrazo(Date date) {
    }

    public Object getHistorico() {
        return null;
    }
    public void setFuncionario(Funcionario funcionario) {

    }
}




