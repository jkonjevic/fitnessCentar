package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Korisnik;
import com.example.fitnessCentar.entities.dto.FitnesCentarDto;
import com.example.fitnessCentar.entities.dto.KorisnikDto;
import com.example.fitnessCentar.entities.dto.prijavaDto;
import com.example.fitnessCentar.services.FitnesCentarService;
import com.example.fitnessCentar.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(value ="/korisnici/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDto> getKorisnik(@PathVariable Long id){
        Optional<Korisnik> k1 = korisnikService.findOne(id);
        if(!k1.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Korisnik korisnik = k1.get();
        KorisnikDto korisnikDto = new KorisnikDto(
                korisnik.getId(),
                korisnik.getKorisnickoIme(),
                korisnik.getPrezime(),
                korisnik.getLozinka(),
                korisnik.getIme(),
                korisnik.getKontakt(),
                korisnik.getEmail(),
                korisnik.getDatum(),
                korisnik.getUloga(),
                korisnik.isAktivan()
        );
        return new ResponseEntity<>(korisnikDto, HttpStatus.OK);
    }

        @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<KorisnikDto> registration(@RequestBody KorisnikDto k1){
            Korisnik korisnik = korisnikService.registracija(k1);
            k1.setId(korisnik.getId());
            return new ResponseEntity<>(k1, HttpStatus.CREATED);
        }

        @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<KorisnikDto> login(@RequestBody prijavaDto k1){
            Korisnik korisnik = korisnikService.prijava(k1);
            if(korisnik==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            KorisnikDto korisnikDto = new KorisnikDto(
                    korisnik.getId(),
                    korisnik.getKorisnickoIme(),
                    korisnik.getPrezime(),
                    korisnik.getLozinka(),
                    korisnik.getIme(),
                    korisnik.getKontakt(),
                    korisnik.getEmail(),
                    korisnik.getDatum(),
                    korisnik.getUloga(),
                    korisnik.isAktivan()
            );
            return new ResponseEntity<>(korisnikDto, HttpStatus.CREATED);
        }
}

// IMA JOS DA SE PISE
