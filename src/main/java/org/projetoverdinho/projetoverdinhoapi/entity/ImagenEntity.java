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
    Integer id;

    @Basic(optional = false)
    @Column(name = "nome")
    String nome;

    @Basic(optional = false)
    @Column(name = "caminho")
    String caminho;


    @Basic(optional = false)
    @Column(name = "extensao")
    String extensao;

}
