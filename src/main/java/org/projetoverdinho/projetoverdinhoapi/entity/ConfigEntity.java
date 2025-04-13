package org.projetoverdinho.projetoverdinhoapi.entity;

import io.swagger.models.auth.In;
import jakarta.persistence.*;

@Entity
@Table(name = "configs")
public class ConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "metaTag")
    private String metaTag;

    @Column(name = "metaValue")
    private String metaValue;

    // Construtor padrão
    public ConfigEntity() {
    }

    // Construtor com todos os campos
    public ConfigEntity(Integer id, String metaTag, String metaValue) {
        this.id = id;
        this.metaTag = metaTag;
        this.metaValue = metaValue;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmetatag() {
        return metaTag;
    }

    public void setmetatag(String metatag) {
        this.metaTag = metatag;
    }

    public String getmetavalue() {
        return metaValue;
    }

    public void setmetavalue(String metavalue) {
        this.metaValue = metavalue;
    }

    // Builder manual
    public static class Builder {
        private Integer id;
        private String metaTag;
        private String metaValue;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder metatag(String metaTag) {
            this.metaTag = metaTag;
            return this;
        }

        public Builder metavalue(String metaValue) {
            this.metaValue = metaValue;
            return this;
        }

        public ConfigEntity build() {
            return new ConfigEntity(id, metaTag, metaValue);
        }
    }
}
