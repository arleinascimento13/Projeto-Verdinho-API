package org.projetoverdinho.projetoverdinhoapi.repository;

import org.projetoverdinho.projetoverdinhoapi.entity.MultaAnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultaAnimalRepository extends JpaRepository<MultaAnimalModel, Long> {
    List<MultaAnimalModel> findByAnimalId(Long id);
}
