package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Korisnik;
import com.example.fitnessCentar.entities.Uloga;
import com.example.fitnessCentar.entities.dto.*;
import com.example.fitnessCentar.services.FitnesCentarService;
import com.example.fitnessCentar.services.KorisnikService;
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
@RequestMapping(value = "/api")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private FitnesCentarService fitnesCentarService;

    @GetMapping(value = "/korisnici/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDto> getKorisnik(@PathVariable Long id) {
        Optional<Korisnik> k1 = korisnikService.findOne(id);
        if (!k1.isPresent()) {

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
    public ResponseEntity<KorisnikDto> registration(@RequestBody KorisnikDto k1) {
        Korisnik korisnik = korisnikService.registracija(k1);
        k1.setId(korisnik.getId());
        return new ResponseEntity<>(k1, HttpStatus.CREATED);
    }

    @PostMapping(value = "/coachregistration", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDto> coachRegistration(@RequestBody TrenerDto k1) {
        Korisnik korisnik = korisnikService.coachRegistracija(k1);
        k1.setId(korisnik.getId());
        k1.setAktivan(true);
        return new ResponseEntity<>(k1, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDto> login(@RequestBody prijavaDto k1) {
        Korisnik korisnik = korisnikService.prijava(k1);
        if (korisnik == null) {
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

    @GetMapping(value = "/treneri", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDto>> getAllTrener() {
        List<Korisnik> listaKorisnika = korisnikService.findAll();
        List<KorisnikDto> listaKorisnikDto = new ArrayList<>();

        for (Korisnik korisnik : listaKorisnika) {
            if (korisnik.getUloga() == Uloga.TRENER && korisnik.isAktivan() == false) {
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

                listaKorisnikDto.add(korisnikDto);
            }
        }

        return new ResponseEntity<>(listaKorisnikDto, HttpStatus.OK);
    }

    @GetMapping(value = "/korisnici", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDto>> getAllKorisnik() {
        List<Korisnik> listaKorisnika = korisnikService.findAll();
        List<KorisnikDto> listaKorisnikDto = new ArrayList<>();

        for (Korisnik korisnik : listaKorisnika) {
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

            listaKorisnikDto.add(korisnikDto);
        }


        return new ResponseEntity<>(listaKorisnikDto, HttpStatus.OK);
    }

    //UPDATE NE RADI, radi ipak
    @PutMapping(value = "/updateKorisnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDto> putKorisnik(@PathVariable Long id, @Validated @RequestBody KorisnikDto k1) {
        Optional<Korisnik> k2 = korisnikService.findOne(id);
        if (!k2.isPresent()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Korisnik korisnik = new Korisnik(
                k2.get().getId(), //pitati VELJA
                k1.getKorisnickoIme(),
                k1.getPrezime(),
                k1.getLozinka(),
                k1.getIme(),
                k1.getKontakt(),
                k1.getEmail(),
                k1.getDatum(),
                k1.getUloga(),
                k1.isAktivan()
        );
        korisnik = korisnikService.updateKorisnik(korisnik);
        k1.setId(id);
        return new ResponseEntity<>(k1, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/addKorisnik", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDto> postFitnesCentar(@Validated @RequestBody KorisnikDto k1) {

        Korisnik korisnik = new Korisnik(
                null,
                k1.getKorisnickoIme(),
                k1.getPrezime(),
                k1.getLozinka(),
                k1.getIme(),
                k1.getKontakt(),
                k1.getEmail(),
                k1.getDatum(),
                k1.getUloga(),
                k1.isAktivan()

        );
        korisnik = korisnikService.addKorisnik(korisnik);
        k1.setId(korisnik.getId());
        return new ResponseEntity<>(k1, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteKorisnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteKorisnik(@PathVariable Long id) {
        korisnikService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

  /*  @GetMapping(value ="/korisnici/{id}/Ocijena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OcijenaDto> getOcijena(@PathVariable Long id){
        Optional<Korisnik> k1 = korisnikService.findOne(id);
        if(!k1.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Korisnik korisnik = k1.get();
        OcijenaDto ocijenaDto = new OcijenaDto(
                korisnik.getKorisnickoIme(),
                korisnik.getKorisnikOcjene()

        );
        return new ResponseEntity<>(ocijenaDto, HttpStatus.OK);
    }*/

    @PutMapping(value = "/odobriTrenera", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> odobriTrenera(@RequestBody List<Long> ids) {
        System.out.println(ids.toString());
        for(Long id: ids){
            Optional<Korisnik> k = korisnikService.findOne(id);
            if(k.isPresent()){
                k.get().setAktivan(true);
                korisnikService.updateKorisnik(k.get());
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
// IMA JOS DA SE PISE
