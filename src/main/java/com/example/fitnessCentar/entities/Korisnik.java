package com.example.fitnessCentar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String korisnickoIme;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false)
    private String lozinka;

    @Column(nullable = false)
    private String ime;

    @Column
    private  String kontakt;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String datum;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Uloga uloga;

    @Column(nullable = false)
    boolean aktivan;

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Long getId() {
        return id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }

    public String getKontak() {
        return kontakt;
    }

    public String getEmail() {
        return email;
    }

    public String getDatum() {
        return datum;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setKontak(String kontak) {
        this.kontakt = kontakt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public Set<Trening> getTrenerRaspored() {
        return trenerRaspored;
    }

    public void setTrenerRaspored(Set<Trening> trenerRaspored) {
        this.trenerRaspored = trenerRaspored;
    }

    public Set<Ocijena> getKorisnikOcjene() {
        return korisnikOcjene;
    }

    public void setKorisnikOcjene(Set<Ocijena> korisnikOcjene) {
        this.korisnikOcjene = korisnikOcjene;
    }

    public FitnesCentar getFitnesCentar() {
        return fitnesCentar;
    }

    public void setFitnesCentar(FitnesCentar fitnesCentar) {
        this.fitnesCentar = fitnesCentar;
    }

    public Set<Termin> getPrijave() {
        return prijave;
    }

    public void setPrijave(Set<Termin> prijave) {
        this.prijave = prijave;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Korisnik(Long id, String korisnickoIme, String prezime, String lozinka, String ime, String kontakt, String email, String datum, Uloga uloga, boolean aktivan) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.kontakt = kontakt;
        this.email = email;
        this.datum = datum;
        this.uloga = uloga;
        this.aktivan = aktivan;

    }

    public Korisnik() {
    }

    @OneToMany(mappedBy = "trener",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trening> trenerRaspored = new HashSet<>();

    @OneToMany(mappedBy = "korisnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ocijena> korisnikOcjene = new HashSet<>();

    @ManyToOne
    private FitnesCentar fitnesCentar;

    @ManyToMany
    @JoinTable(name = "prijavljeni",
            joinColumns = @JoinColumn(name="korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> prijave = new HashSet<>();

}
