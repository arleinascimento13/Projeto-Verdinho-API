package org.projetoverdinho.projetoverdinhoapi.controller;

import org.projetoverdinho.projetoverdinhoapi.dto.AnimalDTO;
import org.projetoverdinho.projetoverdinhoapi.entity.AnimalModel;
import org.projetoverdinho.projetoverdinhoapi.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/animais")
public class AnimalController {

    @Autowired
    private AnimalService service;

    //@RequestParam("secret-key") String secretKey
    // , @RequestParam("secret-key") String secretKey

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {
        AnimalModel model = service.getById(id);

        return ResponseEntity.ok(model);
    }

    @GetMapping
    public ResponseEntity<?> buscaTodos() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping("/registrar/{pessoaId}")
    public ResponseEntity<?> AdicionaAnimalPorCPFDono(@PathVariable String pessoaCPF, @RequestBody AnimalModel animal) {
        try {
            AnimalModel novoAnimal = service.adicionarAnimalComDono(pessoaCPF, animal);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAnimal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao adicionar animal com dono.");
        }
    }

    @GetMapping("/{id}/completo")
    public ResponseEntity<AnimalDTO> getAnimalCompleto(@PathVariable Long id) {
        AnimalDTO dto = service.listarAnimalCompleto(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
}
