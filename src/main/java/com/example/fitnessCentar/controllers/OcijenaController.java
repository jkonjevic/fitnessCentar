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
@RequestMapping(value = "/api")
public class OcijenaController {

    @Autowired
    private OcijenaService ocijenaService;

  @GetMapping(value ="/korisnikOcijene", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OcijenaDto>> getAllOcijena(OcijenaDto ocijenaDto){
        List<Ocijena> listaOcijena = ocijenaService.findAll();
        List<OcijenaDto> listaOcijenaDto = new ArrayList<>();

        for(Ocijena ocijena: listaOcijena){
            String tempKorisnickoime = ocijena.getKorisnik().getKorisnickoIme();
            System.out.println(ocijena.getTermin().getTrening().getTrener().getPrezime());
            if(tempKorisnickoime == ocijenaDto.getKorisnickoIme()){

                OcijenaDto newOcijenaDto = new OcijenaDto(
                        ocijena.getTermin().getPocetak(),
                        ocijena.getTermin().getTrening().getNaziv(),
                        ocijena.getKorisnik().getKorisnickoIme(),
                        ocijena.getOcijena(),
                        ocijena.getTermin().getTrening().getTrener().getIme(),
                        ocijena.getTermin().getTrening().getTrener().getPrezime(),
                        ocijena.getTermin().getTrening().getTip()
                );
            }
            listaOcijenaDto.add(ocijenaDto);
        }
        return new ResponseEntity<>(listaOcijenaDto, HttpStatus.OK);
    }

}
