package com.example.fitnessCentar.repositories;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Sala;
import com.example.fitnessCentar.entities.Trening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TreningRepository extends JpaRepository<Trening, Long> {


}
