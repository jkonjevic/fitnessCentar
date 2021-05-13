package com.example.fitnessCentar.entities;

import javax.persistence.*;

@Entity
public class Ocijena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int ocijena;


    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;

    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik korisnik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcijena() {
        return ocijena;
    }

    public void setOcijena(int ocijena) {
        this.ocijena = ocijena;
    }


    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Ocijena(Long id, int ocijena, Termin termin, Korisnik korisnik) {
        this.id = id;
        this.ocijena = ocijena;
        this.termin = termin;
        this.korisnik = korisnik;
    }

    public Ocijena() {}
}
