package Ruta;

import org.jetbrains.annotations.NotNull;

public class Cursa {

    private int id;
    private String taraIncarcare;
    private String orasIncarcare;
    private String taraDescarcare;
    private String orasDescarcare;
    private int km;
    private double pret;

    public Cursa(int id, String taraIncarcare, String orasIncarcare, String taraDescarcare, String orasDescarcare, int km, double pret) {
        this.id = id;
        this.taraIncarcare = taraIncarcare;
        this.orasIncarcare = orasIncarcare;
        this.taraDescarcare = taraDescarcare;
        this.orasDescarcare = orasDescarcare;
        this.km = km;
        this.pret = pret;
    }

    public Cursa(@NotNull Cursa cursa) {
        this.id = cursa.id;
        this.taraIncarcare = cursa.taraIncarcare;
        this.orasIncarcare = cursa.orasIncarcare;
        this.taraDescarcare = cursa.taraDescarcare;
        this.orasDescarcare = cursa.orasDescarcare;
        this.pret = cursa.pret;
        this.km = cursa.km;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaraIncarcare() {
        return taraIncarcare;
    }

    public void setTaraIncarcare(String taraIncarcare) {
        this.taraIncarcare = taraIncarcare;
    }

    public String getOrasIncarcare() {
        return orasIncarcare;
    }

    public void setOrasIncarcare(String orasIncarcare) {
        this.orasIncarcare = orasIncarcare;
    }

    public String getTaraDescarcare() {
        return taraDescarcare;
    }

    public void setTaraDescarcare(String taraDescarcare) {
        this.taraDescarcare = taraDescarcare;
    }

    public String getOrasDescarcare() {
        return orasDescarcare;
    }

    public void setOrasDescarcare(String orasDescarcare) {
        this.orasDescarcare = orasDescarcare;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", tara_incarcare='" + taraIncarcare + '\'' +
                ", oras_incarcare='" + orasIncarcare + '\'' +
                ", tara_descarcare='" + taraDescarcare + '\'' +
                ", oras_descarcare='" + orasDescarcare + '\'' +
                ", " + km +" de km" +
                ", pret= " + pret + " euro" +
                '}';
    }
}