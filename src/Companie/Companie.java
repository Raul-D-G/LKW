package Companie;

import Angajati.Angajat;
import Flota.Flota;
import Garaj.Garaj;
import Ruta.Ruta;
import Ruta.Cursa;
import Flota.Camion;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class Companie {

    private String nume;
    private String adresa;
    private int cui;
    private int IBAN;

    private Garaj garaj;
    private List<Ruta> rute;
    private List<Angajat> angajati;
    private Flota flota;


    public Companie(String nume, String adresa, int cui, int IBAN, Garaj garaj, List<Ruta> rute, List<Angajat> angajati, Flota flota) {
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

//    Calculeaza cheltuielile din garaj + salariul soferilor
    public int cheltuieliGarajplusSoferi() {
        int cheltuieli = 0;
        cheltuieli += garaj.cheltuieliGaraj();
        cheltuieli += flota.celtuieliSoferi();
        return cheltuieli;
    }

//    Afiseaza cursele disponibile pentru o ruta
    public void cautaCurse(@NotNull Ruta ruta) {
        int ok = 0;
        for (Cursa cursa : ruta.getCurse()) {
            ok = 1;
            System.out.println(cursa);
        }
        if (ok == 0) {
            System.out.println("Nu sunt curse disponibile!\n");
        }
    }

//    Afiseaza toate camioanele disponibile
    public void cautaCamionDisponibil() {
        int ok = 0;
        for(Camion camion : flota.getCamioane()) {
            if (camion.isDisponibil()) {
                ok = 1;
                System.out.println(camion);
            }
        }
        if (ok == 0) {
            System.out.println("Nu sunt camione disponibile");
        }
    }

//    Returneaza cursa selectata
    public Cursa selectCursa(@NotNull Ruta ruta, int id) {
        for (Cursa cursa : ruta.getCurse()) {
            if (cursa.getId() == id)
                return cursa;
        }
        return null;
    }

//    Returneaza camionul selectat
    public Camion selectCamion(String nr) {
        for (Camion camion : flota.getCamioane()) {
            if (camion.getNumarImatriculare().equals(nr))
                return camion;
        }
        return null;
    }

//    Accepta cursa, sterge cursa selectata si seteaza camionul ca fiind indisponibil
//    returneaza profitul asociat cursei (scazand din pretul cursei consumul camionului * nr km)
    public double acceptaCursa(@NotNull Ruta ruta, @NotNull Cursa cursa, @NotNull Camion camion) {
        camion.setDisponibil(false);
        double cheltuieli = camion.getConsumPeKm() * cursa.getKm();
        double castig;
        castig = cursa.getPret();

        ruta.stergeCursa(cursa);

        return castig - cheltuieli;
    }

    @Override
    public String toString() {
        return "Companie.Companie{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", cui=" + cui +
                ", IBAN=" + IBAN +
                ",\n" + garaj +
                ",\nRute{\n" + Arrays.toString(rute.toArray()) +
                ",\n" + flota +
                '}';
    }
}
