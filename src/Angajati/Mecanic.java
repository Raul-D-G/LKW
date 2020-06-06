package Angajati;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Mecanic extends Angajat {

    private final DoubleProperty salariuMecanic;

    public Mecanic(int id, String functie, String nume, int vechime, boolean disponibil, double salariuMecanic) {
        super(id, functie, nume, vechime, disponibil);
        this.salariuMecanic = new SimpleDoubleProperty(salariuMecanic);
    }

    public double getSalariuMecanic() {
        return salariuMecanic.get();
    }

    public DoubleProperty salariuMecanicProperty() {
        return salariuMecanic;
    }

    public void setSalariuMecanic(double salariuMecanic) {
        this.salariuMecanic.set(salariuMecanic);
    }

    @Override
    public double calculSalariu() {
        double salariu_nou =  getSalariuMecanic() + getVechime() * 10;
        setSalariuMecanic(salariu_nou);
        return salariu_nou;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu mecanic=" + getSalariuMecanic() + "}";
    }
}