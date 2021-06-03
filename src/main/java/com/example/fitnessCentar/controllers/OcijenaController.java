package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.Korisnik;
import com.example.fitnessCentar.entities.Ocijena;
import com.example.fitnessCentar.entities.Termin;
import com.example.fitnessCentar.entities.dto.FitnesCentarDto;
import com.example.fitnessCentar.entities.dto.KorisnikDto;
import com.example.fitnessCentar.entities.dto.OcijenaDto;
import com.example.fitnessCentar.entities.dto.TerminDto;
import com.example.fitnessCentar.services.OcijenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/Ocijena")
public class OcijenaController {

    @Autowired
    private OcijenaService ocijenaService;

 /* @GetMapping(value ="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OcijenaDto>> getAllOcijena(){
        List<Ocijena> listaOcijena = ocijenaService.findAll();
        List<OcijenaDto> listaOcijenaDto = new ArrayList<>();



        for(Ocijena ocijena: listaOcijena){
            KorisnikDto korisnikDto = new KorisnikDto(ocijena.getKorisnik().getId(),ocijena.getKorisnik().getKorisnickoIme(),ocijena.getKorisnik().getPrezime(),ocijena.getKorisnik().getLozinka(),ocijena.getKorisnik().getIme(),ocijena.getKorisnik().getKontakt(), ocijena.getKorisnik().getEmail(),ocijena.getKorisnik().getDatum(),ocijena.getKorisnik().getUloga(),ocijena.getKorisnik().isAktivan());
            TerminDto terminDto = new TerminDto(ocijena.getTermin().getId(),ocijena.getTermin().getPocetak(),ocijena.getTermin().getCijena(),ocijena.getTermin().getBrPrijavljenih(), ocijena.getTermin().getSala(), ocijena.getTermin().getTrening());
            OcijenaDto ocijenaDto = new OcijenaDto(
                    ocijena.getId(),
                    korisnikDto,
                    terminDto,
                    ocijena.getOcijena()
            );
            listaOcijenaDto.add(ocijenaDto);
        }

        return new ResponseEntity<>(listaOcijenaDto, HttpStatus.OK);
    }*/

}
