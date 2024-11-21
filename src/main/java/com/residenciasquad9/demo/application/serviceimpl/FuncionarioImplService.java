package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.FuncionarioDTO;
import com.residenciasquad9.demo.domain.entites.Funcionario;
import com.residenciasquad9.demo.domain.entites.Cargo;
import com.residenciasquad9.demo.domain.entites.Departamento;
import com.residenciasquad9.demo.domain.repository.FuncionarioRepository;
import com.residenciasquad9.demo.domain.repository.CargoRepository;
import com.residenciasquad9.demo.domain.repository.DepartamentoRepository;
import com.residenciasquad9.demo.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioImplService implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Funcionario criarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setStatusFunc(funcionarioDTO.getStatusFunc());

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario atribuirProtocoloAoFuncionario(String cpf, String protocoloId) {
        // Aqui você deve implementar o repositório para o Protocolo, se necessário.
        Funcionario funcionario = funcionarioRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        // Protocolo protocolo = protocoloRepository.findById(protocoloId).orElseThrow(() -> new RuntimeException("Protocolo não encontrado"));
        // funcionario.setProtocolo(protocolo);
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario atribuirCargoAoFuncionario(String cpf, Long cargoId) {
        Funcionario funcionario = funcionarioRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        Cargo cargo = cargoRepository.findById(cargoId).orElseThrow(() -> new RuntimeException("Cargo não encontrado"));
        funcionario.setCargo(cargo);
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario atribuirDepartamentoAoFuncionario(String cpf, String departamento) {
        Funcionario funcionario = funcionarioRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        Departamento departamentoEntity = departamentoRepository.findByNome(departamento).orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
        funcionario.setDepartamento(String.valueOf(departamentoEntity));  // Agora estamos setando o objeto completo
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario findById(String cpf) {
        return null;
    }
}
