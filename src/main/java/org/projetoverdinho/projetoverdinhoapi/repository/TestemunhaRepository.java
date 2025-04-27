package org.projetoverdinho.projetoverdinhoapi.repository;

import org.projetoverdinho.projetoverdinhoapi.entity.TestemunhaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestemunhaRepository extends JpaRepository<TestemunhaModel, Long> {
    Optional<TestemunhaModel> findByCpf(String cpf);
}
