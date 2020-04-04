import Angajati.Mecanic;
import Flota.Flota;
import Garaj.Garaj;
import Garaj.Piesa;
import Ruta.Ruta;
import Ruta.Cursa;
import Flota.Camion;
import Angajati.Sofer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Mecanic m1 = new Mecanic("Marin",10,true,3000);
        Mecanic m2 = new Mecanic("Gabi",5,true,2500);
        List<Mecanic> mecanici = new ArrayList<>();

        Piesa piesa1 = new Piesa("Disc frana", 500,1);
        Piesa piesa2 = new Piesa("Cauciuc",1000,5);
        List<Piesa> piese = new ArrayList<Piesa>();

        Garaj garaj = new Garaj(piese, mecanici, 0);
        garaj.adaugaMecanic(m1); garaj.adaugaMecanic(m2); garaj.adaugaPiesa(piesa1); garaj.adaugaPiesa(piesa2);


        Sofer sof1 = new Sofer("Cristi", 10,true,3500);
        Sofer sof2 = new Sofer("Florin" ,5,true,3000);
        List<Sofer> soferi = new ArrayList<>();

        Camion camion1 = new Camion("GJ-20-KYS", "Volvo", true);
        Camion camion2 = new Camion("GJ-50-KYS", "Volvo", true);
        List<Camion> camioane = new ArrayList<Camion>();

        Flota flota = new Flota(camioane, soferi);
        flota.adaugaCamion(camion1); flota.adaugaCamion(camion2); flota.adaugaSofer(sof1); flota.adaugaSofer(sof2);

        Cursa cursa1 = new Cursa("Romania", "Bucuresti", "Grecia", "Athena", 1556, 1450);
        Cursa cursa2 = new Cursa("Grecia", "Patra", "Romania", "Baia Mare", 1789, 1500);
        List<Cursa> curse_ruta1 = new ArrayList<Cursa>();
        List<Cursa> curse_ruta2 = new ArrayList<Cursa>();


        Ruta ruta1 = new Ruta("Romania","Grecia", curse_ruta1);
        Ruta ruta2 = new Ruta("Grecia", "Romania", curse_ruta2);
        ruta1.adaugaCursa(cursa1);
        ruta2.adaugaCursa(cursa2);

        List<Ruta> rute = new ArrayList<Ruta>();

        Companie comp = new Companie("Iurom Impex","Romania Gorj",88556,71360, garaj, rute, flota);

        comp.adaugaRuta(ruta1);
        comp.adaugaRuta(ruta2);

        System.out.println(comp.toString());

    }
}
