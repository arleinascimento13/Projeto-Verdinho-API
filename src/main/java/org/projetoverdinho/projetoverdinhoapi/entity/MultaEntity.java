package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "multas")
public class MultaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor")
    @Basic(optional = false)
    private double valor;

    @Column(name = "pago")
    @Basic(optional = false)
    private boolean pago;
}
