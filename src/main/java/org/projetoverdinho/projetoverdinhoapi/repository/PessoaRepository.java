package org.projetoverdinho.projetoverdinhoapi.repository;

import org.projetoverdinho.projetoverdinhoapi.entity.AgenteModel;
import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<PessoaModel, Integer> {
    Optional<PessoaModel> findByCpf(String cpf);

    Optional<PessoaModel> findByNome(String nome);
}
