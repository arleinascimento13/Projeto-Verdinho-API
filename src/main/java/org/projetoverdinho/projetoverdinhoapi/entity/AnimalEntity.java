package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "animal")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "antigo_dono_id")
    private PessoaEntity antigoDono;

    @ManyToOne
    @JoinColumn(name = "atual_dono_id")
    private PessoaEntity atualDono;

    @Column(name = "especie")
    private String especie;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenEntity> images;

    // Construtor padrão
    public AnimalEntity() {
    }

    // Construtor com todos os campos
    public AnimalEntity(Integer id, PessoaEntity antigoDono, PessoaEntity atualDono, String especie, String descricao, List<ImagenEntity> images) {
        this.id = id;
        this.antigoDono = antigoDono;
        this.atualDono = atualDono;
        this.especie = especie;
        this.descricao = descricao;
        this.images = images;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PessoaEntity getAntigoDono() {
        return antigoDono;
    }

    public void setAntigoDono(PessoaEntity antigoDono) {
        this.antigoDono = antigoDono;
    }

    public PessoaEntity getAtualDono() {
        return atualDono;
    }

    public void setAtualDono(PessoaEntity atualDono) {
        this.atualDono = atualDono;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ImagenEntity> getimages() {
        return images;
    }

    public void setimages(List<ImagenEntity> images) {
        this.images = images;
    }

    // Builder manual
    public static class Builder {
        private Integer id;
        private PessoaEntity antigoDono;
        private PessoaEntity atualDono;
        private String especie;
        private String descricao;
        private List<ImagenEntity> images;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder antigoDono(PessoaEntity antigoDono) {
            this.antigoDono = antigoDono;
            return this;
        }

        public Builder atualDono(PessoaEntity atualDono) {
            this.atualDono = atualDono;
            return this;
        }

        public Builder especie(String especie) {
            this.especie = especie;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder images(List<ImagenEntity> images) {
            this.images = images;
            return this;
        }

        public AnimalEntity build() {
            return new AnimalEntity(id, antigoDono, atualDono, especie, descricao, images);
        }
    }
}
