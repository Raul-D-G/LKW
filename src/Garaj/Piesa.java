package Garaj;

import javafx.beans.property.*;

public class Piesa {

    private final IntegerProperty id;
    private final StringProperty nume;
    private final DoubleProperty pret;
    private final IntegerProperty numarDePiese;

    public Piesa(int id, String nume, double pret, int numarDePiese) {
        this.id = new SimpleIntegerProperty(id);
        this.nume = new SimpleStringProperty(nume);
        this.pret = new SimpleDoubleProperty(pret);
        this.numarDePiese = new SimpleIntegerProperty(numarDePiese);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    public double getPret() {
        return pret.get();
    }

    public DoubleProperty pretProperty() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret.set(pret);
    }

    public int getNumarDePiese() {
        return numarDePiese.get();
    }

    public IntegerProperty numarDePieseProperty() {
        return numarDePiese;
    }

    public void setNumarDePiese(int numarDePiese) {
        this.numarDePiese.set(numarDePiese);
    }

    @Override
    public String toString() {
        return "Piesa{" +
                "nume='" + getNume() + '\'' +
                ", pret=" + getPret() +
                ", numar_de_piese=" + getNumarDePiese() +
                "}";
    }
}
