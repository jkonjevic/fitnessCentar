package com.example.fitnessCentar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    //postavljanje poziva za localhost
    @GetMapping()
    public String home(){
        return "homePage.html";
    }

    @GetMapping(value="/login")
    public String login(){
        return "login.html";
    }
    @GetMapping(value="/registration")
    public String registration(){
        return "registracija.html";
    }

    @GetMapping(value="/coachingRequest")
    public String adminAccept(){
        return "admin_accept.html";
    }

    @GetMapping(value="/sviTreninzi")
    public String sviTreninzi(){
        return "sviTreninzi.html";
    }

    @GetMapping(value="/sviCentri")
    public String sviCentri(){
        return "sviFitnesCentri.html";
    }

    @GetMapping(value="/addFitnesCentar")
    public String addCentar(){
        return "addFitnesCentar.html";
    }
    @GetMapping(value="/addTrening")
    public String addTrening(){
        return "addTrening.html";
    }

    @GetMapping(value="/sviTermini")
    public String sviTermini(){
        return "sviTermini.html";
    }

    @GetMapping(value="/adminHomePage")
    public String adminPage(){
        return "adminHomePage.html";
    }

    @GetMapping(value="/updateFitnesCentar")
    public String updateFitnesCentar(){
        return "updateFitnesCentar.html";
    }

    @GetMapping(value="/deleteFitnesCentar")
    public String deleteFitnesCentar(){
        return "deleteFitnesCentar.html";
    }

    @GetMapping(value="/addTrener")
    public String addTrener(){
        return "addTrener.html";
    }


    @GetMapping(value="/deleteKorisnik")
    public String deleteKorisnik(){
        return "deleteKorisnik.html";
    }

    @GetMapping(value="/addSala")
    public String addSala(){
        return "addSala.html";
    }

    @GetMapping(value="/updateSala")
    public String updateSala(){
        return "updateSala.html";
    }

    @GetMapping(value="/deleteSala")
    public String deleteSala(){
        return "deleteSala.html";
    }

    @GetMapping(value="/trenerHomePage")
    public String trenerHomePage(){
        return "trenerHomePage.html";
    }


    @GetMapping(value="/addTermin")
    public String addTermin(){
        return "addTermin.html";
    }


    @GetMapping(value="/mojiTermini")
    public String korisnikTermin(){
        return "korisnikTermin.html";
    }

    @GetMapping(value="/mojProfil")
    public String mojProfil(){
        return "prikazKorisnika.html";
    }

    @GetMapping(value="/mojiTreninzi")
    public String mojiTreninzi(){
        return "mojiTreninzi.html";
    }

    @GetMapping(value="/OcijenjeniTreninzi")
    public String mojiOcijenjeniTreninzi(){
        return "OcijenjeniTreninzi.html";
    }
    
}
