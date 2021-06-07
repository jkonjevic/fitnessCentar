package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Termin;
import com.example.fitnessCentar.entities.dto.FitnesCentarDto;
import com.example.fitnessCentar.entities.dto.TerminDto;
import com.example.fitnessCentar.services.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/termini", produces = MediaType.APPLICATION_JSON_VALUE)
public class TerminController {

    @Autowired
    private TerminService terminService;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> getAllTermini(){
        List<Termin> listaTermina = terminService.findAll();
        List<TerminDto> listaTerminaDto = new ArrayList<>();

        for(Termin termin: listaTermina){
            TerminDto terminDto = new TerminDto(
            termin.getId(),
            termin.getPocetak(),
            termin.getCijena(),
            termin.getSala().getOznaka(),
            termin.getTrening().getTip(),
            termin.getTrening().getNaziv()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping(value="/{cijena}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDto> getTerminDto(@PathVariable Double cijena){
        Optional<Termin> t1 = terminService.findByCijena(cijena);
        if(!t1.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Termin termin = t1.get();
        TerminDto terminDto = new TerminDto(
                termin.getId(),
                termin.getPocetak(),
                termin.getCijena(),
                termin.getSala().getOznaka(),
                termin.getTrening().getTip(),
                termin.getTrening().getNaziv()
        );
        return new ResponseEntity<>(terminDto, HttpStatus.OK);
    }


}
