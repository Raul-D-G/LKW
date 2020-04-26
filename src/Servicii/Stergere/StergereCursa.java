package Servicii.Stergere;

import java.io.*;

public class StergereCursa {
    static public void stergereCursa(String idCursa, int pozitieCSV) {

        String csvSplitBy = ",";
        String numeFisier = "src/MyCSV/Curse.csv";

        int pozitie = pozitieCSV - 1;
        String fisierTemp = "temp.csv";

        File fisierVechi = new File(numeFisier);
        File fiserNou = new File(fisierTemp);

        String liniaCurenta;
        String[] data;

        try {
            FileWriter fw = new FileWriter(fisierTemp, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(numeFisier);
            BufferedReader br = new BufferedReader(fr);

            while ((liniaCurenta = br.readLine()) != null) {
                data = liniaCurenta.split(csvSplitBy);
                if(!(data[pozitie].equalsIgnoreCase(idCursa))) {
                    pw.println(liniaCurenta);
                }
            }

            pw.flush();
            pw.close(); fr.close(); br.close(); bw.close(); fw.close();

            fisierVechi.delete();
            File dump = new File(numeFisier);
            fiserNou.renameTo(dump);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
