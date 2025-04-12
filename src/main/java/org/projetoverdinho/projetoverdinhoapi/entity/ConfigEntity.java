package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "configs")
public class ConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "pessoa_image_limit")
    @ColumnDefault("3")
    private Integer pessoaImagemLimit;

    @Column(name = "animal_image_limit")
    @ColumnDefault("3")
    private Integer animalImageLimit;

    // Construtor padrão
    public ConfigEntity() {
    }

    // Construtor com todos os campos
    public ConfigEntity(Integer id, Integer pessoaImagemLimit, Integer animalImageLimit) {
        this.id = id;
        this.pessoaImagemLimit = pessoaImagemLimit;
        this.animalImageLimit = animalImageLimit;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPessoaImagemLimit() {
        return pessoaImagemLimit;
    }

    public void setPessoaImagemLimit(Integer pessoaImagemLimit) {
        this.pessoaImagemLimit = pessoaImagemLimit;
    }

    public Integer getAnimalImageLimit() {
        return animalImageLimit;
    }

    public void setAnimalImageLimit(Integer animalImageLimit) {
        this.animalImageLimit = animalImageLimit;
    }

    // Builder manual
    public static class Builder {
        private Integer id;
        private Integer pessoaImagemLimit;
        private Integer animalImageLimit;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder pessoaImagemLimit(Integer pessoaImagemLimit) {
            this.pessoaImagemLimit = pessoaImagemLimit;
            return this;
        }

        public Builder animalImageLimit(Integer animalImageLimit) {
            this.animalImageLimit = animalImageLimit;
            return this;
        }

        public ConfigEntity build() {
            return new ConfigEntity(id, pessoaImagemLimit, animalImageLimit);
        }
    }
}
