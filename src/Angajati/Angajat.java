package Angajati;

public abstract class Angajat {

    private String nume;
    private int vechime;
    private boolean disponibil;
    private static int numar_angajati = 0;

    public Angajat(String nume, int vechime, boolean disponibil) {
        this.nume = nume;
        this.vechime = vechime;
        this.disponibil = disponibil;
        ++numar_angajati;
    }

    protected void concediere() {
        --numar_angajati;
        System.out.println("Angajatul " + nume + " a fost concediat");
    }

    public abstract int calculSalariu();

    public String getNume() {
        return nume;
    }

    public int getVechime() {
        return vechime;
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
