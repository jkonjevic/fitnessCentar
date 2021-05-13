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

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ocijena> ocijene = new HashSet<>();

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

    public Termin(Long id, Date pocetak, double cijena, Sala sala, Trening trening, Set<Ocijena> ocijene) {
        this.id = id;
        this.pocetak = pocetak;
        this.cijena = cijena;
        this.sala = sala;
        this.trening = trening;
        this.ocijene = ocijene;
    }

    public Termin(){}
}
