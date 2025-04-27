package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.entity.TestemunhaModel;
import org.projetoverdinho.projetoverdinhoapi.repository.TestemunhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return null;
    }

    @Override
    public TestemunhaModel update(Long id, Map<String, String> updates) {
        return null;
    }

    @Override
    public List<TestemunhaModel> listAll() {
        return List.of();
    }

    @Override
    public TestemunhaModel getById(Long id) {
        return null;
    }
}
