package Ruta;

import java.util.Arrays;

public class Ruta {

    private String tara_incarcare;
    private String tara_descarcare;
    private Cursa[] curse;

    public Ruta(String tara_incarcare, String tara_descarcare, Cursa[] curse) {
        this.tara_incarcare = tara_incarcare;
        this.tara_descarcare = tara_descarcare;
        this.curse = Arrays.copyOf(curse, curse.length);
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "tara_incarcare='" + tara_incarcare + '\'' +
                ", tara_descarcare='" + tara_descarcare + '\'' +
                ", curse=" + Arrays.toString(curse) +
                '}';
    }
}
