
package com.example.telefoneapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public List<Telefone> listarTodos() {
        return telefoneRepository.findAll();
    }

    public Telefone salvar(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    public Telefone buscarPorId(int id) {
        return telefoneRepository.findById(id).orElse(null);
    }

    public void deletar(int id) {
        telefoneRepository.deleteById(id);
    }
}
