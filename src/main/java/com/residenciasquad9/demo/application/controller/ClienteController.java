package com.residenciasquad9.demo.application.controller;

import com.residenciasquad9.demo.application.serviceimpl.ClienteImplService;
import com.residenciasquad9.demo.domain.dto.ClienteDTO;
import com.residenciasquad9.demo.domain.entites.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteImplService clienteService;

    @Autowired
    public ClienteController(ClienteImplService clienteService) {
        this.clienteService = clienteService;
    }

    // Busca um Cliente pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
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
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody ClienteDTO clienteDTO) {
        try {
            Cliente updatedCliente = clienteService.update(id, clienteDTO);
            return ResponseEntity.ok(updatedCliente);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Exclui um Cliente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
        try {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
