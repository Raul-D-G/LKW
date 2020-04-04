package Flota;

public class Camion {

    private String numar_imatriculare;
    private String marca;
    private boolean disponibil;

    public Camion(String numar_imatriculare, String marca, boolean disponibil) {
        this.numar_imatriculare = numar_imatriculare;
        this.marca = marca;
        this.disponibil = disponibil;
    }

    public String getNumar_imatriculare() {
        return numar_imatriculare;
    }

    public void setNumar_imatriculare(String numar_imatriculare) {
        this.numar_imatriculare = numar_imatriculare;
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
                "numar_imatriculare='" + numar_imatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", disponibil=" + disponibil +
                '}';
    }
}
