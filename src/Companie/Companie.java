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

    public Ruta afisareRute() {
        for (Ruta ruta : rute) {
            System.out.println(ruta.getTaraIncarcare() + " -> " + ruta.getTaraDescarcare());
        }
        System.out.println("Selectati ruta dorita.");
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        while (!validInput) {
            try {

                String linie = scanner.nextLine();
                String[] tari = linie.split(" ");
                for (Ruta ruta : rute) {
                    if (ruta.getTaraIncarcare().equalsIgnoreCase(tari[0]) && ruta.getTaraDescarcare().equalsIgnoreCase(tari[1])) {
                        validInput = true;
                        System.out.println("Ruta a fost selectata!");
                        return ruta;
                    }
                }

                throw new InputMismatchException("ruta gresita");
            }
            catch (InputMismatchException e) {
                System.out.println("Ruta nu exista !");
            }
        }
        return null;
    }


    //    Afiseaza toate camioanele disponibile si returneaza camionul
//    selectat dupa nr de imatriculare.
    public Camion cautaCamionDisponibil() {
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
        System.out.println("\nIntroduceti numarul de imatriculare:\n");
        Scanner scanner = new Scanner(System.in);

//        return selectCamion(camion);
        boolean validInput = false;

        while (!validInput) {
            try {

                String camion1 = scanner.nextLine();

                Camion camion = selectCamion(camion1);

                if (camion == null)
                    throw new InputMismatchException("Numarul nu exista!");
                else {
                    validInput = true;
                    System.out.println("Camionul a fost selectat!");
                    return camion;
                }
            } catch (InputMismatchException e) {
                System.out.println("Numarul nu exista!");
            }
        }
        return null;
    }



    //    Calculeaza cheltuielile din garaj + salariul soferilor
    public int cheltuieliGarajplusSoferi() {
        int cheltuieli = 0;
        cheltuieli += garaj.cheltuieliGaraj();
        cheltuieli += flota.celtuieliSoferi();
        return cheltuieli;
    }


    //    Returneaza camionul selectat
    protected Camion selectCamion(String nr) {
        for (Camion camion : flota.getCamioane()) {
            if (camion.getNumarImatriculare().equalsIgnoreCase(nr))
                return camion;
        }
        return null;
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