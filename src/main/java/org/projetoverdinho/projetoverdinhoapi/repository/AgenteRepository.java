package org.projetoverdinho.projetoverdinhoapi.repository;

import org.projetoverdinho.projetoverdinhoapi.entity.AgenteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenteRepository extends JpaRepository<AgenteModel, String> {
    Optional<AgenteModel> findByCpf(String cpf);
}
