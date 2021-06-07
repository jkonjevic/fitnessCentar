package com.example.fitnessCentar.repositories;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findAllByOrderByCijena();

    List<Termin> findAllByOrderByPocetak();

    Optional<Termin> findByCijena(double cijena);

    List<Termin> findByPocetak(String pocetak);

    List<Termin> findAll();






}
