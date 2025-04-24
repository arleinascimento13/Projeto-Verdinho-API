package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.dto.AgenteDTO;
import org.projetoverdinho.projetoverdinhoapi.dto.authDTO.RegisterDTO;
import org.projetoverdinho.projetoverdinhoapi.entity.AgenteModel;
import org.projetoverdinho.projetoverdinhoapi.enumerator.Role;
import org.projetoverdinho.projetoverdinhoapi.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    private AgenteRepository repo;

//    @Value("${secret-key}")
//    private String chaveSecreta;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AgenteDTO login(String cpf, String senha) {
        AgenteModel user = repo.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o CPF: " + cpf));

        if (!passwordEncoder.matches(senha, user.getSenhaHash())) {
            throw new RuntimeException("Senha incorreta.");
        }

        AgenteDTO dto = new AgenteDTO(user.getId(), user.getNome(), user.getCpf(), user.getTelefone());

        return dto;
    }

    public AgenteModel register(RegisterDTO registerDTO) {
        if (repo.findByCpf(registerDTO.cpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado.");
        }

        AgenteModel newUser = new AgenteModel();
        newUser.setNome(registerDTO.nome());
        newUser.setCpf(registerDTO.cpf());
        newUser.setTelefone(registerDTO.telefone());
        newUser.setRole(registerDTO.role());

        String senhaHash = passwordEncoder.encode(registerDTO.senha());
        newUser.setSenhaHash(senhaHash);

        return repo.save(newUser);
    }
}