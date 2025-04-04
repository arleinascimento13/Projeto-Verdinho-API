package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "images")
public class ImagenEntity {

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

    // Construtor padrão
    public ImagenEntity() {
    }

    // Construtor com todos os campos
    public ImagenEntity(Integer id, String nome, String caminho, String extensao) {
        this.id = id;
        this.nome = nome;
        this.caminho = caminho;
        this.extensao = extensao;
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

    // Builder manual
    public static class Builder {
        private Integer id;
        private String nome;
        private String caminho;
        private String extensao;

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

        public ImagenEntity build() {
            return new ImagenEntity(id, nome, caminho, extensao);
        }
    }
}

