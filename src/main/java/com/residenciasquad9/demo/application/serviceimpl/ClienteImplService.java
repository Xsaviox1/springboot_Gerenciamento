package com.residenciasquad9.demo.application.serviceimpl;

import com.residenciasquad9.demo.domain.dto.ClienteDTO;
import com.residenciasquad9.demo.domain.entites.Cliente;
import com.residenciasquad9.demo.domain.entites.Titular;
import com.residenciasquad9.demo.domain.repository.ClienteRepository;
import com.residenciasquad9.demo.domain.service.ClienteService;
import com.residenciasquad9.demo.domain.service.TitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteImplService implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final TitularService titularService;

    @Autowired
    public ClienteImplService(ClienteRepository clienteRepository, TitularService titularService) {
        this.clienteRepository = clienteRepository;
        this.titularService = titularService;
    }

    @Override
    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTipoCliente(clienteDTO.getTipoCliente());
        cliente.setCnpj(clienteDTO.getCnpj());
        cliente.setTelefoneIdTelefone(clienteDTO.getTelefoneIdTelefone());

        // Se o cliente não for anônimo, associamos ao Titular
        if (!isAnonimo(cliente)) {
            Titular titular = new Titular();
            titular.setCpf(cliente.getCpf());
            titular.setNome(cliente.getNome());
            titular.setEmail(cliente.getEmail());
            titularService.save(titular); // Salva o titular
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente update(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> existingClienteOpt = clienteRepository.findById(id);

        if (existingClienteOpt.isPresent()) {
            Cliente cliente = existingClienteOpt.get();
            cliente.setNome(clienteDTO.getNome());
            cliente.setCpf(clienteDTO.getCpf());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setTipoCliente(clienteDTO.getTipoCliente());
            cliente.setCnpj(clienteDTO.getCnpj());
            cliente.setTelefoneIdTelefone(clienteDTO.getTelefoneIdTelefone());

            // Atualizando Titular se necessário
            if (!isAnonimo(cliente)) {
                Titular titular = new Titular();
                titular.setCpf(cliente.getCpf());
                titular.setNome(cliente.getNome());
                titular.setEmail(cliente.getEmail());
                titularService.save(titular); // Atualiza ou cria o titular
            }

            return clienteRepository.save(cliente);
        }

        // Se o cliente não for encontrado, retorna nulo ou lance uma exceção
        return null;
    }

    @Override
    public boolean isAnonimo(Cliente cliente) {
        return (cliente.getCpf() == null || cliente.getCpf().isEmpty()) &&
                (cliente.getCnpj() == null || cliente.getCnpj().isEmpty());
    }

    @Override
    public List<Cliente> findAll() {
        // Retorna todos os clientes do banco de dados
        return clienteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        // Exclui o cliente pelo id
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();

            // Se o cliente não for anônimo, podemos excluir o Titular relacionado
            if (!isAnonimo(cliente)) {
                Titular titular = titularService.findByCpf(cliente.getCpf()).orElse(null);
                if (titular != null) {
                    titularService.deleteById(titular.getIdTitular()); // Exclui o titular
                }
            }

            clienteRepository.delete(cliente); // Exclui o cliente
        }
    }
}
