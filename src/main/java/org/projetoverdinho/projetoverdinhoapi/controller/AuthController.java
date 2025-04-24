package org.projetoverdinho.projetoverdinhoapi.controller;

import jakarta.validation.Valid;
import org.projetoverdinho.projetoverdinhoapi.dto.AgenteDTO;
import org.projetoverdinho.projetoverdinhoapi.dto.authDTO.RegisterDTO;
import org.projetoverdinho.projetoverdinhoapi.entity.AgenteModel;
import org.projetoverdinho.projetoverdinhoapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    @Autowired
    private AuthService service;

    @Value("${secret-key}")
    private String chaveSecreta;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam @Valid String login, @RequestParam @Valid String senha) {
        try {
            return ResponseEntity.ok(service.login(login, senha));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO) {
        try {
//            @RequestParam("secret-key") String secretKey,

//            if (!secretKey.equals(chaveSecreta)) {
//                throw new RuntimeException("Chave secreta inválida.");
//            }

            AgenteModel newUser = service.register(registerDTO);
            AgenteDTO dto = new AgenteDTO(newUser.getId(), newUser.getNome(), newUser.getCpf(), newUser.getTelefone());

//            return ResponseEntity.ok(new RespostaDTO<>(secretKey, dto));
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}

