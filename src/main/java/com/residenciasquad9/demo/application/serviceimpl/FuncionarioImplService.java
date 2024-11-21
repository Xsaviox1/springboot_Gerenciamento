package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.FuncionarioDTO;
import com.residenciasquad9.demo.domain.entites.Funcionario;
import com.residenciasquad9.demo.domain.repository.FuncionarioRepository;
import com.residenciasquad9.demo.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioImplService implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioImplService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario save(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(
                funcionarioDTO.getNome(),
                funcionarioDTO.getEmail(),
                funcionarioDTO.getCargo(),
                funcionarioDTO.getDepartamento(),
                funcionarioDTO.isStatus()
        );
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> findById(int id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario update(int id, FuncionarioDTO funcionarioDTO) {
        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
        if (existingFuncionario.isPresent()) {
            Funcionario funcionario = existingFuncionario.get();
            funcionario.setNome(funcionarioDTO.getNome());
            funcionario.setEmail(funcionarioDTO.getEmail());
            funcionario.setCargo(funcionarioDTO.getCargo());
            funcionario.setDepartamento(funcionarioDTO.getDepartamento());
            funcionario.setStatus(funcionarioDTO.isStatus());
            return funcionarioRepository.save(funcionario);
        } else {
            throw new RuntimeException("Funcionário não encontrado com ID: " + id);
        }
    }

    @Override
    public void deleteById(int id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Funcionário não encontrado com ID: " + id);
        }
    }
}
