package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoProtocolo;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Protocolo") // Nome da tabela no BD
public class Protocolo {

        // Atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //Vai gerar o id automaticamente
        @Column(name = "id_protocolo")
        private Long idProtocolo;

        @Column(name = "numero_protocolo", nullable = false, unique = true)
        private Long NumeroProtocolo;

        @Column(name = "data_abertura", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date DataAbertura;

        @Column(name = "data_prazo", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date DataPrazo;

        @Column(name = "descricao", length = 1500, nullable = false)
        private String Descricao;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_protocolo", nullable = false)
        private TipoProtocolo TipoProtocolo;

        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false)
        private Status Status;
}

