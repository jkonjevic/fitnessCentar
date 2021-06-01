package com.example.fitnessCentar.services;

import com.example.fitnessCentar.entities.Trening;
import com.example.fitnessCentar.repositories.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreningService {
    @Autowired
    private TreningRepository treningRepository;


    public List<Trening> findAll() {
        return treningRepository.findAll();
    }


    public Optional<Trening> findOne(Long id){
        return treningRepository.findById(id);
    }


    public Trening addTrening(Trening t1){
        return treningRepository.save(t1);
    }
    public Trening updateTrening(Trening t1){
        return treningRepository.save(t1);
    }

    public void delete(Long id){
        treningRepository.deleteById(id);
    }
}
