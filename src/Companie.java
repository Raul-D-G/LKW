import Flota.Flota;
import Garaj.Garaj;
import Ruta.Ruta;

import java.util.Arrays;

public class Companie {

    private String nume;
    private String adresa;
    private int cui;
    private int IBAN;

    private Garaj garaj;
    private Ruta[] rute;
    private Flota flota;


    public Companie(String nume, String adresa, int cui, int IBAN, Garaj garaj, Ruta[] rute, Flota flota) {
        this.nume = nume;
        this.adresa = adresa;
        this.cui = cui;
        this.IBAN = IBAN;
        this.garaj = new Garaj(garaj);
        this.rute = Arrays.copyOf(rute, rute.length);
        this.flota = new Flota(flota);
    }


    @Override
    public String toString() {
        return "Companie{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", cui=" + cui +
                ", IBAN=" + IBAN +
                ",\n" + garaj +
                ",\n" + Arrays.toString(rute) +
                ",\n" + flota +
                '}';
    }
}
