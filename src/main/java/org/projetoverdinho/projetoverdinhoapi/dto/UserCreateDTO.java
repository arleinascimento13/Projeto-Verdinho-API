package org.projetoverdinho.projetoverdinhoapi.dto;

import org.projetoverdinho.projetoverdinhoapi.enumerator.Role;

//Basico do basico para criação de usuarios
public record UserCreateDTO(String name,
                            String phoneNumber,
                            Role role,
                            String password,
                            String username,
                            String sector
                            ) {}
