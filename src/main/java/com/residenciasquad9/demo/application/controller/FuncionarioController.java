package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.domain.dto.FuncionarioDTO;
import com.residenciasquad9.demo.domain.entites.Funcionario;
import com.residenciasquad9.demo.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public Funcionario create(@RequestBody FuncionarioDTO funcionarioDTO) {
        return funcionarioService.save(funcionarioDTO);
    }

    @GetMapping("/{id}")
    public Funcionario findById(@PathVariable int id) {
        return funcionarioService.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
    }

    @GetMapping
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }

    @PutMapping("/{id}")
    public Funcionario update(@PathVariable int id, @RequestBody FuncionarioDTO funcionarioDTO) {
        return funcionarioService.update(id, funcionarioDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        funcionarioService.deleteById(id);
    }
}
