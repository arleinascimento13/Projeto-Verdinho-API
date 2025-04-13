package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @Column(name = "caminho")
    private String caminho;

    @Basic(optional = false)
    @Column(name = "extensao")
    private String extensao;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pessoa;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private AnimalEntity animal;

    // Construtor padrão
    public ImageEntity() {
    }

    // Construtor com todos os campos
    public ImageEntity(Integer id, String nome, String caminho, String extensao, PessoaEntity pessoa, AnimalEntity animal) {
        this.id = id;
        this.nome = nome;
        this.caminho = caminho;
        this.extensao = extensao;
        this.pessoa = pessoa;
        this.animal = animal;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    public AnimalEntity getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalEntity animal) {
        this.animal = animal;
    }

    // Builder manual
    public static class Builder {
        private Integer id;
        private String nome;
        private String caminho;
        private String extensao;
        private PessoaEntity pessoa;
        private AnimalEntity animal;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder caminho(String caminho) {
            this.caminho = caminho;
            return this;
        }

        public Builder extensao(String extensao) {
            this.extensao = extensao;
            return this;
        }

        public Builder pessoa(PessoaEntity pessoa) {
            this.pessoa = pessoa;
            return this;
        }

        public Builder animal(AnimalEntity animal) {
            this.animal = animal;
            return this;
        }

        public ImageEntity build() {
            return new ImageEntity(id, nome, caminho, extensao, pessoa, animal);
        }
    }
}
