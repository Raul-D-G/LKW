package Ruta;

import java.util.List;

public class Ruta {

    private String taraIncarcare;
    private String taraDescarcare;
    private List<Cursa> curse;

    public Ruta(String taraIncarcare, String taraDescarcare, List<Cursa> curse) {
        this.taraIncarcare = taraIncarcare;
        this.taraDescarcare = taraDescarcare;
        this.curse = curse;
    }

    public List<Cursa> getCurse() {
        return curse;
    }

    public String getTaraIncarcare() {
        return taraIncarcare;
    }

    public String getTaraDescarcare() {
        return taraDescarcare;
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
