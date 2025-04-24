package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa_animais")
public class PessoaAnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "animalid", nullable = false)
    private Long animalId;

    @Column(name = "donoatual", nullable = false)
    private Boolean donoAtual = true;

    @Column(name = "dataaquisicao", nullable = false)
    private LocalDate dataAquisicao = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaid", insertable = false, updatable = false)
    private PessoaModel pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animalid", insertable = false, updatable = false)
    private AnimalModel animal;

    // Getters e Setters

    public PessoaModel getPessoa() {
        return pessoa;
    }

    public Long getId() {
        return id;
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

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
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
}

