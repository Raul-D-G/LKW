package Servicii.Citire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitireAngajatiCSV {

    static private CitireAngajatiCSV csv = null;
    static private List<String> functie;
    static private List<String> nume;
    static private List<String> vechime;
    static private List<String> disponibil;
    static private List<String> salariu;

    private CitireAngajatiCSV() {
        String linie;
        String cvsSplitBy = ",";
        String numeFisier = "src/MyCSV/Angajati.csv";
        functie = new ArrayList<>();
        nume = new ArrayList<>();
        vechime = new ArrayList<>();
        disponibil = new ArrayList<>();
        salariu = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            while ((linie = br.readLine()) != null) {
                String[] cuvinte = linie.split(cvsSplitBy);

                functie.add(cuvinte[0]); nume.add(cuvinte[1]); vechime.add(cuvinte[2]);
                disponibil.add(cuvinte[3]); salariu.add(cuvinte[4]);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public synchronized CitireAngajatiCSV getCsv() {
        if(csv == null)
            csv = new CitireAngajatiCSV();
        return csv;
    }

    public static List<String> getFunctie() {
        return functie;
    }

    public static List<String> getNume() {
        return nume;
    }

    public static List<String> getVechime() {
        return vechime;
    }

    public static List<String> getDisponibil() {
        return disponibil;
    }

    public static List<String> getSalariu() {
        return salariu;
    }
}
