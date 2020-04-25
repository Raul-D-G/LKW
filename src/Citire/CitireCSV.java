package Citire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitireCSV {

    static private CitireCSV csv = null;
    static public List<String> id;
    static public List<String> taraIncarcare;
    static public List<String> orasIncarcare;
    static public List<String> taraDescarcare;
    static public List<String> orasDescarcare;
    static public List<String> km;
    static public List<String> pret;

    private CitireCSV() {
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

    static public synchronized CitireCSV getCsv() {
        if(csv == null)
            csv = new CitireCSV();
        return csv;
    }

}
