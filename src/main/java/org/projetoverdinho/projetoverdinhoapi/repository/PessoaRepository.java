package org.projetoverdinho.projetoverdinhoapi.repository;

import org.projetoverdinho.projetoverdinhoapi.entity.AgenteModel;
import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<PessoaModel, Integer> {
    List<PessoaModel> findByNomeContainingIgnoreCaseAndCpf(String nome, String cpf);

    List<PessoaModel> findByNomeContainingIgnoreCase(String nome);

    Optional<PessoaModel> findByCpf(String cpf);
}
