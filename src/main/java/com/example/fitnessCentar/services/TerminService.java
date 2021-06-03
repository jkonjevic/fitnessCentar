package com.example.fitnessCentar.services;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Termin;
import com.example.fitnessCentar.repositories.FitnesCentarRepository;
import com.example.fitnessCentar.repositories.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminService {
    @Autowired
    private TerminRepository terminRepository;


    public List<Termin> findAll() { return terminRepository.findAll(); }


    public Optional<Termin> findOne(Long id){
        return terminRepository.findById(id);
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
