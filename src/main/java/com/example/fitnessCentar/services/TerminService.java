package com.example.fitnessCentar.services;
import com.example.fitnessCentar.entities.Termin;
import com.example.fitnessCentar.entities.tipTreninga;
import com.example.fitnessCentar.repositories.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TerminService {
    @Autowired
    private TerminRepository terminRepository;


    public List<Termin> sortCijena(){
        List<Termin> sortiraniTermini = this.terminRepository.findAllByOrderByCijena();
        return sortiraniTermini;
    }
    public List<Termin> sortCijenaDesc(){
        List<Termin> sortiraniTermini = this.terminRepository.findAllByOrderByCijenaDesc();
        return sortiraniTermini;
    }


    public List<Termin> sortVrijeme(){
        List<Termin> sortiraniTermini = this.terminRepository.findAllByOrderByPocetak();
        return sortiraniTermini;
    }

    public List<Termin> sortVrijemeDesc(){
        List<Termin> sortiraniTermini = this.terminRepository.findAllByOrderByPocetakDesc();
        return sortiraniTermini;
    }

    public List<Termin> findAll() { return terminRepository.findAll(); }


    public List<Termin> findByCijenaDo(double cijena){
        List<Termin> terminiCijena = this.terminRepository.findAllByCijenaLessThanEqual(cijena);
        return terminiCijena;
    }

    public List<Termin> findByCijenaOd(double cijena){
        List<Termin> terminiCijena = this.terminRepository.findAllByCijenaGreaterThan(cijena);
        return terminiCijena;
    }

    public List<Termin> findByVrijemeDo(Date Pocetak){
        List<Termin> terminiVrijeme = this.terminRepository.findAllByPocetakLessThanEqual(Pocetak);
        return terminiVrijeme;
    }

    public List<Termin> findByVrijemeOd(Date Pocetak){
        List<Termin> terminiVrijeme = this.terminRepository.findAllByPocetakGreaterThan(Pocetak);
        return terminiVrijeme;
    }

    public List<Termin> findAllbyTipTreninga(tipTreninga tip){
        List<Termin> terminiTip = this.terminRepository.findAllByTreningTip(tip);
        return terminiTip;
    }

    public List<Termin> findByNaziv(String naziv){
        List<Termin> terminiNaziv = this.terminRepository.findAllByTreningNazivContaining(naziv);
        return terminiNaziv;
    }

    public List<Termin> findByOpis(String opis){
        List<Termin> terminiOpis = this.terminRepository.findAllByTreningOpisContaining(opis);
        return terminiOpis;
    }


    public Termin addTermin(Termin t1){
        return terminRepository.save(t1);
    }
    public Termin updateTermin(Termin t1){
        return terminRepository.save(t1);
    }

    public void delete(Long id){
        terminRepository.deleteById(id);
    }


}
