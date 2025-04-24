package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;
import org.projetoverdinho.projetoverdinhoapi.enumerator.StatusAtivo;
import org.projetoverdinho.projetoverdinhoapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class PessoaService implements IService<PessoaModel> {
    @Autowired
    private PessoaRepository repo;

    @Override
    public PessoaModel add(PessoaModel pessoaModel) {
        return repo.save(pessoaModel);
    }

    @Override
    public PessoaModel remove(Long id) {
        PessoaModel model = getById(id);
        repo.delete(model);
        return model;
    }

    public PessoaModel update(Long id, Map<String, String> updates) {
        PessoaModel model = getById(id);

        Map<String, Consumer<String>> fieldUpdater = Map.of(
                "nome", value -> model.setNome(value),
                "rg", value -> model.setRg(value),
                "cpf", value -> model.setCpf(value),
                "imgurl", value -> model.setImgUrl(value),
                "telefone", value -> model.setTelefone(value),
                "status", value -> model.setStatus(StatusAtivo.valueOf(value))
        );

        updates.forEach((field, value) -> {
            Consumer<String> updater = fieldUpdater.get(field.toLowerCase());
            if (updater != null) {
                updater.accept(value);
            } else {
                throw new IllegalArgumentException("Campo inválido para atualização: " + field);
            }
        });

        return repo.save(model);
    }

    @Override
    public List<PessoaModel> listAll() {
        return repo.findAll();
    }

    @Override
    public PessoaModel getById(Long id) {
        Optional<PessoaModel> result = repo.findById(Math.toIntExact(id));
        return result.orElseThrow(() -> new RuntimeException("Agente não encontrado com id: " + id));
    }
}
