package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.TipoCargo;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private Long idCargo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cargo", nullable = false)
    private TipoCargo tipoCargo;
}
