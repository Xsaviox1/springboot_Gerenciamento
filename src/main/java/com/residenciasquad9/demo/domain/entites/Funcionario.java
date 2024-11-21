package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.enums.TipoFuncionario;
import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String email;

    @Enumerated(EnumType.STRING)
    private TipoFuncionario cargo;

    private String departamento;

    private boolean status;

    // Construtores
    public Funcionario() {
    }

    public Funcionario(String nome, String email, TipoFuncionario cargo, String departamento, boolean status) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(TipoFuncionario cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
