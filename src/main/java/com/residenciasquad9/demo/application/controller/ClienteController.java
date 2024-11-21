package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.application.serviceimpl.ClienteImplService;
import com.residenciasquad9.demo.domain.dto.ClienteDTO;
import com.residenciasquad9.demo.domain.entites.Cliente;
import com.residenciasquad9.demo.domain.entites.Titular;
import com.residenciasquad9.demo.domain.service.TitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteImplService clienteService;
    private final TitularService titularService;

    @Autowired
    public ClienteController(ClienteImplService clienteService, TitularService titularService) {
        this.clienteService = clienteService;
        this.titularService = titularService;
    }

    // Busca um Cliente pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retorna todos os Clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    // Cria um novo Cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.save(clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    // Atualiza um Cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.update(id, clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    // Exibe informações do Titular do Cliente
    @GetMapping("/{id}/titular")
    public ResponseEntity<Titular> getTitularByClienteId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isPresent() && !clienteService.isAnonimo(cliente.get())) {
            Optional<Titular> titular = titularService.findByCpf(cliente.get().getCpf());
            return titular.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Exclui um Cliente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        try {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


