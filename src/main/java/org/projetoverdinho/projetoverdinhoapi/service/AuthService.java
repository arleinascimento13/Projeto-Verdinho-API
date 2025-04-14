package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.entity.AgenteModel;
import org.projetoverdinho.projetoverdinhoapi.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AgenteRepository repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AgenteModel login(String cpf, String senha) {
        AgenteModel user = repo.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o CPF: " + cpf));

        if (!passwordEncoder.matches(senha, user.getSenhaHash())) {
            throw new RuntimeException("Senha incorreta.");
        }

        return user;
    }

    public AgenteModel register(String nome, String cpf, String senha, String telefone) {
        if (repo.findByCpf(cpf).isPresent()) { throw new RuntimeException("CPF já cadastrado."); }

        AgenteModel newUser = new AgenteModel();
        newUser.setNome(nome);
        newUser.setCpf(cpf);
        newUser.setTelefone(telefone);

        String senhaHash = passwordEncoder.encode(senha);
        newUser.setSenhaHash(senhaHash);

        return repo.save(newUser);
    }
}

//    public AgenteModel add(AgenteModel agenteModel) {
//        return repo.save(agenteModel);
//    }
//
//    public AgenteModel remove(String id) {
//        AgenteModel model = getById(id);
//        repo.delete(model);
//        return model;
//    }
//
//    public AgenteModel update(String id, Object param, Object newValue) {
//        AgenteModel model = getById(id);
//
//        Map<String, Consumer<AgenteModel>> fieldUpdater = Map.of(
//                "passwordHash", m -> m.setSenhaHash((String) newValue),
//                "telefone", m -> m.setTelefone((String) newValue),
//                "cpf", m -> m.setCpf((String) newValue),
//                "nome", m -> m.setNome((String) newValue)
//        );
//
//        Consumer<AgenteModel> updater = fieldUpdater.get(param);
//        if (updater != null) {
//            updater.accept(model);
//        } else {
//            throw new IllegalArgumentException("Parâmetro inválido para atualização: " + param);
//        }
//
//        return repo.save(model);
//    }
//
//    public List<AgenteModel> listAll() {
//        return repo.findAll();
//    }
//
//    public AgenteModel getById(String id) {
//        Optional<AgenteModel> result = repo.findById(id);
//        return result.orElseThrow(() -> new RuntimeException("Agente não encontrado com id: " + id));
//    }

