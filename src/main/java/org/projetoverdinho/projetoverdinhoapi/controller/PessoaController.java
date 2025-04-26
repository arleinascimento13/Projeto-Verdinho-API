package org.projetoverdinho.projetoverdinhoapi.controller;

import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;
import org.projetoverdinho.projetoverdinhoapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<?> adiciona(@RequestBody PessoaModel i, @RequestParam("secret-key") String secretKey) {
        PessoaModel pessoaSalva = service.add(i);
        return ResponseEntity.ok(pessoaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id, @RequestParam("secret-key") String secretKey) {
        PessoaModel model = service.getById(id);
        return ResponseEntity.ok(model);
    }

    @GetMapping
    public ResponseEntity<?> buscaTodos(@RequestParam("secret-key") String secretKey) {
        return ResponseEntity.ok(service.listAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaPorId(@PathVariable Long id, @RequestParam("secret-key") String secretKey) {
        return ResponseEntity.ok(service.remove(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity editaPorId(@PathVariable Long id, @RequestBody Map<String, String> updates, @RequestParam("secret-key") String secretKey) {
        return ResponseEntity.ok(service.update(id, updates));
    }

    @GetMapping("/nome")
    public ResponseEntity<?> buscarPorNome(@RequestParam("nome") String nome, @RequestParam("secret-key") String secretKey) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/cpf")
    public ResponseEntity<?> buscarPorCpf(@RequestParam("cpf") String cpf, @RequestParam("secret-key") String secretKey) {
        return ResponseEntity.ok(service.buscarPorCpf(cpf));
    }
}
