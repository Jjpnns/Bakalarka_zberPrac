package com.example.bakalarka_zberprac.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "priloha", schema = "sepetkova", catalog = "zber_prac")
public class PrilohaEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id_priloha")
  private int idPriloha;
  @Basic
  @Column(name = "nazov")
  private String nazov;
  @Basic
  @Column(name = "datum_nahratia")
  private Date datum_nahratia;
  @Basic
  @Column(name = "typ")
  private Byte typ;



  // Getter pre idPriloha
  public int getIdPriloha() {
    return idPriloha;
  }

  // Setter pre idPriloha
  public void setIdPriloha(int idPriloha) {
    this.idPriloha = idPriloha;
  }

  // Getter pre nazov
  public String getNazov() {
    return nazov;
  }

  // Setter pre nazov
  public void setNazov(String nazov) {
    this.nazov = nazov;
  }

  // Getter pre datumNahratia
  public Date getDatumNahratia() {
    return datum_nahratia;
  }

  // Setter pre datumNahratia
  public void setDatumNahratia(Date datumNahratia) {
    this.datum_nahratia = datumNahratia;
  }

  // Getter pre typ
  public Byte getTyp() {
    return typ;
  }

  // Setter pre typ
  public void setTyp(Byte typ) {
    this.typ = typ;
  }



}
