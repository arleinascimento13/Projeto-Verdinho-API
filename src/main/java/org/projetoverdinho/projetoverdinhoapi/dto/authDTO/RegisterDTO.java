package org.projetoverdinho.projetoverdinhoapi.dto.authDTO;

import org.projetoverdinho.projetoverdinhoapi.enumerator.Role;

public record RegisterDTO(String senha, String nome, String cpf, String telefone, Role role) {
}
