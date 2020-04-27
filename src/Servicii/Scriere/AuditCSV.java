package Servicii.Scriere;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AuditCSV {

    public static AuditCSV audit = null;

    private final String numeFisier = "src/MyCSV/Audit.csv";
    private PrintWriter writer;

    public AuditCSV() {
        try {
            FileWriter fw = new FileWriter(numeFisier);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {}
    }

    public static synchronized AuditCSV getInstance() {
        if (audit == null) {
            audit = new AuditCSV();
        }
        return audit;
    }

    public void audit(List<String> actiune) {
        String inregistrare = String.join(",", actiune);
        writer.println(inregistrare);
    }
}
