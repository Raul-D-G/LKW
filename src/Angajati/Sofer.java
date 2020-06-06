package Angajati;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Sofer extends Angajat {

    private final DoubleProperty salariuSofer;


    public Sofer(int id, String functie, String nume, int vechime, boolean disponibil, double salariu) {
        super(id, functie, nume, vechime, disponibil);
        this.salariuSofer = new SimpleDoubleProperty(salariu);
    }

    public double getSalariuSofer() {
        return salariuSofer.get();
    }

    public DoubleProperty salariuSoferProperty() {
        return salariuSofer;
    }

    public void setSalariuSofer(double salariuSofer) {
        this.salariuSofer.set(salariuSofer);
    }

    @Override
    public double calculSalariu() {
        double salariu_nou =   getSalariuSofer() + getVechime() * 5.5;
        setSalariuSofer(salariu_nou);
        return salariu_nou;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu sofer=" + getSalariuSofer() + "}";
    }
}