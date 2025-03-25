package org.projetoverdinho.projetoverdinhoapi.repository;

import org.projetoverdinho.projetoverdinhoapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
