package com.residenciasquad9.demo.application.serviceimpl;


import com.residenciasquad9.demo.domain.dto.ContaDTO;
import com.residenciasquad9.demo.domain.entites.Conta;
import com.residenciasquad9.demo.domain.repository.ContaRepository;
import com.residenciasquad9.demo.domain.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaImplService implements ContaService {

    @Autowired
    private ContaRepository contaRepository;
    @Override
    // convertendo ContaDTO para Conta e preenchendo os campos
    public Conta save(ContaDTO contaDTO) {
        Conta conta = new Conta();
        conta.setId(contaDTO.getId());
        conta.setCpf(contaDTO.getCpf());
        conta.setAgencia(contaDTO.getAgencia());
        conta.setNumeroConta(contaDTO.getNumeroConta());//Adicionar campos ao dto
        return contaRepository.save(conta);
    }

    @Override
    public Optional<Conta> findById(int id) {
        return contaRepository.findById(id);
    }
}