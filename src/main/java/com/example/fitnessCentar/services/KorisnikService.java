package com.example.fitnessCentar.services;
import com.example.fitnessCentar.entities.Korisnik;
import com.example.fitnessCentar.entities.Uloga;
import com.example.fitnessCentar.entities.dto.KorisnikDto;
import com.example.fitnessCentar.entities.dto.TrenerDto;
import com.example.fitnessCentar.entities.dto.prijavaDto;
import com.example.fitnessCentar.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private FitnesCentarService fitnesCentarService;
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }


    public Optional<Korisnik> findOne(Long id){
        return korisnikRepository.findById(id);
    }

    public Korisnik findOneById(Long id){return korisnikRepository.findOneById(id);}


    public Korisnik addKorisnik(Korisnik k1){
        return korisnikRepository.save(k1);
    }
    public Korisnik updateKorisnik(Korisnik k1){
        return korisnikRepository.save(k1);
    }

    public void delete(Long id){
        korisnikRepository.deleteById(id);
    }   //logika za registraciju
    public Korisnik registracija(KorisnikDto k1){
        if(k1.getUloga()==Uloga.CLAN){
            k1.setAktivan(true);
        }
        else if(k1.getUloga() == Uloga.TRENER){
            k1.setAktivan(false);
        }
        Korisnik korisnik = new Korisnik(
                k1.getId(),
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
        korisnikRepository.save(korisnik);
        return korisnik;
    }

    public Korisnik coachRegistracija(TrenerDto k1){
        Korisnik korisnik = new Korisnik(
                k1.getId(),
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
        korisnik.setFitnesCentar(fitnesCentarService.findOneById(k1.getIdFitnesCentra()));
        korisnikRepository.save(korisnik);
        return korisnik;
    }
    public Korisnik prijava(prijavaDto prijava){
        Korisnik korisnik = korisnikRepository.findKorisnikByKorisnickoIme(prijava.getKorisnickoIme());
        if(korisnik==null || !korisnik.getLozinka().equals(prijava.getLozinka()) || korisnik.isAktivan()==false){
            return null;
        }
        return korisnik;

    }

}
