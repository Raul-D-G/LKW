package Ruta;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class Ruta {

    private final StringProperty taraIncarcare;
    private final StringProperty taraDescarcare;
    private List<Cursa> curse;

    public Ruta(String taraIncarcare, String taraDescarcare, List<Cursa> curse) {
        this.taraIncarcare = new SimpleStringProperty(taraIncarcare);
        this.taraDescarcare = new SimpleStringProperty(taraDescarcare);
        this.curse = curse;
    }

    public List<Cursa> getCurse() {
        return curse;
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

    public String getTaraDescarcare() {
        return taraDescarcare.get();
    }

    public StringProperty taraDescarcareProperty() {
        return taraDescarcare;
    }

    public void setTaraDescarcare(String taraDescarcare) {
        this.taraDescarcare.set(taraDescarcare);
    }

    public void adaugaCursa(Cursa cursa) {
        curse.add(cursa);
    }

    public void stergeCursa(Cursa cursa) {
        curse.remove(cursa);
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "tara_incarcare='" + taraIncarcare + '\'' +
                ", tara_descarcare='" + taraDescarcare + "' \n" +
                "curse=" + curse+
                "}\n";
    }
}