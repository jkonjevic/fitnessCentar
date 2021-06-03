package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.Korisnik;
import com.example.fitnessCentar.entities.Ocijena;
import com.example.fitnessCentar.entities.Termin;
import com.example.fitnessCentar.entities.tipTreninga;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OcijenaDto {

    @JsonIgnore
   // private Set<Ocijena> listaOcijena = new HashSet<>();
    private Date pocetak;
    private String nazivTreninga;
    private String korisnickoIme;
    private int ocijena;
    private String imeTrenera;
    private String prezimeTrenera;
    private tipTreninga tip;


    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public String getNazivTreninga() {
        return nazivTreninga;
    }

    public void setNazivTreninga(String nazivTreninga) {
        this.nazivTreninga = nazivTreninga;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public int getOcijena() {
        return ocijena;
    }

    public void setOcijena(int ocijena) {
        this.ocijena = ocijena;
    }

    public String getImeTrenera() {
        return imeTrenera;
    }

    public void setImeTrenera(String imeTrenera) {
        this.imeTrenera = imeTrenera;
    }

    public String getPrezimeTrenera() {
        return prezimeTrenera;
    }

    public void setPrezimeTrenera(String prezimeTrenera) {
        this.prezimeTrenera = prezimeTrenera;
    }

    public tipTreninga getTip() {
        return tip;
    }

    public void setTip(tipTreninga tip) {
        this.tip = tip;
    }


    public OcijenaDto(Date pocetak, String nazivTreninga, String korisnickoIme, int ocijena, String imeTrenera, String prezimeTrenera, tipTreninga tip) {
        this.pocetak = pocetak;
        this.nazivTreninga = nazivTreninga;
        this.korisnickoIme = korisnickoIme;
        this.ocijena = ocijena;
        this.imeTrenera = imeTrenera;
        this.prezimeTrenera = prezimeTrenera;
        this.tip = tip;
    }

    public OcijenaDto(){}

}

