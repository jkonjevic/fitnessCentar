package com.example.fitnessCentar.repositories;
import com.example.fitnessCentar.entities.Termin;
import com.example.fitnessCentar.entities.tipTreninga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findAllByOrderByCijena();

    List<Termin> findAllByOrderByCijenaDesc();

    List<Termin> findAllByOrderByPocetak();

    List<Termin> findAllByOrderByPocetakDesc();

    List<Termin> findAllByTreningContaining(tipTreninga tip);

    List<Termin> findAllByTreningContaining(String opis);


    List<Termin> findAll();

    List<Termin> findAllByTreningNazivContaining(String naziv);

    List<Termin> findAllByTreningTip(tipTreninga tip);

    List<Termin> findAllByTreningOpisContaining(String Opis);

    List<Termin> findAllByCijenaGreaterThan(double cijena);
    List<Termin> findAllByCijenaLessThanEqual(double cijena);

    List<Termin> findAllByPocetakLessThanEqual(Date pocetak);

    List<Termin> findAllByPocetakGreaterThan(Date Pocetak);

    Termin findOneById(Long id);




}
