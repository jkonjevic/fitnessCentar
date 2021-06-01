package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.tipTreninga;

public class TreningDto {
    private Long id;

    private String naziv;

    private String opis;

    private tipTreninga tip;

    private int trajanje;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public tipTreninga getTip() {
        return tip;
    }

    public void setTip(tipTreninga tip) {
        this.tip = tip;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }


    public TreningDto(Long id, String naziv, String opis, tipTreninga tip, int trajanje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;

    }
    public TreningDto(){}



}
