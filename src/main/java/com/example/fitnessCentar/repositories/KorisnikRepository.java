package com.example.fitnessCentar.repositories;

import com.example.fitnessCentar.entities.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    public Korisnik findKorisnikByKorisnickoIme(String korisnickoIme);
}
