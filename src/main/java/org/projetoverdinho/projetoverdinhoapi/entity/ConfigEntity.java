package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "configs")
public class ConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "pessoa_image_limit")
    @ColumnDefault("3")
    private Integer PessoaImagemLimit;

    @Column(name = "animal_image_limit")
    @ColumnDefault("3")
    private Integer animal_image_limit;
}
