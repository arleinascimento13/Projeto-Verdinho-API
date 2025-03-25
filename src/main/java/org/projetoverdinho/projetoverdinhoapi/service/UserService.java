package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.dto.UserCreateDTO;
import org.projetoverdinho.projetoverdinhoapi.entity.UserEntity;
import org.projetoverdinho.projetoverdinhoapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public String create(UserCreateDTO userDTO){
        //ADICIONAR VERIFICAÇÃO JWT PARA CRIA USUARIO ROLE ADMIN
        UserEntity user = UserEntity
                .builder()
                .password(userDTO.password())
                .username(userDTO.username())
                .name(userDTO.name())
                .phoneNumber(userDTO.phoneNumber())
                .sector(userDTO.sector())
                .build();
        return "" + repository.save(user).getId();
    }
}
