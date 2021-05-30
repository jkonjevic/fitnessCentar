package com.example.fitnessCentar.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Termin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private Date pocetak;

    @Column
    private double cijena;

    @Column
    private int brPrijavljenih;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ocijena> ocijene = new HashSet<>();

    @ManyToMany(mappedBy = "prijave")
    private Set<Korisnik> prijavljeniClanovi = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Set<Ocijena> getOcijene() {
        return ocijene;
    }

    public void setOcijene(Set<Ocijena> ocijene) {
        this.ocijene = ocijene;
    }

    public int getBrPrijavljenih() {
        return brPrijavljenih;
    }

    public void setBrPrijavljenih(int brPrijavljenih) {
        this.brPrijavljenih = brPrijavljenih;
    }

    public Termin(Long id, Date pocetak, double cijena, int brPrijavljenih, Sala sala, Trening trening, Set<Ocijena> ocijene) {
        this.id = id;
        this.pocetak = pocetak;
        this.cijena = cijena;
        this.brPrijavljenih = brPrijavljenih;
        this.sala = sala;
        this.trening = trening;
        this.ocijene = ocijene;
    }

    public Termin(){}
}
