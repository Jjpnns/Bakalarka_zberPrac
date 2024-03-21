package com.example.bakalarka_zberprac.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "praca", schema = "sepetkova", catalog = "zber_prac")
public class PracaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_praca")
    private int idPraca;
    @Basic
    @Column(name = "os_cislo_st")
    private Integer osCisloSt;
    @Basic
    @Column(name = "id_skolitel")
    private Integer idSkolitel;
    @Basic
    @Column(name = " id_oponent")
    private Integer idOponent;
    @Basic
    @Column(name = "stupen")
    private String stupen;
    @Basic
    @Column(name = "nazov")
    private String nazov;
    @Basic
    @Column(name = "zadanie")
    private String zadanie;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "jazyk")
    private String jazyk;
    @Basic
    @Column(name = "datum_odovzdania")
    private Date datumOdovzdania;
    @Basic
    @Column(name = "hodnotenie")
    private String hodnotenie;

    public int getIdPraca() {
        return idPraca;
    }

    public void setIdPraca(int idPraca) {
        this.idPraca = idPraca;
    }

    public Integer getOsCisloSt() {
        return osCisloSt;
    }

    public void setOsCisloSt(Integer osCisloSt) {
        this.osCisloSt = osCisloSt;
    }

    public Integer getIdSkolitel() {
        return idSkolitel;
    }

    public void setIdSkolitel(Integer idSkolitel) {
        this.idSkolitel = idSkolitel;
    }

    public Integer getIdOponent() {
        return idOponent;
    }

    public void setIdOponent(Integer idOponent) {
        this.idOponent = idOponent;
    }

    public String getStupen() {
        return stupen;
    }

    public void setStupen(String stupen) {
        this.stupen = stupen;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getZadanie() {
        return zadanie;
    }

    public void setZadanie(String zadanie) {
        this.zadanie = zadanie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJazyk() {
        return jazyk;
    }

    public void setJazyk(String jazyk) {
        this.jazyk = jazyk;
    }

    public Date getDatumOdovzdania() {
        return datumOdovzdania;
    }

    public void setDatumOdovzdania(Date datumOdovzdania) {
        this.datumOdovzdania = datumOdovzdania;
    }

    public String getHodnotenie() {
        return hodnotenie;
    }

    public void setHodnotenie(String hodnotenie) {
        this.hodnotenie = hodnotenie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracaEntity that = (PracaEntity) o;
        return idPraca == that.idPraca && Objects.equals(osCisloSt, that.osCisloSt) && Objects.equals(idSkolitel, that.idSkolitel) && Objects.equals(idOponent, that.idOponent) && Objects.equals(stupen, that.stupen) && Objects.equals(nazov, that.nazov) && Objects.equals(zadanie, that.zadanie) && Objects.equals(status, that.status) && Objects.equals(jazyk, that.jazyk) && Objects.equals(datumOdovzdania, that.datumOdovzdania) && Objects.equals(hodnotenie, that.hodnotenie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPraca, osCisloSt, idSkolitel, idOponent, stupen, nazov, zadanie, status, jazyk, datumOdovzdania, hodnotenie);
    }
}
