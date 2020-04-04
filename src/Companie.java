import Flota.Flota;
import Garaj.Garaj;
import Ruta.Ruta;

import java.util.Arrays;
import java.util.List;

public class Companie {

    private String nume;
    private String adresa;
    private int cui;
    private int IBAN;

    private Garaj garaj;
    private List<Ruta> rute;
    private Flota flota;


    public Companie(String nume, String adresa, int cui, int IBAN, Garaj garaj, List<Ruta> rute, Flota flota) {
        this.nume = nume;
        this.adresa = adresa;
        this.cui = cui;
        this.IBAN = IBAN;
        this.garaj = new Garaj(garaj);
        this.rute = rute;
        this.flota = new Flota(flota);
    }

    public void adaugaRuta(Ruta ruta) {
        rute.add(ruta);
    }


    @Override
    public String toString() {
        return "Companie{" +
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
