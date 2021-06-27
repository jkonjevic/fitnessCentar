package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.Uloga;

public class TrenerDto {

    private Long id;
    private String korisnickoIme;
    private String prezime;
    private String lozinka;
    private String ime;
    private  String kontakt;
    private String email;
    private String datum;
    private Uloga uloga;
    boolean aktivan;
    private Long idFitnesCentra;


    public Long getIdFitnesCentra() {
        return idFitnesCentra;
    }

    public void setIdFitnesCentra(Long idFitnesCentra) {
        this.idFitnesCentra = idFitnesCentra;
    }

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

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean getAktivan(boolean aktivan){
        return aktivan;
    }

    public TrenerDto(Long id, String korisnickoIme, String prezime, String lozinka, String ime, String kontakt, String email, String datum,Uloga uloga, boolean aktivan, Long idFitnesCentra) {
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
        this.idFitnesCentra = idFitnesCentra;

    }

    public TrenerDto() {
    }

}
