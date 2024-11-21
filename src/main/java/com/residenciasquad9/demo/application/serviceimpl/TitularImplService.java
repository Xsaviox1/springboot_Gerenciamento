package com.residenciasquad9.demo.application.serviceimpl;
import com.residenciasquad9.demo.domain.entites.Titular;
import com.residenciasquad9.demo.domain.repository.TitularRepository;
import com.residenciasquad9.demo.domain.service.TitularService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TitularImplService implements TitularService {

    @Autowired
    private TitularRepository titularRepository;

    @Override
    public Titular save(Titular titular) {
        return titularRepository.save(titular);
    }

    @Override
    public Optional<Titular> findByCpf(String cpf) {
        return titularRepository.findByCpf(cpf);
    }

    @Override
    public Optional<Titular> findById(Long id) {
        return titularRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        titularRepository.deleteById(id);
    }
}

