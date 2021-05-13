package com.example.fitnessCentar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


enum tipTreninga{CROSSFIT, GYM, GLADIATOR}

@Entity
public class Trening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column
    private String opis;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private tipTreninga tip;

    @Column(nullable = false)
    private int trajanje;


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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public tipTreninga getTip() {
        return tip;
    }

    public void setTip(tipTreninga tip) {
        this.tip = tip;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Korisnik getTrener() {
        return trener;
    }

    public void setTrener(Korisnik trener) {
        this.trener = trener;
    }

    public Set<Termin> getTermini() {
        return termini;
    }

    public void setTermini(Set<Termin> termini) {
        this.termini = termini;
    }

    public Trening(Long id, String naziv, String opis, tipTreninga tip, int trajanje, double cijena, String pocetak, Set<Termin> termini, Korisnik trener) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;
        this.termini = termini;
        this.trener = trener;
    }

    public Trening(){}

    @OneToMany(mappedBy = "trening", fetch = FetchType.LAZY, cascade =CascadeType.ALL, orphanRemoval = true)
    private Set<Termin> termini = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik trener;


}
