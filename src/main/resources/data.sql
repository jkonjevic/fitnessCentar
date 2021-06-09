INSERT INTO FITNES_CENTAR (ADRESA, BR_CENTRALE, EMAIL, NAZIV) values ('Milosa Crnjanskog 8', '0638162900', 'fitnes@gmail.com', 'JocoBidza');
INSERT INTO SALA(KAPACITET, OZNAKA, FITNES_CENTAR_ID) values (20, 1, 1);
INSERT INTO SALA(KAPACITET, OZNAKA, FITNES_CENTAR_ID) values (15, 2, 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM, EMAIL, IME, KONTAKT, KORISNICKO_IME, LOZINKA, ULOGA,FITNES_CENTAR_ID, PREZIME) values (true, '2011-11-02 19:00:00.000000', 'joco@gmail.com', 'Jovan', '06312521512', 'CogunBratenga', 'omfg2124','ADMINISTRATOR',1,'konjevic');
INSERT INTO KORISNIK(AKTIVAN, DATUM, EMAIL, IME, KONTAKT, KORISNICKO_IME, LOZINKA, ULOGA,FITNES_CENTAR_ID, PREZIME) values (true, '2019-02-01 00:00:00.000000', 'web@gmail.com','Marko', '063222222', 'marecare', 'omfg2124', 'CLAN',1, 'suberic');
INSERT INTO KORISNIK(AKTIVAN, DATUM, EMAIL, IME, KONTAKT, KORISNICKO_IME, LOZINKA, ULOGA,FITNES_CENTAR_ID, PREZIME) values (true, '2021-02-03 12:00:00.000000', 'database@gmail.com' , 'Neno', '0631499392', 'Nenokiller', 'neno1234', 'CLAN',1, 'tusup');
INSERT INTO KORISNIK(AKTIVAN, DATUM, EMAIL, IME, KONTAKT, KORISNICKO_IME, LOZINKA, ULOGA,FITNES_CENTAR_ID, PREZIME) values (false, '2000-03-08 19:00:00.000000', 'milorad@gmail.com' , 'MiloradKrusica', '069963334', 'Milorad', 'saimaburaz', 'TRENER',1, 'lazovic');
INSERT INTO TRENING(NAZIV, OPIS, TIP, TRAJANJE, TRENER_ID) values ('kros', 'nijelos','GLADIATOR', 1, 4);
INSERT INTO TRENING(NAZIV, OPIS, TIP, TRAJANJE, TRENER_ID) values ('gym', 'nijelos', 'CROSSFIT', 1,4);
INSERT INTO TERMIN(CIJENA, POCETAK, SALA_ID, TRENING_ID, BR_PRIJAVLJENIH) values (12, '2021-01-01 16:00:00.000000', 2,2,5);
INSERT INTO TERMIN(CIJENA, POCETAK, SALA_ID, TRENING_ID, BR_PRIJAVLJENIH) values (7, '2021-02-02 15:00:00.000000', 1,1,3);
INSERT INTO TERMIN(CIJENA, POCETAK, SALA_ID, TRENING_ID, BR_PRIJAVLJENIH) values (5, '2021-03-03 16:00:00.000000', 2,2,12);
INSERT INTO TERMIN(CIJENA, POCETAK, SALA_ID, TRENING_ID, BR_PRIJAVLJENIH) values (10, '2021-04-04 15:00:00.000000', 1,1,10);
INSERT INTO OCIJENA(OCIJENA, KORISNIK_ID, TERMIN_ID) values ( 9, 3, 4);
INSERT INTO OCIJENA(OCIJENA, KORISNIK_ID, TERMIN_ID) values ( 10, 1, 1);
INSERT INTO OCIJENA(OCIJENA, KORISNIK_ID, TERMIN_ID) values ( 9, 2, 4);
INSERT INTO OCIJENA(OCIJENA, KORISNIK_ID, TERMIN_ID) values ( 9, 3, 3);
INSERT INTO PRIJAVLJENI(KORISNIK_ID, TERMIN_ID) values (1,1);