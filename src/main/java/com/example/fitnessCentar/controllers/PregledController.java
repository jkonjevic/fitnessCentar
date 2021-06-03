package com.example.fitnessCentar.controllers;

import com.example.fitnessCentar.services.KorisnikService;
import com.example.fitnessCentar.services.TerminService;
import com.example.fitnessCentar.services.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pregled", produces = MediaType.APPLICATION_JSON_VALUE)
public class PregledController {

    @Autowired
    private TreningService treningService;
    private KorisnikService korisnikService;
    private TerminService terminService;



}
