package Garaj;

public class Piesa {

    private String nume;
    private int pret;
    private int numarDePiese;

    public Piesa(String nume, int pret, int numarDePiese) {
        this.nume = nume;
        this.pret = pret;
        this.numarDePiese = numarDePiese;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getNumarDePiese() {
        return numarDePiese;
    }

    public void setNumarDePiese(int numarDePiese) {
        this.numarDePiese = numarDePiese;
    }

    @Override
    public String toString() {
        return "Piesa{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", numar_de_piese=" + numarDePiese +
                "}";
    }
}
