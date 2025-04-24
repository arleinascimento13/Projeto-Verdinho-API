package org.projetoverdinho.projetoverdinhoapi.repository;

import org.projetoverdinho.projetoverdinhoapi.entity.PessoaAnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaAnimalRepository extends JpaRepository<PessoaAnimalModel, Long> {
    List<PessoaAnimalModel> findByAnimalId(Long animalId);
}
