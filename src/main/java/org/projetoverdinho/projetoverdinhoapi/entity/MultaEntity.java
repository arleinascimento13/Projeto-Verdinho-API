package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "multas")
public class MultaEntity {

    @Column(name = "valor")
    @Basic(optional = false)
    private double valor;

    @Column(name = "pago")
    @Basic(optional = false)
    private boolean pago;
}
