package org.projetoverdinho.projetoverdinhoapi.controller;

import jakarta.validation.Valid;
import org.projetoverdinho.projetoverdinhoapi.dto.AgenteDTO;
import org.projetoverdinho.projetoverdinhoapi.dto.authDTO.AuthRequest;
import org.projetoverdinho.projetoverdinhoapi.dto.authDTO.RegisterDTO;
import org.projetoverdinho.projetoverdinhoapi.entity.AgenteModel;
import org.projetoverdinho.projetoverdinhoapi.repository.AgenteRepository;
import org.projetoverdinho.projetoverdinhoapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private AgenteRepository repo;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthRequest authRequest) {
        try {
            AgenteModel user = service.login(authRequest.login(), authRequest.senha());

            AgenteDTO dto = new AgenteDTO(
                    user.getId(),
                    user.getNome(),
                    user.getCpf(),
                    user.getTelefone()
            );

            return ResponseEntity.ok(dto);

        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        try {
            AgenteModel newUser = service.register(registerDTO.nome(), registerDTO.cpf(), registerDTO.senha(), registerDTO.telefone());

            AgenteDTO dto = new AgenteDTO(
                    newUser.getId(),
                    newUser.getNome(),
                    newUser.getCpf(),
                    newUser.getTelefone()
            );

            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
