package org.projetoverdinho.projetoverdinhoapi.dto;

import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;

public record PessoaDTO(
        String nome,
        String rg,
        String cpf,
        String telefone,
        String imgUrl
) {
}