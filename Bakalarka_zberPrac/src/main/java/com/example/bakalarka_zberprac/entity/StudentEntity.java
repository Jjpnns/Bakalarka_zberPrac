package com.example.bakalarka_zberprac.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student", schema = "sepetkova", catalog = "zber_prac")
public class StudentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "os_cislo_st")
    private int osCisloSt;
    @Basic
    @Column(name = "meno")
    private String meno;
    @Basic
    @Column(name = "priezvisko")
    private String priezvisko;

    public int getOsCisloSt() {
        return osCisloSt;
    }

    public void setOsCisloSt(int osCisloSt) {
        this.osCisloSt = osCisloSt;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return osCisloSt == that.osCisloSt && Objects.equals(meno, that.meno) && Objects.equals(priezvisko, that.priezvisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(osCisloSt, meno, priezvisko);
    }
}
