package com.example.bakalarka_zberprac.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tag", schema = "sepetkova", catalog = "zber_prac")
public class TagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tag")
    private int idTag;
    @Basic
    @Column(name = "tag")
    private String tag;

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagEntity tagEntity = (TagEntity) o;
        return idTag == tagEntity.idTag && Objects.equals(tag, tagEntity.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTag, tag);
    }
}
