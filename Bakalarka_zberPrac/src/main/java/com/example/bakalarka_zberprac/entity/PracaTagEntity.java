package com.example.bakalarka_zberprac.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "praca_tag", schema = "sepetkova", catalog = "zber_prac")
public class PracaTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_praca_tag")
    private int idPracaTag;
    @Basic
    @Column(name = "id_tag")
    private Integer idTag;
    @Basic
    @Column(name = "id_praca")
    private Integer idPraca;

    public int getIdPracaTag() {
        return idPracaTag;
    }

    public void setIdPracaTag(int idPracaTag) {
        this.idPracaTag = idPracaTag;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public Integer getIdPraca() {
        return idPraca;
    }

    public void setIdPraca(Integer idPraca) {
        this.idPraca = idPraca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracaTagEntity that = (PracaTagEntity) o;
        return idPracaTag == that.idPracaTag && Objects.equals(idTag, that.idTag) && Objects.equals(idPraca, that.idPraca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPracaTag, idTag, idPraca);
    }
}
