package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Sala;
import com.example.fitnessCentar.entities.dto.FitnesCentarDto;
import com.example.fitnessCentar.entities.dto.SalaDto;
import com.example.fitnessCentar.services.FitnesCentarService;
import com.example.fitnessCentar.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/Sale", produces = MediaType.APPLICATION_JSON_VALUE)
public class SalaController {
    @Autowired
    private SalaService salaService;

    @GetMapping(value ="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDto>> getAllSala(){
        List<Sala> listaSala = salaService.findAll();
        List<SalaDto> listaSalaDto = new ArrayList<>();

        for(Sala sala: listaSala){
            SalaDto salaDto = new SalaDto(
                    sala.getId(),
                    sala.getKapacitet(),
                    sala.getOznaka()
            );
            listaSalaDto.add(salaDto);
        }

        return new ResponseEntity<>(listaSalaDto, HttpStatus.OK);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDto> getSala(@PathVariable Long id){
        Optional<Sala> s1 = salaService.findOne(id);
        if(!s1.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Sala sala = s1.get();
        SalaDto salaDto = new SalaDto(
                sala.getId(),
                sala.getKapacitet(),
                sala.getOznaka()
        );
        return new ResponseEntity<>(salaDto, HttpStatus.OK);
    }

    @PostMapping(value="/addSala", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDto> postSala(@Validated @RequestBody SalaDto s1){

        Sala sala = new Sala(
                null,
                s1.getKapacitet(),
                s1.getOznaka()
        );
        sala = salaService.addSala(sala);
        s1.setId(sala.getId());
        return new ResponseEntity<>(s1, HttpStatus.CREATED);
    }

    @PutMapping(value="/updateSala/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDto> putSala(@PathVariable Long id, @Validated @RequestBody SalaDto s1){
        Optional<Sala> s2 = salaService.findOne(id);
        if(!s2.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Sala sala = new Sala(
                s2.get().getId(),
                s1.getKapacitet(),
                s1.getOznaka()
        );
        sala = salaService.updateSala(sala);
        s1.setId(id);
        return new ResponseEntity<>(s1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/deleteSala/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSala(@PathVariable Long id){
        salaService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
