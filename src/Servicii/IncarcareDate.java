package Servicii;

import Angajati.Angajat;
import Angajati.Mecanic;
import Angajati.Sofer;
import Citire.CitireAngajatiCSV;
import Citire.CitireCamioaneCSV;
import Citire.CitireCurseCSV;
import Citire.CitirePieseCSV;
import Companie.Companie;
import Flota.Camion;
import Flota.Flota;
import Garaj.Garaj;
import Garaj.Piesa;
import Ruta.Ruta;
import Ruta.Cursa;


import java.util.ArrayList;
import java.util.List;

public class IncarcareDate {

    public static Companie incarcareDate() {
        CitireAngajatiCSV angajatiCSV = CitireAngajatiCSV.getCsv();
        CitireCamioaneCSV camioaneCSV = CitireCamioaneCSV.getCsv();
        CitireCurseCSV curseCSV = CitireCurseCSV.getCsv();
        CitirePieseCSV pieseCSV = CitirePieseCSV.getCsv();

        List<Angajat> angajati = new ArrayList<>();
        List<Sofer> soferi = new ArrayList<>();
        List<Mecanic> mecanici = new ArrayList<>();
        List<Piesa> piese = new ArrayList<>();
        List<Camion> camioane = new ArrayList<>();
        List<Ruta> rute = new ArrayList<Ruta>();

        for(int i = 0; i < CitireAngajatiCSV.getFunctie().size(); i++) {
            if(CitireAngajatiCSV.getFunctie().get(i).equals("Sofer")) {
                Sofer soferNou = new Sofer("Sofer", CitireAngajatiCSV.getNume().get(i),
                        Integer.parseInt(CitireAngajatiCSV.getVechime().get(i)), Boolean.parseBoolean(CitireAngajatiCSV.getDisponibil().get(i)),
                        Integer.parseInt(CitireAngajatiCSV.getSalariu().get(i)));
                soferi.add(soferNou);
            }
            else {
                Mecanic mecanicNou = new Mecanic("Mecanic", CitireAngajatiCSV.getNume().get(i),
                        Integer.parseInt(CitireAngajatiCSV.getVechime().get(i)), Boolean.parseBoolean(CitireAngajatiCSV.getDisponibil().get(i)),
                        Integer.parseInt(CitireAngajatiCSV.getSalariu().get(i)));
                mecanici.add(mecanicNou);
            }
        }


        angajati.addAll(soferi); angajati.addAll(mecanici);


        for (int i = 0; i < CitireCamioaneCSV.getNumarImatriculare().size(); i++) {
            Camion camionNou = new Camion(CitireCamioaneCSV.getNumarImatriculare().get(i), CitireCamioaneCSV.getMarca().get(i),
                    Boolean.parseBoolean(CitireCamioaneCSV.getDisponibil().get(i)), Double.parseDouble(CitireCamioaneCSV.getConsum().get(i)));
            camioane.add(camionNou);
        }

        for (int i = 0; i < CitireCurseCSV.getId().size(); i++) {
            String taraIncarcare = CitireCurseCSV.getTaraIncarcare().get(i);
            String taraDescarcare = CitireCurseCSV.getTaraDescarcare().get(i);

            Cursa cursaNoua = new Cursa(Integer.parseInt(CitireCurseCSV.getId().get(i)), taraIncarcare,CitireCurseCSV.getOrasIncarcare().get(i),
                    taraDescarcare, CitireCurseCSV.getOrasDescarcare().get(i), Integer.parseInt(CitireCurseCSV.getKm().get(i)),
                    Integer.parseInt(CitireCurseCSV.getPret().get(i)));

            int ok = 1, j;
            for(j = 0; j < rute.size(); j++) {
                if (rute.get(j).getTaraIncarcare().equals(taraIncarcare) && rute.get(j).getTaraDescarcare().equals(taraDescarcare)) {
                    ok = 0;
                    break;
                }
            }
            if (ok == 1) {
                List<Cursa> curseN = new ArrayList<Cursa>();
                curseN.add(cursaNoua);
                Ruta rutaNoua = new Ruta(taraIncarcare,taraDescarcare,curseN);
                rute.add(rutaNoua);
            } else {
                rute.get(j).adaugaCursa(cursaNoua);
            }

        }

        for (int i = 0; i < CitirePieseCSV.getDenumirePiesa().size(); i++) {
            Piesa piesaNoua = new Piesa(CitirePieseCSV.getDenumirePiesa().get(i), Integer.parseInt(CitirePieseCSV.getPretPiesa().get(i)),
                    Integer.parseInt(CitirePieseCSV.getCantitateDisponibila().get(i)));
            piese.add(piesaNoua);
        }


        Garaj garaj = new Garaj(piese, mecanici, 0);
        Flota flota = new Flota(camioane, soferi);

        return new Companie("Iurom Impex","Romania Gorj",88556,71360, garaj, rute, angajati, flota);
    }


}
