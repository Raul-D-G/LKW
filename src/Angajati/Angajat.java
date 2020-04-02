package Angajati;

public class Angajat {

    private String nume;
    private int vechime;
    private int salariu;
    private static int numar_angajati = 0;

    public Angajat(String nume, int vechime, int salariu) {
        this.nume = nume;
        this.vechime = vechime;
        this.salariu = salariu;
        ++numar_angajati;
    }

    protected void concediere() {
        --numar_angajati;
        System.out.println("Angajatul " + nume + " a fost concediat");
    }

    public String getNume() {
        return nume;
    }

    public int getVechime() {
        return vechime;
    }

    public int getSalariu() {
        return salariu;
    }

}
