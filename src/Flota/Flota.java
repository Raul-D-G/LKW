package Flota;

import Angajati.Sofer;

import java.util.Arrays;
import java.util.List;

public class Flota {

    private List<Camion> camioane;
    private List<Sofer> soferi;

    public Flota(List<Camion> camioane, List<Sofer> soferi) {
        this.camioane = camioane;
        this.soferi = soferi;
    }

    public Flota(Flota flota) {
        this.camioane = flota.camioane;
        this.soferi = flota.soferi;
    }

    public List<Camion> getCamioane() {
        return camioane;
    }

    public List<Sofer> getSoferi() {
        return soferi;
    }

    public void adaugaCamion(Camion camion) {
        camioane.add(camion);
    }

    public void adaugaSofer(Sofer sofer) {
        soferi.add(sofer);
    }

    @Override
    public String toString() {
        return "Flota{\n" +
                "camioane=" + Arrays.toString(camioane.toArray()) +
                "\nsoferi=" + Arrays.toString(soferi.toArray()) +
                '}';
    }
}
