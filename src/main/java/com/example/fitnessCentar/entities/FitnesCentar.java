package com.example.fitnessCentar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FitnesCentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column(unique = true,nullable = false)
    private String Adresa;

    @Column
    private String brCentrale;

    @Column(unique = true,nullable = false)
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getBrCentrale() {
        return brCentrale;
    }

    public void setBrCentrale(String brCentrale) {
        this.brCentrale = brCentrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Sala> getListaSala() {
        return listaSala;
    }

    public void setListaSala(Set<Sala> listaSala) {
        this.listaSala = listaSala;
    }

    public Set<Korisnik> getListaTrenera() {
        return listaTrenera;
    }

    public void setListaTrenera(Set<Korisnik> listaTrenera) {
        this.listaTrenera = listaTrenera;
    }

    public FitnesCentar(Long id, String naziv, String adresa, String brCentrale, String email, Set<Sala> listaSala, Set<Korisnik> listaTrenera) {
        this.id = id;
        this.naziv = naziv;
        Adresa = adresa;
        this.brCentrale = brCentrale;
        this.email = email;
        this.listaSala = listaSala;
        this.listaTrenera = listaTrenera;
    }

    public FitnesCentar(){}



    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> listaSala = new HashSet<>();

    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Korisnik> listaTrenera = new HashSet<>();
}
