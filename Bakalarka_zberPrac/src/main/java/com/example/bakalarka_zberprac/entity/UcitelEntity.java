package com.example.bakalarka_zberprac.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ucitel", schema = "sepetkova", catalog = "zber_prac")
public class UcitelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ucitel")
    private int idUcitel;
    @Basic
    @Column(name = "meno")
    private String meno;
    @Basic
    @Column(name = "priezvisko")
    private String priezvisko;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "heslo")
    private String heslo;
    @Basic
    @Column(name = "jeadmin")
    private Boolean jeadmin;

    public int getIdUcitel() {
        return idUcitel;
    }

    public void setIdUcitel(int idUcitel) {
        this.idUcitel = idUcitel;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public Boolean getJeadmin() {
        return jeadmin;
    }

    public void setJeadmin(Boolean jeadmin) {
        this.jeadmin = jeadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UcitelEntity that = (UcitelEntity) o;
        return idUcitel == that.idUcitel && Objects.equals(meno, that.meno) && Objects.equals(priezvisko, that.priezvisko) && Objects.equals(login, that.login) && Objects.equals(heslo, that.heslo) && Objects.equals(jeadmin, that.jeadmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUcitel, meno, priezvisko, login, heslo, jeadmin);
    }
}
