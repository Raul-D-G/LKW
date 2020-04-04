import Angajati.Mecanic;
import Flota.Flota;
import Garaj.Garaj;
import Garaj.Piesa;
import Ruta.Ruta;
import Ruta.Cursa;
import Flota.Camion;
import Angajati.Sofer;

public class Main {
    public static void main(String[] args) {

        Piesa piesa = new Piesa("Disc frana", 500,1);
        Piesa piesa1 = new Piesa("Cauciuc",1000,5);
        Piesa[] piese = {piesa, piesa1};

        Mecanic m1 = new Mecanic("Marin",10,true,1000);
        Mecanic m2 = new Mecanic("Gabi",5,true,500);
        Mecanic[] mecanici = {m1, m2};

        Garaj garaj = new Garaj(piese, mecanici);

        Cursa c1 = new Cursa("Romania", "Bucuresti", "Grecia", "Athena", 1556, 1450);
        Cursa[] curse = {c1};

        Ruta r1 = new Ruta("Romania","Grecia", curse);
        Ruta[] rute = {r1};

        Camion camion1 = new Camion("GJ-20-KYS", "Volvo", true);
        Camion[] camioane = {camion1};

        Sofer sof1 = new Sofer("Cristi", 10,true,3500);
        Sofer[] soferi = {sof1};

        Flota flota = new Flota(camioane, soferi);

        Companie COMP = new Companie("Iurom Impex","Romania Gorj",88556,71360, garaj, rute, flota);

        System.out.println(COMP.toString());

    }
}
