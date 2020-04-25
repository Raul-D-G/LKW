package Garaj;

import Angajati.Mecanic;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class Garaj {

    private List<Piesa> piese ;
    private List<Mecanic> mecanici;
    private int cheltuieliGaraj;

    public Garaj(List<Piesa> piese, List<Mecanic> mecanici, int cheltuieliGaraj) {
        this.piese = piese;
        this.mecanici = mecanici;
        this.cheltuieliGaraj = cheltuieliGaraj;
    }

    public Garaj(@NotNull Garaj garaj) {
        this.piese = garaj.piese;
        this.mecanici = garaj.mecanici;
        this.cheltuieliGaraj = garaj.cheltuieliGaraj;
    }

    public List<Piesa> getPiese() {
        return piese;
    }

    public void adaugaPiesa(Piesa piesa) {
        piese.add(piesa);
    }

    public List<Mecanic> getMecanici() {
        return mecanici;
    }

    public void adaugaMecanic(Mecanic mecanic) {
        mecanici.add(mecanic);
    }

    public int cheltuieliGaraj() {
        int cheltuieli = 0;
        for (Mecanic mecanic: mecanici) {
            mecanic.calculSalariu();
            cheltuieli += mecanic.getSalariuMecanic();
        }
        for (Piesa piesa : piese) {
            cheltuieli += piesa.getPret();
        }
        return cheltuieli;
    }

    @Override
    public String toString() {
        return "Garaj{\n" +
                "piese=" + Arrays.toString(piese.toArray()) +
                ",\nmecanici=" + Arrays.toString(mecanici.toArray()) +
                '}';
    }
}
