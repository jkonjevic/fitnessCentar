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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/trening", produces = MediaType.APPLICATION_JSON_VALUE)
public class TreningController {
    @Autowired
    private TreningService treningService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDto> getTrening(@PathVariable Long id){
        Optional<Trening> t1 = treningService.findOne(id);
        if(!t1.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Trening trening = t1.get();
        TreningDto treningDto = new TreningDto(
                trening.getId(),
                trening.getNaziv(),
                trening.getOpis(),
                trening.getTip(),
                trening.getTrajanje()
        );
        return new ResponseEntity<>(treningDto, HttpStatus.OK);
    }
    @PostMapping(value ="/addTrening", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDto> postTrening(@Validated @RequestBody TreningDto t1){

        Trening trening = new Trening(
                null,
                t1.getNaziv(),
                t1.getOpis(),
                t1.getTip(),
                t1.getTrajanje()
        );
        trening = treningService.addTrening(trening);
        t1.setId(trening.getId());
        return new ResponseEntity<>(t1, HttpStatus.CREATED);
    }

    @PutMapping(value="/updateTrening/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDto> putTrening(@PathVariable Long id, @Validated @RequestBody TreningDto t1){
        Optional<Trening> t2 = treningService.findOne(id);
        if(!t2.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Trening trening = new Trening(
                t2.get().getId(),
                t1.getNaziv(),
                t1.getOpis(),
                t1.getTip(),
                t1.getTrajanje()
        );
        trening = treningService.updateTrening(trening);
        t1.setId(id);
        return new ResponseEntity<>(t1, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value="/deleteTrening/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTrening(@PathVariable Long id){
        treningService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
