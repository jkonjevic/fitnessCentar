package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Termin;
import com.example.fitnessCentar.entities.dto.FitnesCentarDto;
import com.example.fitnessCentar.entities.dto.TerminDto;
import com.example.fitnessCentar.entities.tipTreninga;
import com.example.fitnessCentar.services.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
            termin.getTrening().getNaziv(),
            termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping(value="/pretraga", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> getAllTerminDtoCijena(@RequestParam double cijena){
        System.out.println(cijena);
        List<Termin> t1 = terminService.findByCijenaDo(cijena);
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }


    @GetMapping(value="/pretragaVrijeme", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> getAllTerminDtoPocetak(@RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd") Date pocetak){
        System.out.println(pocetak);
        List<Termin> t1 = terminService.findByVrijemeOd(pocetak);
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping(value="/naziv", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> getAllTerminDtoNaziv(@RequestParam String naziv){
        System.out.println(naziv);
        List<Termin> t1 = terminService.findByNaziv(naziv);
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping(value="/tip", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> getAllTerminDtoTip(@RequestParam tipTreninga tip){
        System.out.println(tip);
        List<Termin> t1 = terminService.findAllbyTipTreninga(tip);
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping(value="/opis", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> getAllTerminDtoTip(@RequestParam String opis){
        System.out.println(opis);
        List<Termin> t1 = terminService.findByOpis(opis);
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }


    @GetMapping(value="/rastuceVrijeme", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> sortVrijeme(){
        List<Termin> t1 = terminService.sortVrijeme();
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping(value="/opadajuceVrijeme", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> sortVrijemeDesc(){
        List<Termin> t1 = terminService.sortVrijemeDesc();
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }


    @GetMapping(value="/rastuceCijena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> sortCijena(){
        List<Termin> t1 = terminService.sortCijena();
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping(value="/opadajuceCijena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> sortCijenaDesc(){
        List<Termin> t1 = terminService.sortCijenaDesc();
        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: t1) {
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping( value="/none", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> getAllTerminiNone(){
        List<Termin> listaTermina = terminService.findAll();
        List<TerminDto> listaTerminaDto = new ArrayList<>();

        for(Termin termin: listaTermina){
            TerminDto terminDto = new TerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis()
            );
            listaTerminaDto.add(terminDto);
        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }



}
