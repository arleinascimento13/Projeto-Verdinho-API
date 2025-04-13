package org.projetoverdinho.projetoverdinhoapi.dto;

public record OcorrenciaDTO(
        Integer id,
        Integer animalId,
        Integer pessoaId,
        String descricao
) {}
