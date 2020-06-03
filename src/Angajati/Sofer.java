package Angajati;

public class Sofer extends Angajat {

    private double salariuSofer;


    public Sofer(int id, String functie, String nume, int vechime, boolean disponibil, double salariu) {
        super(id, functie, nume, vechime, disponibil);
        this.salariuSofer = salariu;
    }

    public double getSalariuSofer() {
        return salariuSofer;
    }

    public void setSalariuSofer(double salariuSofer) {
        this.salariuSofer = salariuSofer;
    }

    @Override
    public double calculSalariu() {
        double salariu_nou =   salariuSofer + getVechime() * 5.5;
        setSalariuSofer(salariu_nou);
        return salariu_nou;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu sofer=" + salariuSofer + "}";
    }
}