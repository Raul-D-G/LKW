package Angajati;

public class Mecanic extends Angajat {

    private int salariu_mecanic;

    public Mecanic(String nume, int vechime, boolean disponibil, int salariu_mecanic) {
        super(nume, vechime, disponibil);
        this.salariu_mecanic = salariu_mecanic;
    }

    public int getSalariu_mecanic() {
        return salariu_mecanic;
    }

    public void setSalariu_mecanic(int salariu_mecanic) {
        this.salariu_mecanic = salariu_mecanic;
    }

    @Override
    public int calculSalariu() {
        int salariu_nou =  salariu_mecanic + getVechime() * 10;
        setSalariu_mecanic(salariu_nou);
        return salariu_nou;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu_mecanic=" + salariu_mecanic + "}";
    }
}
