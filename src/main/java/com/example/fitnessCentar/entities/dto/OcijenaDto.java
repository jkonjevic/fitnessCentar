package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.Korisnik;
import com.example.fitnessCentar.entities.Ocijena;
import com.example.fitnessCentar.entities.Termin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class OcijenaDto {

    private String korisnickoIme;
    private Set<Ocijena> listaOcijena = new HashSet<>();

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Set<Ocijena> getListaOcijena() {
        return listaOcijena;
    }

    public void setListaOcijena(Set<Ocijena> listaOcijena) {
        this.listaOcijena = listaOcijena;
    }

    public OcijenaDto(String korisnickoIme, Set<Ocijena> listaOcijena) {
        this.korisnickoIme = korisnickoIme;
        this.listaOcijena = listaOcijena;
    }
    public OcijenaDto(){}
}

