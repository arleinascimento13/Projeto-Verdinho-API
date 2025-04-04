package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

import lombok.*;
import org.projetoverdinho.projetoverdinhoapi.enumerator.Role;
import jakarta.persistence.*;

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

    // Construtor padrão
    public UserEntity() {
    }

    // Construtor com todos os campos
    public UserEntity(Integer id, String name, String phoneNumber, Role role, String password, String username, String sector) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.password = password;
        this.username = username;
        this.sector = sector;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    // Builder manual (opcional)
    public static class Builder {
        private Integer id;
        private String name;
        private String phoneNumber;
        private Role role;
        private String password;
        private String username;
        private String sector;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder sector(String sector) {
            this.sector = sector;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(id, name, phoneNumber, role, password, username, sector);
        }
    }
}
