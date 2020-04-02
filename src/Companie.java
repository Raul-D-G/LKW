public class Companie {

    private String nume;
    private String adresa;
    private int cui;
    private int IBAN;

    private Garaj garaj;
    private Ruta rute[];
    private Flota flota;


    public Companie(String nume, String adresa, int cui, int IBAN) {
        this.nume = nume;
        this.adresa = adresa;
        this.cui = cui;
        this.IBAN = IBAN;
    }

}
