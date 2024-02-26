package com.example.bakalarka_zberprac.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "prava", schema = "sepetkova", catalog = "zber_prac")
public class PravaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_prava")
    private int idPrava;
    @Basic
    @Column(name = "id_praca")
    private Integer idPraca;
    @Basic
    @Column(name = "id_ucitel")
    private Integer idUcitel;
    @Basic
    @Column(name = "typ_prava")
    private String typPrava;
    @Basic
    @Column(name = "platnost_od")
    private Date platnostOd;
    @Basic
    @Column(name = "platnost_do")
    private Date platnostDo;

    public int getIdPrava() {
        return idPrava;
    }

    public void setIdPrava(int idPrava) {
        this.idPrava = idPrava;
    }

    public Integer getIdPraca() {
        return idPraca;
    }

    public void setIdPraca(Integer idPraca) {
        this.idPraca = idPraca;
    }

    public Integer getIdUcitel() {
        return idUcitel;
    }

    public void setIdUcitel(Integer idUcitel) {
        this.idUcitel = idUcitel;
    }

    public String getTypPrava() {
        return typPrava;
    }

    public void setTypPrava(String typPrava) {
        this.typPrava = typPrava;
    }

    public Date getPlatnostOd() {
        return platnostOd;
    }

    public void setPlatnostOd(Date platnostOd) {
        this.platnostOd = platnostOd;
    }

    public Date getPlatnostDo() {
        return platnostDo;
    }

    public void setPlatnostDo(Date platnostDo) {
        this.platnostDo = platnostDo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PravaEntity that = (PravaEntity) o;
        return idPrava == that.idPrava && Objects.equals(idPraca, that.idPraca) && Objects.equals(idUcitel, that.idUcitel) && Objects.equals(typPrava, that.typPrava) && Objects.equals(platnostOd, that.platnostOd) && Objects.equals(platnostDo, that.platnostDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrava, idPraca, idUcitel, typPrava, platnostOd, platnostDo);
    }
}
