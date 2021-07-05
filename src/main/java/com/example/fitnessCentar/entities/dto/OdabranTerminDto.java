package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.tipTreninga;

import java.util.Date;

public class OdabranTerminDto {
    private Long id;
    private Date pocetak;
    private double cijena;
    private int oznaka;
    private tipTreninga tip;
    private String naziv;
    private String opis;
    private int kapacitet;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

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

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public OdabranTerminDto(Long id, Date pocetak, double cijena, int oznaka, tipTreninga tip, String naziv, String opis, int kapacitet) {
        this.id = id;
        this.pocetak = pocetak;
        this.cijena = cijena;
        this.oznaka = oznaka;
        this.tip = tip;
        this.naziv = naziv;
        this.opis = opis;
        this.kapacitet= kapacitet;
    }

    public OdabranTerminDto(){}
}

