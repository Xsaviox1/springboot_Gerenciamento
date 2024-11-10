package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.ClienteDTO;
import com.residenciasquad9.demo.domain.entites.Cliente;
import com.residenciasquad9.demo.domain.repository.ClienteRepository;
import com.residenciasquad9.demo.domain.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ClienteImplService implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteImplService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Cria ou salva um novo Cliente
    @Override
    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTipoCliente(clienteDTO.getTipoCliente());
        cliente.setCnpj(clienteDTO.getCnpj());
        cliente.setTelefoneIdTelefone(clienteDTO.getTelefoneIdTelefone());
        return clienteRepository.save(cliente);
    }

    // Busca um Cliente pelo ID
    @Override
    public Optional<Cliente> findById(int id) {
        return clienteRepository.findById(id);
    }

    // Retorna todos os Clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Atualiza um Cliente existente
    public Cliente update(int id, ClienteDTO clienteDTO) {
        Optional<Cliente> existingCliente = clienteRepository.findById(id);
        if (existingCliente.isPresent()) {
            Cliente cliente = existingCliente.get();
            cliente.setNome(clienteDTO.getNome());
            cliente.setCpf(clienteDTO.getCpf());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setTipoCliente(clienteDTO.getTipoCliente());
            cliente.setCnpj(clienteDTO.getCnpj());
            cliente.setTelefoneIdTelefone(clienteDTO.getTelefoneIdTelefone());
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado com ID: " + id);
        }
    }

    // Exclui um Cliente pelo ID
    public void deleteById(int id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado com ID: " + id);
        }
    }
}
