package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.TipoDepartamento;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao", length = 1500, nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_departamento", nullable = false)
    private TipoDepartamento tipoDepartamento;

    // Relacionamento 1:N com Funcionario
    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;

    // Relacionamento 1:N com Cargo
    @OneToMany(mappedBy = "departamento")
    private List<Cargo> cargos;
}

