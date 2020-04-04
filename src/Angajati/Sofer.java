package Angajati;

public class Sofer extends Angajat {

    private int salariu_sofer;


    public Sofer(String nume, int vechime, boolean disponibil, int salariu) {
        super(nume, vechime, disponibil);
        this.salariu_sofer = salariu;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu_sofer=" + salariu_sofer + "}";
    }
}
