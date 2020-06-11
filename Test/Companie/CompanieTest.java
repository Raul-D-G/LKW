package Companie;

import Angajati.Angajat;
import Angajati.Mecanic;
import Angajati.Sofer;
import Flota.Flota;
import Garaj.Garaj;
import Garaj.Piesa;
import Flota.Camion;
import Ruta.Ruta;
import Ruta.Cursa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanieTest {

    List<Cursa> curse = new ArrayList<Cursa>();
    List<Piesa> piese = new ArrayList<Piesa>();
    List<Mecanic> mecaici = new ArrayList<Mecanic>();
    List<Camion> camioane = new ArrayList<Camion>();
    List<Sofer> soferi = new ArrayList<Sofer>();
    List<Ruta> rute = new ArrayList<Ruta>();
    List<Angajat> angajati = new ArrayList<>();

    Garaj garaj = new Garaj(piese, mecaici);
    Flota flota = new Flota(camioane, soferi);
    Ruta ruta = new Ruta("Romania", "Grecia", curse);

    Companie companie = new Companie("Iurom", "Romania", "12312a","RO11", garaj, rute, angajati, flota);



    @Test
    void getNume() {
        assertEquals("Iurom", companie.getNume());
    }

    @Test
    void getAdresa() {
        assertEquals("Romania", companie.getAdresa());
    }

    @Test
    void getCui() {
        assertEquals("12312a", companie.getCui());
    }

    @Test
    void getIBAN() {
        assertEquals("RO11", companie.getIBAN());
    }

    @Test
    void getGaraj() {
        assertEquals(garaj, companie.getGaraj());
    }

    @Test
    void getRute() {
        assertEquals(rute, companie.getRute());
    }

    @Test
    void getAngajati() {
        assertEquals(angajati, companie.getAngajati());
    }

    @Test
    void getFlota() {
        assertEquals(flota, companie.getFlota());
    }

}