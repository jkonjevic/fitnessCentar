package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.Korisnik;
import com.example.fitnessCentar.entities.Ocijena;
import com.example.fitnessCentar.entities.Sala;
import com.example.fitnessCentar.entities.Trening;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TerminDto {

    private Long id;
    private Date pocetak;
    private double cijena;
    private int brPrijavljenih;
    private SalaDto sala;
    private TreningDto trening;

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

    public SalaDto getSala() {
        return sala;
    }

    public void setSala(SalaDto sala) {
        this.sala = sala;
    }

    public TreningDto getTrening() {
        return trening;
    }

    public void setTrening(TreningDto trening) {
        this.trening = trening;
    }


    public int getBrPrijavljenih() {
        return brPrijavljenih;
    }

    public void setBrPrijavljenih(int brPrijavljenih) {
        this.brPrijavljenih = brPrijavljenih;
    }

    public TerminDto(Long id, Date pocetak, double cijena, int brPrijavljenih, SalaDto sala, TreningDto trening) {
        this.id = id;
        this.pocetak = pocetak;
        this.cijena = cijena;
        this.brPrijavljenih = brPrijavljenih;
        this.sala = sala;
        this.trening = trening;
    }
    public TerminDto(){}
}
