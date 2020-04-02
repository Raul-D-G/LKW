import Flota.Flota;
import Garaj.Garaj;
import Ruta.Ruta;

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
        this.garaj = garaj;
        this.rute = rute;
        this.flota = flota;
    }

}
