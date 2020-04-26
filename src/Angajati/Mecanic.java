package Angajati;

public class Mecanic extends Angajat {

    private int salariuMecanic;

    public Mecanic(String functie, String nume, int vechime, boolean disponibil, int salariuMecanic) {
        super(functie, nume, vechime, disponibil);
        this.salariuMecanic = salariuMecanic;
    }

    public int getSalariuMecanic() {
        return salariuMecanic;
    }

    public void setSalariuMecanic(int salariuMecanic) {
        this.salariuMecanic = salariuMecanic;
    }

    @Override
    public int calculSalariu() {
        int salariu_nou =  salariuMecanic + getVechime() * 10;
        setSalariuMecanic(salariu_nou);
        return salariu_nou;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu mecanic=" + salariuMecanic + "}";
    }
}
