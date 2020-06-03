package Ruta;

import javafx.beans.property.*;
import org.jetbrains.annotations.NotNull;

public class Cursa {

    private final IntegerProperty id;
    private final StringProperty taraIncarcare;
    private final StringProperty orasIncarcare;
    private final StringProperty taraDescarcare;
    private final StringProperty orasDescarcare;
    private final IntegerProperty km;
    private final DoubleProperty pret;

    public Cursa(int id, String taraIncarcare, String orasIncarcare, String taraDescarcare, String orasDescarcare, int km, double pret) {
        this.id = new SimpleIntegerProperty(id);
        this.taraIncarcare = new SimpleStringProperty(taraIncarcare);
        this.orasIncarcare = new SimpleStringProperty(orasIncarcare);
        this.taraDescarcare = new SimpleStringProperty(taraDescarcare);
        this.orasDescarcare = new SimpleStringProperty(orasDescarcare);
        this.km = new SimpleIntegerProperty(km);
        this.pret = new SimpleDoubleProperty(pret);
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
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getTaraIncarcare() {
        return taraIncarcare.get();
    }

    public StringProperty taraIncarcareProperty() {
        return taraIncarcare;
    }

    public void setTaraIncarcare(String taraIncarcare) {
        this.taraIncarcare.set(taraIncarcare);
    }

    public String getOrasIncarcare() {
        return orasIncarcare.get();
    }

    public StringProperty orasIncarcareProperty() {
        return orasIncarcare;
    }

    public void setOrasIncarcare(String orasIncarcare) {
        this.orasIncarcare.set(orasIncarcare);
    }

    public String getTaraDescarcare() {
        return taraDescarcare.get();
    }

    public StringProperty taraDescarcareProperty() {
        return taraDescarcare;
    }

    public void setTaraDescarcare(String taraDescarcare) {
        this.taraDescarcare.set(taraDescarcare);
    }

    public String getOrasDescarcare() {
        return orasDescarcare.get();
    }

    public StringProperty orasDescarcareProperty() {
        return orasDescarcare;
    }

    public void setOrasDescarcare(String orasDescarcare) {
        this.orasDescarcare.set(orasDescarcare);
    }

    public int getKm() {
        return km.get();
    }

    public IntegerProperty kmProperty() {
        return km;
    }

    public void setKm(int km) {
        this.km.set(km);
    }

    public double getPret() {
        return pret.get();
    }

    public DoubleProperty pretProperty() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret.set(pret);
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