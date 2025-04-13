package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ocorrencias")
public class OcorrenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private AnimalEntity animal;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private PessoaEntity pessoa;

    @Column(name = "descricao")
    private String descricao;

    // Construtor padrão
    public OcorrenciaEntity() {
    }

    // Construtor com todos os campos
    public OcorrenciaEntity(Integer id, AnimalEntity animal, PessoaEntity pessoa, String descricao) {
        this.id = id;
        this.animal = animal;
        this.pessoa = pessoa;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AnimalEntity getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalEntity animal) {
        this.animal = animal;
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Builder manual
    public static class Builder {
        private Integer id;
        private AnimalEntity animal;
        private PessoaEntity pessoa;
        private String descricao;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder animal(AnimalEntity animal) {
            this.animal = animal;
            return this;
        }

        public Builder pessoa(PessoaEntity pessoa) {
            this.pessoa = pessoa;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public OcorrenciaEntity build() {
            return new OcorrenciaEntity(id, animal, pessoa, descricao);
        }
    }
}
