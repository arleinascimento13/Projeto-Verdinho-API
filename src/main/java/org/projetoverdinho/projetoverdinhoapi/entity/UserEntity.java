package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.projetoverdinho.projetoverdinhoapi.enumerator.Role;

@Setter @Getter @Builder
@Entity
@Table(name = "tb_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "role")
    private Role role;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "sector")
    private String sector;
}
