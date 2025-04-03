package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

import lombok.*;
import org.projetoverdinho.projetoverdinhoapi.enumerator.Role;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
    //A notação significa que o parametro é obrigatorio
    @Basic(optional = false)
    @Column(name = "role")
    private Role role;

    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    @Column(name = "sector")
    private String sector;
}
