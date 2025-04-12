package org.projetoverdinho.projetoverdinhoapi.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "configs")
public class ConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "meta_tag")
    private String meta_tag;

    @Column(name = "meta_value")
    private String meta_value;

    // Construtor padrão
    public ConfigEntity() {
    }

    // Construtor com todos os campos
    public ConfigEntity(String id, String meta_tag, String meta_value) {
        this.id = id;
        this.meta_tag = meta_tag;
        this.meta_value = meta_value;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getmeta_tag() {
        return meta_tag;
    }

    public void setmeta_tag(String meta_tag) {
        this.meta_tag = meta_tag;
    }

    public String getmeta_value() {
        return meta_value;
    }

    public void setmeta_value(String meta_value) {
        this.meta_value = meta_value;
    }

    // Builder manual
    public static class Builder {
        private String id;
        private String meta_tag;
        private String meta_value;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder meta_tag(String meta_tag) {
            this.meta_tag = meta_tag;
            return this;
        }

        public Builder meta_value(String meta_value) {
            this.meta_value = meta_value;
            return this;
        }

        public ConfigEntity build() {
            return new ConfigEntity(id, meta_tag, meta_value);
        }
    }
}
