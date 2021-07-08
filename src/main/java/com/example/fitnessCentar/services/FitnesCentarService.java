package com.example.fitnessCentar.services;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.repositories.FitnesCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FitnesCentarService  {

    @Autowired
    private FitnesCentarRepository fitnesCentarRepository;


    public List<FitnesCentar> findAll() {
        return fitnesCentarRepository.findAll();
    }


   /* public Optional<FitnesCentar> findOne(Long id){
        return fitnesCentarRepository.findById(id);
    } */
    public Optional<FitnesCentar> findOne(Long id){ return fitnesCentarRepository.findById(id);}

    public FitnesCentar findOneById(Long id){ return fitnesCentarRepository.findOneById(id);}   //non Optional opcija


    public FitnesCentar addFitnesCentar(FitnesCentar f1){
        return fitnesCentarRepository.save(f1);
    }
    public FitnesCentar updateFitnesCentar(FitnesCentar f1){
        return fitnesCentarRepository.save(f1);
    }

    public void delete(Long id){
         fitnesCentarRepository.deleteById(id);
    }
}
