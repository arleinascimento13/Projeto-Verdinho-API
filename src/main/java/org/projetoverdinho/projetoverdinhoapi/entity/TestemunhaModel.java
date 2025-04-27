package org.projetoverdinho.projetoverdinhoapi.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.projetoverdinho.projetoverdinhoapi.enumerator.StatusAtivo;

@Entity
@Table(name = "testemunhas")
public class TestemunhaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Column(name = "telefone", nullable = true)
    private String telefone;

    @Column(name = "cpf", nullable = true, unique = true)
    private String cpf;

    @Schema(description = "Status: 0 - desativado, 1 - ativo")
    @Column(name = "status", nullable = false)
    private StatusAtivo status;

    public StatusAtivo getStatus() {
        return status;
    }

    public void setStatus(StatusAtivo status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "TestemunhaModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", status=" + status +
                '}';
    }
}
