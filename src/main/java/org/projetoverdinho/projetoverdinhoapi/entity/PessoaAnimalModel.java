package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa_animais")
public class PessoaAnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "donoatual", nullable = false)
    private Boolean donoAtual = true;

    @Column(name = "dataaquisicao", nullable = false)
    private LocalDate dataAquisicao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoaid")
    private PessoaModel pessoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animalid")
    private AnimalModel animal;

    // Getters e Setters


    public Long getId() {
        return id;
    }

    public Boolean getDonoAtual() {
        return donoAtual;
    }

    public void setDonoAtual(Boolean donoAtual) {
        this.donoAtual = donoAtual;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public PessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.pessoa = pessoa;
    }

    public AnimalModel getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalModel animal) {
        this.animal = animal;
    }
}

