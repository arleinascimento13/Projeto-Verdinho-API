package org.projetoverdinho.projetoverdinhoapi.repository;

import org.projetoverdinho.projetoverdinhoapi.entity.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
}
