package Angajati;

public class Sofer extends Angajat {

    private int salariuSofer;


    public Sofer(String functie, String nume, int vechime, boolean disponibil, int salariu) {
        super(functie, nume, vechime, disponibil);
        this.salariuSofer = salariu;
    }

    public int getSalariuSofer() {
        return salariuSofer;
    }

    public void setSalariuSofer(int salariuSofer) {
        this.salariuSofer = salariuSofer;
    }

    @Override
    public int calculSalariu() {
        int salariu_nou =  (int) (salariuSofer + getVechime() * 5.5);
        setSalariuSofer(salariu_nou);
        return salariu_nou;
    }

    @Override
    public String toString() {
        return super.toString() +  " salariu sofer=" + salariuSofer + "}";
    }
}
