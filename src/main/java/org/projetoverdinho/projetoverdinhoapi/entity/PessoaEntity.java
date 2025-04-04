package org.projetoverdinho.projetoverdinhoapi.entity;


import jakarta.persistence.*;




@Entity
@Table(name = "pessoas")
public class PessoaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_cad_cpf")
    private List<Imagem> imagens;
    */

    // Construtor padrão
    public PessoaEntity() {
    }


    // Construtor com todos os campos
    public PessoaEntity(Integer id, String cpf, String rg, String endereco, String telefone,/* Integer imagemLimit*/ String descricao) {
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        //this.imagemLimit = imagemLimit;
        this.descricao = descricao;
    }


    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    /*
    public Integer getImagemLimit() {
        return imagemLimit;
    }

    public void setImagemLimit(Integer imagemLimit) {
        this.imagemLimit = imagemLimit;
    }
    */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    // Builder manual
    public static class Builder {
        private Integer id;
        private String cpf;
        private String rg;
        private String endereco;
        private String telefone;
        private Integer imagemLimit;
        private String descricao;

        public Builder id(Integer id) {
            this.id = id;
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

        public Builder imagemLimit(Integer imagemLimit) {
            this.imagemLimit = imagemLimit;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public PessoaEntity build() {
            return new PessoaEntity(id, cpf, rg, endereco, telefone, /*imagemLimit*/ descricao);
        }
    }
}
