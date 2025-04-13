package org.projetoverdinho.projetoverdinhoapi.dto;

import java.util.List;

public record AnimalDTO(
    Integer id,
    Integer antigoDono,
    Integer atualDono,
    String especie,
    String descricao,
    List<String> images
) {}
