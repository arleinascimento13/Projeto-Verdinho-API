package org.projetoverdinho.projetoverdinhoapi.controller;

import jakarta.validation.Valid;
import org.projetoverdinho.projetoverdinhoapi.entity.TestemunhaModel;
import org.projetoverdinho.projetoverdinhoapi.service.TestemunhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/testemunha")
public class TestemunhaController {
    @Autowired
    TestemunhaService service;

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody @Valid TestemunhaModel t) {
        if (t == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A testemunha não pode ser nula.");
        }
        var pessoaSalva = service.add(t);
        return ResponseEntity.ok(pessoaSalva);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaPorId(@PathVariable Long id, @RequestParam("secret-key") String secretKey) {
        return ResponseEntity.ok(service.remove(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editaPorid(@PathVariable Long id, @RequestBody Map<String, String> updates, @RequestParam("secret-key") String secretKey) {
        return ResponseEntity.ok(service.update(id, updates));
    }


}