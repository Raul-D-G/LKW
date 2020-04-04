package Garaj;

public class Piesa {

    private String nume;
    private int pret;
    private int numar_de_piese;

    public Piesa(String nume, int pret, int numar_de_piese) {
        this.nume = nume;
        this.pret = pret;
        this.numar_de_piese = numar_de_piese;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getNumar_de_piese() {
        return numar_de_piese;
    }

    public void setNumar_de_piese(int numar_de_piese) {
        this.numar_de_piese = numar_de_piese;
    }

    @Override
    public String toString() {
        return "Piesa{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", numar_de_piese=" + numar_de_piese +
                '}';
    }
}
