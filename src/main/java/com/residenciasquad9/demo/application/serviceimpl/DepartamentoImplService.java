package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.DepartamentoDTO;
import com.residenciasquad9.demo.domain.entites.Departamento;
import com.residenciasquad9.demo.domain.repository.DepartamentoRepository;
import com.residenciasquad9.demo.domain.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoImplService implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Departamento save(DepartamentoDTO departamentoDTO) {
        Departamento departamento = new Departamento();
        departamento.setNome(departamentoDTO.getNome());
        departamento.setDescricao(departamentoDTO.getDescricao());
        departamento.setTipoDepartamento(departamentoDTO.getTipoDepartamento());
        return departamentoRepository.save(departamento);
    }

    @Override
    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento update(Long id, DepartamentoDTO departamentoDTO) {
        Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
        if (departamentoOptional.isPresent()) {
            Departamento departamento = departamentoOptional.get();
            departamento.setNome(departamentoDTO.getNome());
            departamento.setDescricao(departamentoDTO.getDescricao());
            departamento.setTipoDepartamento(departamentoDTO.getTipoDepartamento());
            return departamentoRepository.save(departamento);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }
}
