package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.entities.*;
import com.example.fitnessCentar.entities.dto.*;
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

    @GetMapping(value ="/korisnikTermini/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TerminDto>> getKorisnikTermini(@PathVariable Long id){
        Korisnik korisnik = korisnikService.findOneById(id);
        System.out.println(korisnik.getIme());
        Set<Termin> listaTermina = korisnik.getPrijave();
        Set<TerminDto> listaTerminaDto = new HashSet<>();

        for(Termin termin: listaTermina){
            System.out.println(termin.getCijena());
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
    @GetMapping(value = "/getAllOdabraniTermini/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdabranTerminDto> getAllOdabraniTermini(@PathVariable Long id){

        Termin termin = terminService.findOneById(id);
        if(termin==null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

            OdabranTerminDto odabranterminDto = new OdabranTerminDto(
                    termin.getId(),
                    termin.getPocetak(),
                    termin.getCijena(),
                    termin.getSala().getOznaka(),
                    termin.getTrening().getTip(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis(),
                    termin.getSala().getKapacitet()-termin.getBrPrijavljenih()
            );



        return new ResponseEntity<>(odabranterminDto,HttpStatus.OK);
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

    @PostMapping(value = "/prijavaNaTrening/{idKorisnik}/{idTermin}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdabranTerminDto> prijaviTermin(@PathVariable Long idKorisnik, @PathVariable Long idTermin){
        Korisnik korisnik = this.korisnikService.findOneById(idKorisnik);
        Termin termin = this.terminService.findOneById(idTermin);
        System.out.println(termin.getCijena());
        System.out.println(korisnik.getIme());
        if(korisnik == null || termin == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        korisnik.getPrijave().add(termin);
        termin.setBrPrijavljenih(termin.getBrPrijavljenih() + 1);
        this.korisnikService.addKorisnik(korisnik);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/odjavaTrening/{idKorisnik}/{idTermin}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdabranTerminDto> odjavaTermin(@PathVariable Long idKorisnik, @PathVariable Long idTermin){
        Korisnik korisnik = this.korisnikService.findOneById(idKorisnik);
        Termin termin = this.terminService.findOneById(idTermin);
        System.out.println(termin.getCijena());
        System.out.println(korisnik.getIme());
        if(korisnik == null || termin == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        korisnik.getPrijave().remove(termin);
        termin.setBrPrijavljenih(termin.getBrPrijavljenih() - 1);
        this.korisnikService.addKorisnik(korisnik);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value ="/korisnikNeocijenjeniTermini/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TerminDto>> getKorisnikNeocijenjeniTermini(@PathVariable Long id){
        Korisnik korisnik = korisnikService.findOneById(id);
        System.out.println(korisnik.getPrezime());
        Set<Termin> listaTermina = korisnik.getPrijave();
        Set<TerminDto> listaTerminaDto = new HashSet<>();

        for(Termin termin: listaTermina){
            System.out.println(termin.getCijena());
            boolean provjera = false;
            Set<Ocijena> listaOcijena = termin.getOcijene();
            for(Ocijena ocijena: listaOcijena){
                if(ocijena.getKorisnik().getId()==id){
                    provjera = true;
                    break;
                }
            }
            if(provjera == false){
                Date currentDate = new Date();
                if(currentDate.after(termin.getPocetak())){
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
                    break;
                }
            }

        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

    @GetMapping(value ="/korisnikOcijenjeniTermini/{id}", produces = MediaType.APPLICATION_JSON_VALUE)  //OCIJENJENI TERMINI logika
    public ResponseEntity<Set<OdabranTerminDto>> getKorisnikOcijenjeniTermini(@PathVariable Long id){
        Korisnik korisnik = korisnikService.findOneById(id);
        System.out.println(korisnik.getIme());
        Set<Termin> listaTermina = korisnik.getPrijave();
        Set<OdabranTerminDto> listaTerminaDto = new HashSet<>();

        for(Termin termin: listaTermina){
            System.out.println(termin.getCijena());
            Set<Ocijena> listaOcijena = termin.getOcijene();
            for(Ocijena ocijena: listaOcijena){
                if(ocijena.getKorisnik().getId()==id){
                    Date currentDate = new Date();
                    if(currentDate.after(termin.getPocetak())){                                 //provjera datum
                        OdabranTerminDto terminDto = new OdabranTerminDto(
                                termin.getId(),
                                termin.getPocetak(),
                                termin.getCijena(),
                                termin.getSala().getOznaka(),
                                termin.getTrening().getTip(),
                                termin.getTrening().getNaziv(),
                                termin.getTrening().getOpis(),
                                ocijena.getOcijena()
                        );
                        listaTerminaDto.add(terminDto);
                        break;
                    }
                }
            }


        }

        return new ResponseEntity<>(listaTerminaDto, HttpStatus.OK);
    }

}
