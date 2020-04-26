package Ruta;

import org.jetbrains.annotations.NotNull;

public class Cursa {

    private int id;
    private String tara_incarcare;
    private String oras_incarcare;
    private String tara_descarcare;
    private String oras_descarcare;
    private int km;
    private int pret;

    public Cursa(int id, String tara_incarcare, String oras_incarcare, String tara_descarcare, String oras_descarcare, int km, int pret) {
        this.id = id;
        this.tara_incarcare = tara_incarcare;
        this.oras_incarcare = oras_incarcare;
        this.tara_descarcare = tara_descarcare;
        this.oras_descarcare = oras_descarcare;
        this.km = km;
        this.pret = pret;
    }

    public Cursa(@NotNull Cursa cursa) {
        this.id = cursa.id;
        this.tara_incarcare = cursa.tara_incarcare;
        this.oras_incarcare = cursa.oras_incarcare;
        this.tara_descarcare = cursa.tara_descarcare;
        this.oras_descarcare = cursa.oras_descarcare;
        this.pret = cursa.pret;
        this.km = cursa.km;
    }

    public int getId() {
        return id;
    }

    public String getTara_incarcare() {
        return tara_incarcare;
    }

    public void setTara_incarcare(String tara_incarcare) {
        this.tara_incarcare = tara_incarcare;
    }

    public String getOras_incarcare() {
        return oras_incarcare;
    }

    public void setOras_incarcare(String oras_incarcare) {
        this.oras_incarcare = oras_incarcare;
    }

    public String getTara_descarcare() {
        return tara_descarcare;
    }

    public void setTara_descarcare(String tara_descarcare) {
        this.tara_descarcare = tara_descarcare;
    }

    public String getOras_descarcare() {
        return oras_descarcare;
    }

    public void setOras_descarcare(String oras_descarcare) {
        this.oras_descarcare = oras_descarcare;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", tara_incarcare='" + tara_incarcare + '\'' +
                ", oras_incarcare='" + oras_incarcare + '\'' +
                ", tara_descarcare='" + tara_descarcare + '\'' +
                ", oras_descarcare='" + oras_descarcare + '\'' +
                ", " + km +" de km" +
                ", pret= " + pret + " euro" +
                '}';
    }
}
