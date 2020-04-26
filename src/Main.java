import Companie.Companie;
import Flota.Camion;
import Ruta.Ruta;
import Ruta.Cursa;
import Servicii.IncarcareDate;
import Servicii.Stergere.StergereCursa;


public class Main {
    public static void main(String[] args) {

        Companie companie = IncarcareDate.incarcareDate();
//        System.out.println(companie);

        Ruta ruta = companie.afisareRute();

        System.out.println(ruta);
    }
}
