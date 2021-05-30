package com.example.fitnessCentar.entities.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

public class FitnesCentarDto {

    private Long id;
    private String naziv;
    private String adresa;
    private String brCentrale;
    private String email;

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrCentrale() {
        return brCentrale;
    }

    public void setBrCentrale(String brCentrale) {
        this.brCentrale = brCentrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public FitnesCentarDto(Long id, String naziv, String adresa, String brCentrale, String email) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brCentrale = brCentrale;
        this.email = email;

    }

    public FitnesCentarDto(){}

}
