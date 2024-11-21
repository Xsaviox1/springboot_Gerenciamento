package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.ContaDTO;
import com.residenciasquad9.demo.domain.entites.Conta;
import com.residenciasquad9.demo.domain.repository.ContaRepository;
import com.residenciasquad9.demo.domain.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação do serviço para gerenciamento de contas.
 */
@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;

    @Autowired
    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Conta save(ContaDTO contaDTO) {
        // Verifica se já existe uma conta associada ao CPF
        if (contaRepository.existsByCpf(contaDTO.getCpf())) {
            throw new IllegalArgumentException("Já existe uma conta associada ao CPF: " + contaDTO.getCpf());
        }

        // Converte ContaDTO para Conta
        Conta conta = new Conta();
        conta.setCpf(contaDTO.getCpf());
        conta.setAgencia(contaDTO.getAgencia());
        conta.setNumeroConta(contaDTO.getNumeroConta());
        return contaRepository.save(conta);
    }

    @Override
    public Optional<Conta> findById(int id) {
        return contaRepository.findById(id);
    }

    @Override
    public Conta buscarContaPorCPF(String cpf) {
        // Busca a conta pelo CPF
        return contaRepository.findByTitularCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada para o CPF: " + cpf));
    }

    @Override
    public Conta buscarContaPorAgenciaENumero(String agencia, String numeroConta) {
        // Busca a conta pela agência e número
        return contaRepository.findByAgenciaAndNumeroConta(agencia, numeroConta)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada para a agência: "
                        + agencia + " e número da conta: " + numeroConta));
    }
}
