package com.example.fitnessCentar.repositories;

import com.example.fitnessCentar.entities.FitnesCentar;
import com.example.fitnessCentar.entities.Ocijena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcijenaRepository extends JpaRepository<Ocijena,Long> {
}
