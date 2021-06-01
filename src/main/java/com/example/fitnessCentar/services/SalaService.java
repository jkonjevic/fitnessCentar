package com.example.fitnessCentar.services;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Sala;
import com.example.fitnessCentar.repositories.FitnesCentarRepository;
import com.example.fitnessCentar.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;


    public List<Sala> findAll() {
        return salaRepository.findAll();
    }


    public Optional<Sala> findOne(Long id){
        return salaRepository.findById(id);
    }


    public Sala addSala(Sala s1){
        return salaRepository.save(s1);
    }
    public Sala updateSala(Sala s1){
        return salaRepository.save(s1);
    }

    public void delete(Long id){
        salaRepository.deleteById(id);
    }
}
