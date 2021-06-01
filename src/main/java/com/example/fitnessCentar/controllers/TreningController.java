package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Trening;
import com.example.fitnessCentar.entities.dto.FitnesCentarDto;
import com.example.fitnessCentar.entities.dto.TreningDto;
import com.example.fitnessCentar.services.FitnesCentarService;
import com.example.fitnessCentar.services.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/Trening", produces = MediaType.APPLICATION_JSON_VALUE)
public class TreningController {
    @Autowired
    private TreningService treningService;

    @GetMapping(value ="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDto>> getAllTrening(){
        List<Trening> listaTreninga = treningService.findAll();
        List<TreningDto> listaTreningDto = new ArrayList<>();

        for(Trening trening: listaTreninga){
            TreningDto treningDto = new TreningDto(
                    trening.getId(),
                    trening.getNaziv(),
                    trening.getOpis(),
                    trening.getTip(),
                    trening.getTrajanje()

            );
            listaTreningDto.add(treningDto);
        }

        return new ResponseEntity<>(listaTreningDto, HttpStatus.OK);
    }
}
