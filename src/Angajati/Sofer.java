package Angajati;

public class Sofer extends Angajat {

    private int salariu_sofer;


    public Sofer(String nume, int vechime, boolean disponibil, int salariu) {
        super(nume, vechime, disponibil);
        this.salariu_sofer = salariu;
    }

    public int getSalariu_sofer() {
        return salariu_sofer;
    }

    public void setSalariu_sofer(int salariu_sofer) {
        this.salariu_sofer = salariu_sofer;
    }

    @Override
    public int calculSalariu() {
        int salariu_nou =  (int) (salariu_sofer + getVechime() * 5.5);
        setSalariu_sofer(salariu_nou);
        return salariu_nou;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu_sofer=" + salariu_sofer + "}";
    }
}
