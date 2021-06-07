package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TerminDto {

    private Long id;
    private Date pocetak;
    private double cijena;
    private int brPrijavljenih;
    private int oznaka;
    private tipTreninga tip;
    private String naziv;

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

    public int getBrPrijavljenih() {
        return brPrijavljenih;
    }

    public void setBrPrijavljenih(int brPrijavljenih) {
        this.brPrijavljenih = brPrijavljenih;
    }

    public int getOznaka() {
        return oznaka;
    }

    public void setOznaka(int oznaka) {
        this.oznaka = oznaka;
    }

    public tipTreninga getTip() {
        return tip;
    }

    public void setTip(tipTreninga tip) {
        this.tip = tip;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public TerminDto(Long id, Date pocetak, double cijena, int brPrijavljenih, int oznaka, tipTreninga tip, String naziv) {
        this.id = id;
        this.pocetak = pocetak;
        this.cijena = cijena;
        this.brPrijavljenih = brPrijavljenih;
        this.oznaka = oznaka;
        this.tip = tip;
        this.naziv = naziv;
    }

    public TerminDto(){}
}
