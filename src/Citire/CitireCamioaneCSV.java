package Citire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitireCamioaneCSV {
    static private CitireCamioaneCSV csv = null;
    static private List<String> numarImatriculare;
    static private List<String> marca;
    static private List<String> disponibil;
    static private List<String> consum;


    private CitireCamioaneCSV() {
        String linie;
        String cvsSplitBy = ",";
        String numeFisier = "src/MyCSV/Camioane.csv";
        numarImatriculare = new ArrayList<>();
        marca = new ArrayList<>();
        disponibil = new ArrayList<>();
        consum = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            while ((linie = br.readLine()) != null) {
                String[] cuvinte = linie.split(cvsSplitBy);

                numarImatriculare.add(cuvinte[0]); marca.add(cuvinte[1]); disponibil.add(cuvinte[2]);
                consum.add(cuvinte[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public synchronized CitireCamioaneCSV getCsv() {
        if(csv == null)
            csv = new CitireCamioaneCSV();
        return csv;
    }

    public static List<String> getNumarImatriculare() {
        return numarImatriculare;
    }

    public static List<String> getMarca() {
        return marca;
    }

    public static List<String> getDisponibil() {
        return disponibil;
    }

    public static List<String> getConsum() {
        return consum;
    }
}
