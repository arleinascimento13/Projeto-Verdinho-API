package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import org.hibernate.annotations.ColumnDefault;

public class ConfigEntity {
    @Column(name = "pessoa_image_limit")
    @ColumnDefault("3")
    private Integer PessoaImagemLimit;

    @Column(name = "animal_image_limit")
    @ColumnDefault("3")
    private Integer animal_image_limit;
}
