package com.example.bakalarka_zberprac.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "posudky", schema = "sepetkova", catalog = "zber_prac")
public class PosudkyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_posudok")
    private int idPosudok;
    @Basic
    @Column(name = "id_praca")
    private Integer idPraca;
    @Basic
    @Column(name = "komentar")
    private String komentar;
    @Basic
    @Column(name = "autor_posudku")
    private String autorPosudku;

    public int getIdPosudok() {
        return idPosudok;
    }

    public void setIdPosudok(int idPosudok) {
        this.idPosudok = idPosudok;
    }

    public Integer getIdPraca() {
        return idPraca;
    }

    public void setIdPraca(Integer idPraca) {
        this.idPraca = idPraca;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getAutorPosudku() {
        return autorPosudku;
    }

    public void setAutorPosudku(String autorPosudku) {
        this.autorPosudku = autorPosudku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosudkyEntity that = (PosudkyEntity) o;
        return idPosudok == that.idPosudok && Objects.equals(idPraca, that.idPraca) && Objects.equals(komentar, that.komentar) && Objects.equals(autorPosudku, that.autorPosudku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPosudok, idPraca, komentar, autorPosudku);
    }
}
