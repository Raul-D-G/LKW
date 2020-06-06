package Angajati;

import javafx.beans.property.*;

public abstract class Angajat {

    private IntegerProperty id;
    private StringProperty functie;
    private StringProperty nume;
    private IntegerProperty vechime;
    private BooleanProperty disponibil;

    public Angajat(int id, String functie, String nume, int vechime, boolean disponibil) {
        this.id = new SimpleIntegerProperty(id);
        this.functie = new SimpleStringProperty(functie);
        this.nume = new SimpleStringProperty(nume);
        this.vechime = new SimpleIntegerProperty(vechime);
        this.disponibil = new SimpleBooleanProperty(disponibil);
    }



    public abstract double calculSalariu();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFunctie() {
        return functie.get();
    }

    public StringProperty functieProperty() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie.set(functie);
    }

    public String getNume() {
        return nume.get();
    }

    public StringProperty numeProperty() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume.set(nume);
    }

    public int getVechime() {
        return vechime.get();
    }

    public IntegerProperty vechimeProperty() {
        return vechime;
    }

    public void setVechime(int vechime) {
        this.vechime.set(vechime);
    }

    public boolean isDisponibil() {
        return disponibil.get();
    }

    public BooleanProperty disponibilProperty() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil.set(disponibil);
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + getNume() + '\'' +
                ", vechime=" + getVechime() +
                ", disponibil=" + isDisponibil() +
                ',';
    }
}