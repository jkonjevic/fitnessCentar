package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.*;
import com.example.fitnessCentar.entities.dto.FitnesCentarDto;
import com.example.fitnessCentar.entities.dto.SalaDto;
import com.example.fitnessCentar.entities.dto.TerminDto;
import com.example.fitnessCentar.entities.dto.TreningDto;
import com.example.fitnessCentar.services.KorisnikService;
import com.example.fitnessCentar.services.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/termini", produces = MediaType.APPLICATION_JSON_VALUE)
public class TerminController {

    @Autowired
    private TerminService terminService;
    @Autowired
    private KorisnikService korisnikService;

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
    @GetMapping( value="/getAllSale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Sala>> getAllSalaCentar(@RequestParam Long id){   //id Trenera koji je ulogovan iz LocalStorage-a

        Korisnik korisnik = new Korisnik();                                     //temp Korisnik
        korisnik = korisnikService.findOneById(id);                             //Dobaviti Objekat Korisnik sa datim Id-jem Trenera
        FitnesCentar fitnesCentar = new FitnesCentar();                         //temp FitnesCentar
        fitnesCentar = korisnik.getFitnesCentar();                              //Dobaviti fitnesCentar kom pripada korisnik(trener)
        Set<Sala> listaSala = new HashSet<>();                               //Temp Set Sala
       listaSala = fitnesCentar.getListaSala();                              //dobaviti Set sala iz datog Fitnes Centra

        for(Sala sala: listaSala)
        {
            System.out.println(sala.getOznaka());   //ispis
        }
        return new ResponseEntity<>(listaSala, HttpStatus.OK);              //Vracam dati Set Sala u ResponeEntity
    }



}
