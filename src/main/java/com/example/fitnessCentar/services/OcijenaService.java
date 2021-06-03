package com.example.fitnessCentar.services;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Ocijena;
import com.example.fitnessCentar.repositories.FitnesCentarRepository;
import com.example.fitnessCentar.repositories.OcijenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcijenaService {

    @Autowired
    private OcijenaRepository ocijenaRepository;


    public List<Ocijena> findAll() {
        return ocijenaRepository.findAll();
    }


    public Optional<Ocijena> findOne(Long id){
        return ocijenaRepository.findById(id);
    }

  /*  public int findAllById(Long id){
        List<Ocijena> ocijene = this.ocijenaRepository.findAllById(id);
        if(ocijene.isEmpty())
            return -1;
        for (Ocijena ocijena: ocijene)
              { return ocijena.getKorisnik();

        }
    }*/

    public Ocijena addOcijena(Ocijena o1){
        return ocijenaRepository.save(o1);
    }
    public Ocijena updateOcijena(Ocijena o1){
        return ocijenaRepository.save(o1);
    }

    public void delete(Long id){
        ocijenaRepository.deleteById(id);
    }
}
