
package com.example.telefoneapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public List<Telefone> listarTodos() {
        return telefoneService.listarTodos();
    }

    @GetMapping("/{id}")
    public Telefone buscarPorId(@PathVariable int id) {
        return telefoneService.buscarPorId(id);
    }

    @PostMapping
    public Telefone salvar(@RequestBody Telefone telefone) {
        return telefoneService.salvar(telefone);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        telefoneService.deletar(id);
    }
}
