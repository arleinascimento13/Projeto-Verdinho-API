package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.dto.UserDTO;
import org.projetoverdinho.projetoverdinhoapi.entity.UserEntity;
import org.projetoverdinho.projetoverdinhoapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserRepository create(UserDTO userDTO){
        //ADICIONAR VERIFICAÇÃO JWT PARA CRIA USUARIO ROLE ADMIN
        var user = UserEntity
                .builder()
                .password(userDTO.password())
                .username(userDTO.username())
                .name(userDTO.name())
                .phoneNumber(userDTO.phoneNumber())
                .sector(userDTO.sector())
                .role(userDTO.role())
                .build();
         repository.save(user);
         return repository;
    }

    public String login(UserDTO dto){

        return null;
    }

    public UserRepository remove(UserDTO dto){

        return null;
    }

    public UserRepository[] getaAll(UserDTO dto){

        return null;
    }

}
