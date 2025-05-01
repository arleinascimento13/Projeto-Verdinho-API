package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "multas_animais")
public class MultaAnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    private AnimalModel animal;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int valor;

    @Column(name = "data_multa", nullable = false)
    private LocalDate dataMulta;

    @Column(nullable = false)
    private Integer status; // 0 = ativa, 1 = paga, 2 = cancelada

    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;

    @Column(name = "url_comprovante")
    private String urlComprovante;



    public Long getId() {
        return id;
    }

    public AnimalModel getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalModel animal) {
        this.animal = animal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public LocalDate getDataMulta() {
        return dataMulta;
    }

    public void setDataMulta(LocalDate dataMulta) {
        this.dataMulta = dataMulta;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public String getUrlComprovante() {
        return urlComprovante;
    }

    public void setUrlComprovante(String urlComprovante) {
        this.urlComprovante = urlComprovante;
    }
}
