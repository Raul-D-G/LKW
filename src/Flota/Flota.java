package Flota;

import Angajati.Sofer;

import java.util.Arrays;

public class Flota {

    private Camion[] camioane;
    private Sofer[] soferi;

    public Flota(Camion[] camioane, Sofer[] soferi) {
        this.camioane = camioane;
        this.soferi = soferi;
    }

    public Flota(Flota flota) {
        this.camioane = flota.camioane;
        this.soferi = flota.soferi;
    }

    public Camion[] getCamioane() {
        return camioane;
    }

    public void setCamioane(Camion[] camioane) {
        this.camioane = camioane;
    }

    public Sofer[] getSoferi() {
        return soferi;
    }

    public void setSoferi(Sofer[] soferi) {
        this.soferi = soferi;
    }

    @Override
    public String toString() {
        return "Flota{" +
                "camioane=" + Arrays.toString(camioane) +
                ", soferi=" + Arrays.toString(soferi) +
                '}';
    }
}
