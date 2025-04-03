package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "images")
public class ImagenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @Column(name = "caminho")
    private String caminho;

s
    @Basic(optional = false)
    @Column(name = "extensao")
    private String extensao;

}
