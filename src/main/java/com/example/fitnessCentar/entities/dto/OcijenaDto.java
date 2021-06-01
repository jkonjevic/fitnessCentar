package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.Korisnik;
import com.example.fitnessCentar.entities.Ocijena;
import com.example.fitnessCentar.entities.Termin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class OcijenaDto {

    private Long id;
    private KorisnikDto korisnik;
    private TerminDto termin;
    private int ocijena;

    public OcijenaDto(Long id, KorisnikDto korisnik, TerminDto termin, int ocijena) {
        this.id = id;
        this.korisnik = korisnik;
        this.termin = termin;
        this.ocijena = ocijena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KorisnikDto getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(KorisnikDto korisnik) {
        this.korisnik = korisnik;
    }

    public TerminDto getTermin() {
        return termin;
    }

    public void setTermin(TerminDto termin) {
        this.termin = termin;
    }

    public int getOcijena() {
        return ocijena;
    }

    public void setOcijena(int ocijena) {
        this.ocijena = ocijena;
    }
    public OcijenaDto(){}

}

