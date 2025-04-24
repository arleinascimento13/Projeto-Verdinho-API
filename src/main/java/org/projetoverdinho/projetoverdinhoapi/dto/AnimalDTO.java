package org.projetoverdinho.projetoverdinhoapi.dto;

import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;

import java.util.List;

public record AnimalDTO(
        Long id,
        List<PessoaModel> antigoDono,
        PessoaModel atualDono,
        String especie,
        String descricao,
        List<String> images
) {
}
