package org.projetoverdinho.projetoverdinhoapi.dto;

import java.util.List;

public record PessoaDTO(
        Integer id,
        String name,
        String cpf,
        String rg,
        String endereco,
        String telefone,
        String descricao,
        List<Integer> imagesIds
) {
}
