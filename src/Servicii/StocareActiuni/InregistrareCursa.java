package Servicii.StocareActiuni;

import Ruta.Cursa;
import Servicii.Scriere.AuditCSV;

import java.util.ArrayList;
import java.util.List;

public class InregistrareCursa {

    static public void inregistrareCursa(Cursa cursa, double profit) {
        List<String> actiune = new ArrayList<>();
        actiune.add(cursa.toString());
        actiune.add(Double.toString(profit));
        AuditCSV auditCSV = AuditCSV.getInstance();
        auditCSV.audit(actiune);
    }

}
