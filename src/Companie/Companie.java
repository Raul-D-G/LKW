package Companie;

import Angajati.Angajat;
import Flota.Flota;
import Garaj.Garaj;
import Ruta.Ruta;
import Flota.Camion;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Companie {

    private String nume;
    private String adresa;
    private String cui;
    private String IBAN;

    private Garaj garaj;
    private List<Ruta> rute;
    private List<Angajat> angajati;
    private Flota flota;


    public Companie(String nume, String adresa, String cui, String IBAN, Garaj garaj, List<Ruta> rute, List<Angajat> angajati, Flota flota) {
        this.nume = nume;
        this.adresa = adresa;
        this.cui = cui;
        this.IBAN = IBAN;
        this.garaj = new Garaj(garaj);
        this.rute = rute;
        this.angajati = angajati;
        this.flota = new Flota(flota);
    }



    public void adaugaRuta(Ruta ruta) {
        rute.add(ruta);
    }

    public void adaugaAngajat(Angajat angajat) {angajati.add(angajat); }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getCui() {
        return cui;
    }

    public String getIBAN() {
        return IBAN;
    }

    public Garaj getGaraj() {
        return garaj;
    }

    public List<Ruta> getRute() {
        return rute;
    }

    public List<Angajat> getAngajati() {
        return angajati;
    }

    public Flota getFlota() {
        return flota;
    }


    @Override
    public String toString() {
        return "Companie.Companie{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", cui=" + cui +
                ", IBAN=" + IBAN +
                ",\n" + garaj +
                ",\nRute{\n" + rute +
                ",\n" + flota +
                '}';
    }
}