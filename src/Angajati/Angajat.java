package Angajati;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Angajat {

    private final StringProperty id;
    private final StringProperty functie;
    private final StringProperty nume;
    private final StringProperty vechime;
    private final StringProperty disponibil;

    public Angajat(String id, String functie, String nume, String vechime, String disponibil) {
        this.id = new SimpleStringProperty(id);
        this.functie = new SimpleStringProperty(functie);
        this.nume = new SimpleStringProperty(nume);
        this.vechime = new SimpleStringProperty(vechime);
        this.disponibil = new SimpleStringProperty(disponibil);
    }




    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", vechime=" + vechime +
                ", disponibil=" + disponibil +
                ',';
    }
}
