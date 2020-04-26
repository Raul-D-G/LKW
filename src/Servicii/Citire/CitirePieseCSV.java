package Servicii.Citire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitirePieseCSV {
    static private CitirePieseCSV csv = null;
    static private List<String> denumirePiesa;
    static private List<String> pretPiesa;
    static private List<String> cantitateDisponibila;

    private CitirePieseCSV() {
        String linie;
        String cvsSplitBy = ",";
        String numeFisier = "src/MyCSV/Piese.csv";
        denumirePiesa = new ArrayList<>();
        pretPiesa = new ArrayList<>();
        cantitateDisponibila = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            while ((linie = br.readLine()) != null) {
                String[] cuvinte = linie.split(cvsSplitBy);

                denumirePiesa.add(cuvinte[0]); pretPiesa.add(cuvinte[1]); cantitateDisponibila.add(cuvinte[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public synchronized CitirePieseCSV getCsv() {
        if(csv == null)
            csv = new CitirePieseCSV();
        return csv;
    }

    public static List<String> getDenumirePiesa() {
        return denumirePiesa;
    }

    public static List<String> getPretPiesa() {
        return pretPiesa;
    }

    public static List<String> getCantitateDisponibila() {
        return cantitateDisponibila;
    }
}
