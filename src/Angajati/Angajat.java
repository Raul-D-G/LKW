package Angajati;

public abstract class Angajat {

    private int id;
    private String functie;
    private String nume;
    private int vechime;
    private boolean disponibil;
    private static int numarAngajati = 0;

    public Angajat(int id, String functie, String nume, int vechime, boolean disponibil) {
        this.id = id;
        this.functie = functie;
        this.nume = nume;
        this.vechime = vechime;
        this.disponibil = disponibil;
        ++numarAngajati;
    }

    protected void concediere() {
        --numarAngajati;
        System.out.println("Angajatul " + nume + " a fost concediat");
    }

    public static int nrAngajati() {
        return numarAngajati;
    }

    public abstract double calculSalariu();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public int getVechime() {
        return vechime;
    }

    public String getFunctie() {
        return functie;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", vechime=" + vechime +
                ", disponibil=" + disponibil +
                ',';
    }
}