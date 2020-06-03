package Angajati;

public class Mecanic extends Angajat {

    private double salariuMecanic;

    public Mecanic(int id, String functie, String nume, int vechime, boolean disponibil, double salariuMecanic) {
        super(id, functie, nume, vechime, disponibil);
        this.salariuMecanic = salariuMecanic;
    }

    public double getSalariuMecanic() {
        return salariuMecanic;
    }

    public void setSalariuMecanic(double salariuMecanic) {
        this.salariuMecanic = salariuMecanic;
    }

    @Override
    public double calculSalariu() {
        double salariu_nou =  salariuMecanic + getVechime() * 10;
        setSalariuMecanic(salariu_nou);
        return salariu_nou;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu mecanic=" + salariuMecanic + "}";
    }
}