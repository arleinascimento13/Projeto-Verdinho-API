package org.projetoverdinho.projetoverdinhoapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.projetoverdinho.projetoverdinhoapi.enumerator.StatusAtivo;


@Entity
@Table(name = "pessoa")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "rg", nullable = true)
    private String rg;

    @Column(name = "cpf", nullable = true, unique = true)
    private String cpf;

    @Column(name = "imgurl", nullable = true)
    private String imgUrl;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "endereco", nullable = true)
    private String endereco;

    @Schema(description = "Status: 0 - desativado, 1 - ativo")
    @Column(name = "status", nullable = false)
    private StatusAtivo status;


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public StatusAtivo getStatus() {
        return status;
    }

    public void setStatus(StatusAtivo status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}