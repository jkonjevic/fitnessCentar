package com.example.fitnessCentar.repositories;

import com.example.fitnessCentar.entities.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminRepository extends JpaRepository<Termin, Long> {
}
