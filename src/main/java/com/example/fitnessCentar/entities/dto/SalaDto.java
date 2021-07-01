package com.example.fitnessCentar.entities.dto;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Termin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class SalaDto {

    private Long id;
    private Integer kapacitet;
    private Integer oznaka;
    private Long idCentra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) { this.kapacitet = kapacitet; }

    public Integer getOznaka() {
        return oznaka;
    }

    public Long getIdCentra() {
        return idCentra;
    }

    public void setIdCentra(Long idCentra) {
        this.idCentra = idCentra;
    }

    public void setOznaka(Integer oznaka) {
        this.oznaka = oznaka;
    }


    public SalaDto(Long id, Integer kapacitet, Integer oznaka, Long idCentra) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.idCentra = idCentra;

    }

    public SalaDto(){}


}
