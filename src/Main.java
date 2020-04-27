import Companie.Companie;
import Flota.Camion;
import Ruta.Ruta;
import Servicii.IncarcareDate;
import Ruta.Cursa;

import Servicii.StocareActiuni.InregistrareCursa;



public class Main {
    public static void main(String[] args) {

        Companie companie = IncarcareDate.incarcareDate();
//        System.out.println(companie);

        Ruta ruta = companie.afisareRute();

        Camion camion = companie.cautaCamionDisponibil();

        Cursa cursa = companie.cautaCurse(ruta);

        double profit = companie.acceptaCursa(cursa, camion);

        System.out.println("Profit: " + profit + " euro, obtinut in urma cursei:\n" +
                cursa +"\n efectuata cu camionul\n" + camion);


        InregistrareCursa.inregistrareCursa(cursa, profit);



    }
}
