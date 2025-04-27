package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.entity.TestemunhaModel;
import org.projetoverdinho.projetoverdinhoapi.enumerator.StatusAtivo;
import org.projetoverdinho.projetoverdinhoapi.repository.TestemunhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class TestemunhaService implements IService<TestemunhaModel> {
    @Autowired
    TestemunhaRepository repository;

    @Override
    public TestemunhaModel add(TestemunhaModel testemunhaModel) {
        return repository.save(testemunhaModel);
    }

    @Override
    public TestemunhaModel remove(Long id) {
        TestemunhaModel model = getById(id);
        model.setStatus(StatusAtivo.DESATIVADO);
        repository.save(model);
        return model;
    }

    @Override
    public TestemunhaModel update(Long id, Map<String, String> updates) {
        TestemunhaModel model = getById(id);

        Map<String, Consumer<String>> fieldUpdater = Map.of(
                "nome", value -> model.setNome(value),
                "cpf", value -> model.setCpf(value),
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

        return repository.save(model);
    }

    @Override
    public List<TestemunhaModel> listAll() {
        return repository.findAll();
    }

    @Override
    public TestemunhaModel getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Testemunha não encontrado com id: " + id));
    }

    public TestemunhaModel buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Testemunha não encontrado com cpf: " + cpf));
    }
}
