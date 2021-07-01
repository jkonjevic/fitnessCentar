package com.example.fitnessCentar.repositories;

import com.example.fitnessCentar.entities.FitnesCentar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnesCentarRepository extends JpaRepository<FitnesCentar,Long> {

   public FitnesCentar findByNaziv(Long id);

   public FitnesCentar findOneById(Long id);
}
