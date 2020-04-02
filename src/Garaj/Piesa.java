package Garaj;

public class Piesa {

    private int pret;
    private int numar_de_piese;

    public Piesa(int pret, int numar_de_piese) {
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
}
