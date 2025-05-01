package org.projetoverdinho.projetoverdinhoapi.dto;

import java.time.LocalDate;

public record MultaAnimalDTO(
        Long id,
        String descricao,
        int valor,
        Long animal_id,
        LocalDate dataMulta,
        Integer status,
        String motivoCancelamento,
        String urlComprovante
) {
}
