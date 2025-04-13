package org.projetoverdinho.projetoverdinhoapi.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pessoas")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "cpf", length = 20, unique = true)
    private String cpf;

    @Column(name = "rg", length = 20)
    private String rg;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ImageEntity> images;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.DETACH)
    private OcorrenciaEntity ocorrencia;

    // Construtor padrão
    public PessoaEntity() {
    }

    // Construtor com todos os campos
    // Adicione o campo ao construtor
    public PessoaEntity(Integer id, String name, String cpf, String rg, String endereco, String telefone, String descricao, List<ImageEntity> images, OcorrenciaEntity ocorrencia) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.descricao = descricao;
        this.images = images;
        this.ocorrencia = ocorrencia;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    public OcorrenciaEntity getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(OcorrenciaEntity ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
    // Builder manual
    public static class Builder {
        private Integer id;
        private String name;
        private String cpf;
        private String rg;
        private String endereco;
        private String telefone;
        private String descricao;
        private List<ImageEntity> images;
        private OcorrenciaEntity ocorrencia;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder rg(String rg) {
            this.rg = rg;
            return this;
        }

        public Builder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder images(List<ImageEntity> images) {
            this.images = images;
            return this;
        }



        public Builder ocorrencia(OcorrenciaEntity ocorrencia) {
            this.ocorrencia = ocorrencia;
            return this;
        }

        public PessoaEntity build() {
            return new PessoaEntity(id, name, cpf, rg, endereco, telefone, descricao, images, ocorrencia);
        }
    }
}
