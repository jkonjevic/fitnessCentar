package com.example.fitnessCentar.repositories;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Ocijena;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcijenaRepository extends JpaRepository<Ocijena,Long> {

    List<Ocijena> findAllById(Long id);
}
