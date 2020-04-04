package Ruta;

import java.util.Arrays;
import java.util.List;

public class Ruta {

    private String tara_incarcare;
    private String tara_descarcare;
    private List<Cursa> curse;

    public Ruta(String tara_incarcare, String tara_descarcare, List<Cursa> curse) {
        this.tara_incarcare = tara_incarcare;
        this.tara_descarcare = tara_descarcare;
        this.curse = curse;
    }

    public void adaugaCursa(Cursa cursa) {
        curse.add(cursa);
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "tara_incarcare='" + tara_incarcare + '\'' +
                ", tara_descarcare='" + tara_descarcare + "' \n" +
                "curse=" + Arrays.toString(curse.toArray()) +
                "}\n";
    }
}
