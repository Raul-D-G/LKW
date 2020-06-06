package Flota;

import javafx.beans.property.*;

public class Camion {

    private final IntegerProperty id;
    private final StringProperty numarImatriculare;
    private final StringProperty marca;
    private final BooleanProperty disponibil;
    private final DoubleProperty consumPeKm;

    public Camion(int id, String numarImatriculare, String marca, boolean disponibil, double consumPeKm) {
        this.id = new SimpleIntegerProperty(id);
        this.numarImatriculare = new SimpleStringProperty(numarImatriculare);
        this.marca = new SimpleStringProperty(marca);
        this.disponibil = new SimpleBooleanProperty(disponibil);
        this.consumPeKm = new SimpleDoubleProperty(consumPeKm);
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

    public String getNumarImatriculare() {
        return numarImatriculare.get();
    }

    public StringProperty numarImatriculareProperty() {
        return numarImatriculare;
    }

    public void setNumarImatriculare(String numarImatriculare) {
        this.numarImatriculare.set(numarImatriculare);
    }

    public String getMarca() {
        return marca.get();
    }

    public StringProperty marcaProperty() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
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

    public DoubleProperty consumPeKmProperty() {
        return consumPeKm;
    }

    public void setConsumPeKm(double consumPeKm) {
        this.consumPeKm.set(consumPeKm);
    }

    public double getConsumPeKm() {
        return consumPeKm.get();
    }

    @Override
    public String toString() {
        return "Camion{" +
                "numar_imatriculare='" + getNumarImatriculare() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", disponibil=" + isDisponibil() +
                '}';
    }

}
