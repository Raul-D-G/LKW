package Servicii.Citire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitireCurseCSV {

    static private CitireCurseCSV csv = null;
    static private List<String> id;
    static private List<String> taraIncarcare;
    static private List<String> orasIncarcare;
    static private List<String> taraDescarcare;
    static private List<String> orasDescarcare;
    static private List<String> km;
    static private List<String> pret;

    private CitireCurseCSV() {
        String linie;
        String cvsSplitBy = ",";
        String numeFisier = "src/MyCSV/Curse.csv";
        id = new ArrayList<>();
        taraIncarcare = new ArrayList<>();
        orasIncarcare = new ArrayList<>();
        taraDescarcare = new ArrayList<>();
        orasDescarcare = new ArrayList<>();
        km = new ArrayList<>();
        pret = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            while ((linie = br.readLine()) != null) {
                String[] cuvinte = linie.split(cvsSplitBy);

                id.add(cuvinte[0]); taraIncarcare.add(cuvinte[1]); orasIncarcare.add(cuvinte[2]);
                taraDescarcare.add(cuvinte[3]); orasDescarcare.add(cuvinte[4]);
                km.add(cuvinte[5]); pret.add(cuvinte[6]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public synchronized CitireCurseCSV getCsv() {
        if(csv == null)
            csv = new CitireCurseCSV();
        return csv;
    }

    public static List<String> getId() {
        return id;
    }

    public static List<String> getTaraIncarcare() {
        return taraIncarcare;
    }

    public static List<String> getOrasIncarcare() {
        return orasIncarcare;
    }

    public static List<String> getTaraDescarcare() {
        return taraDescarcare;
    }

    public static List<String> getOrasDescarcare() {
        return orasDescarcare;
    }

    public static List<String> getKm() {
        return km;
    }

    public static List<String> getPret() {
        return pret;
    }


}
