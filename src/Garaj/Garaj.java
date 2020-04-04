package Garaj;

import Angajati.Mecanic;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Garaj {

    private Piesa[] piese;
    private Mecanic[] mecanici;

    public Garaj(Piesa[] piese, Mecanic[] mecanici) {
        this.piese = piese;
        this.mecanici = mecanici;
    }

    public Garaj(@NotNull Garaj garaj) {
        this.piese = garaj.getPiese();
        this.mecanici = garaj.getMecanici();
    }

    public Piesa[] getPiese() {
        return piese;
    }

    public void setPiese(Piesa[] piese) {
        this.piese = piese;
    }

    public Mecanic[] getMecanici() {
        return mecanici;
    }

    public void setMecanici(Mecanic[] mecanici) {
        this.mecanici = mecanici;
    }

    @Override
    public String toString() {
        return "Garaj{" +
                "piese=" + Arrays.toString(piese) +
                ", mecanici=" + Arrays.toString(mecanici) +
                '}';
    }
}
