package org.projetoverdinho.projetoverdinhoapi.controller;

import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;
import org.projetoverdinho.projetoverdinhoapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController implements IController<PessoaModel> {

    @Autowired
    private PessoaService service;

    @Override
    @PostMapping
    public ResponseEntity<?> adiciona(@RequestBody PessoaModel i, @RequestParam("secret-key") String secretKey) {
        PessoaModel pessoaSalva = service.add(i);
        return ResponseEntity.ok(pessoaSalva);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id, @RequestParam("secret-key") String secretKey) {
        PessoaModel model = service.getById(id);
        return ResponseEntity.ok(model);
    }

    @Override
    @GetMapping
    public ResponseEntity<?> buscaTodos(@RequestParam("secret-key") String secretKey) {
        return ResponseEntity.ok(service.listAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deletePorId(@PathVariable Long id, @RequestParam("secret-key") String secretKey) {
        service.remove(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity editaPorId(@PathVariable Long id, @RequestBody Map<String, String> updates, @RequestParam("secret-key") String secretKey) {
        PessoaModel user = service.update(id, updates);
        return ResponseEntity.ok(user);
    }
}
