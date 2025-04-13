package org.projetoverdinho.projetoverdinhoapi.dto;

public record ImageDTO(
    Integer id,
    String nome,
    String caminho,
    String extensao,
    Integer pessoaId,
    Integer animalId
) {}
