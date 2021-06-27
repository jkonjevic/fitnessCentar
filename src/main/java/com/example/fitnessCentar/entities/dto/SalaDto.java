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
    private FitnesCentarDto fitnesCentarDto;

    public FitnesCentarDto getFitnesCentarDto() {
        return fitnesCentarDto;
    }

    public void setFitnesCentarDto(FitnesCentarDto fitnesCentarDto) {
        this.fitnesCentarDto = fitnesCentarDto;
    }

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

    public void setOznaka(Integer oznaka) {
        this.oznaka = oznaka;
    }


    public SalaDto(Long id, Integer kapacitet, Integer oznaka) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;

    }

    public SalaDto(){}


}
