package com.example.fitnessCentar.controllers;
import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.dto.FitnesCentarDto;
import com.example.fitnessCentar.services.FitnesCentarService;
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
@RequestMapping(value = "/api/fitnesCentar")
public class FitnesCentarController {


    @Autowired
    private FitnesCentarService fitnesCentarService;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentarDto>> getAllFitnesCentar(){
        List<FitnesCentar> listaCentara = fitnesCentarService.findAll();
        List<FitnesCentarDto> listaCentaraDto = new ArrayList<>();

        for(FitnesCentar centar: listaCentara){
            FitnesCentarDto centarDto = new FitnesCentarDto(
                    centar.getId(),
                    centar.getNaziv(),
                    centar.getAdresa(),
                    centar.getBrCentrale(),
                    centar.getEmail()
            );
            listaCentaraDto.add(centarDto);
        }

        return new ResponseEntity<>(listaCentaraDto, HttpStatus.OK);
    }
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDto> getFitnesCentar(@PathVariable Long id){
        Optional<FitnesCentar> f1 = fitnesCentarService.findOne(id);
        if(!f1.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FitnesCentar centar = f1.get();
        FitnesCentarDto centarDto = new FitnesCentarDto(
                centar.getId(),
                centar.getNaziv(),
                centar.getAdresa(),
                centar.getBrCentrale(),
                centar.getEmail()
        );
        return new ResponseEntity<>(centarDto, HttpStatus.OK);
    }
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDto> postFitnesCentar(@Validated @RequestBody FitnesCentarDto f1){

        FitnesCentar centar = new FitnesCentar(
                null,
                f1.getNaziv(),
                f1.getAdresa(),
                f1.getBrCentrale(),
                f1.getEmail()
        );
        centar = fitnesCentarService.addFitnesCentar(centar);
        f1.setId(centar.getId());
        return new ResponseEntity<>(f1, HttpStatus.CREATED);
    }

    @PutMapping(value="/updateFitnesCentar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDto> putFitnesCentar(@PathVariable Long id, @Validated @RequestBody FitnesCentarDto f1){
        Optional<FitnesCentar> f2 = fitnesCentarService.findOne(id);
        if(!f2.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FitnesCentar centar = new FitnesCentar(
                f2.get().getId(),
                f1.getNaziv(),
                f1.getAdresa(),
                f1.getBrCentrale(),
                f1.getEmail()
        );
        centar = fitnesCentarService.updateFitnesCentar(centar);
        f1.setId(id);
        return new ResponseEntity<>(f1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFitnesCentar(@PathVariable Long id){
        fitnesCentarService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }



}
