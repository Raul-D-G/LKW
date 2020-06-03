package Flota;

public class Camion {

    private int id;
    private String numarImatriculare;
    private String marca;
    private boolean disponibil;
    private double consumPeKm;

    public Camion(int id, String numarImatriculare, String marca, boolean disponibil, double consumPeKm) {
        this.id = id;
        this.numarImatriculare = numarImatriculare;
        this.marca = marca;
        this.disponibil = disponibil;
        this.consumPeKm = consumPeKm;
    }

    public String getNumarImatriculare() {
        return numarImatriculare;
    }

    public void setNumarImatriculare(String numarImatriculare) {
        this.numarImatriculare = numarImatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "numar_imatriculare='" + numarImatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", disponibil=" + disponibil +
                '}';
    }

    public double getConsumPeKm() {
        return consumPeKm;
    }
}
