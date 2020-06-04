package Companie;

import Angajati.Angajat;
import Angajati.Mecanic;
import Angajati.Sofer;
import Flota.Camion;
import Flota.Flota;
import Garaj.Garaj;
import Garaj.Piesa;
import Ruta.Ruta;
import Ruta.Cursa;
import Garaj.GarajController;
import Flota.FlotaController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import DbUtil.DbConnection;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CompanieController implements Initializable {

    @FXML
    private Button butonGaraj;
    @FXML
    private TabPane tabPan;


    @FXML
    private Label numeCompanie;
    @FXML
    private Label adresaCompanie;
    @FXML
    private Label cuiCompanie;
    @FXML
    private  Label ibanCompanie;

    @FXML
    private TableView<Ruta> tabelRute;

    @FXML
    private TableColumn<Ruta, String> incarcareRute;

    @FXML
    private TableColumn<Ruta, String> descarcareRute;

    @FXML
    private TableView<Cursa> tabelCurse;
    @FXML
    private TableColumn<Cursa, Integer> idcol;
    @FXML
    private TableColumn<Cursa, String> incarcareTcol;
    @FXML
    private TableColumn<Cursa, String> incarcareOcol;
    @FXML
    private TableColumn<Cursa, String> descarcareTcol;
    @FXML
    private TableColumn<Cursa, String> DescarcareOcol;
    @FXML
    private TableColumn<Cursa, Integer> kmcol;
    @FXML
    private TableColumn<Cursa, Double> pretcol;


    public static Companie companie;
    private DbConnection dc;
    private ObservableList<Ruta> rutaObservableList;
    private ObservableList<Cursa> cursaObservableList;

    Companie creareaCompanie(Connection conn) {
        String sql1 = "SELECT * FROM Companie";
        String sql2 = "SELECT * FROM Piese";
        String sql3 = "SELECT * FROM Angajati";
        String sql4 = "SELECT * FROM Curse";
        String sql5 = "SELECT * FROM Camioane";


        String nume, adresa, cui, iban, numePiesa, functie, numeAngajat, tarai, orasi, tarad, orasd, nrCamion, marca;
        int pretPiesa, numarDePiese, idpiesa, idangajat, vechime, idCursa, km, idCamion, consum;
        boolean disponibil;
        double salariu, pret;

        List<Piesa> piese = new ArrayList<>();
        List<Angajat> angajati = new ArrayList<>();
        List<Mecanic> mecanici = new ArrayList<>();
        List<Sofer> soferi = new ArrayList<>();
        List<Ruta> rute = new ArrayList<>();
        List<Cursa> curse = new ArrayList<>();
        List<Camion> camioane = new ArrayList<>();

        PreparedStatement pr;
        ResultSet rs;

        try {

//          Piese
            pr = conn.prepareStatement(sql2);
            rs = pr.executeQuery();
            while (rs.next()) {
                idpiesa = rs.getInt(1);
                numePiesa = rs.getString(2);
                pretPiesa = rs.getInt(3);
                numarDePiese = rs.getInt(4);
                Piesa p = new Piesa(idpiesa, numePiesa, pretPiesa, numarDePiese);
                piese.add(p);
            }


//            Angajati
            pr = conn.prepareStatement(sql3);
            rs = pr.executeQuery();
            while (rs.next()) {
                idangajat = rs.getInt(1);
                functie = rs.getString(2);
                numeAngajat = rs.getString(3);
                vechime = rs.getInt(4);
                disponibil = rs.getBoolean(5);
                salariu = rs.getDouble(6);
                if (functie.equals("Sofer")) {
                    Sofer sofer = new Sofer(idangajat, functie, numeAngajat, vechime, disponibil, salariu);
                    soferi.add(sofer);
                    angajati.add(sofer);
                }
                else {
                    Mecanic mecanic = new Mecanic(idangajat, functie, numeAngajat, vechime, disponibil, salariu);
                    mecanici.add(mecanic);
                    angajati.add(mecanic);
                }
            }


            Garaj garaj = new Garaj(piese, mecanici);

//            Curse
            pr = conn.prepareStatement(sql4);
            rs = pr.executeQuery();
            while (rs.next()) {
                idCursa = rs.getInt(1);
                tarai = rs.getString(2);
                orasi = rs.getString(3);
                tarad = rs.getString(4);
                orasd = rs.getString(5);
                km = rs.getInt(6);
                pret = rs.getDouble(7);
                Cursa cursa = new Cursa(idCursa, tarai, orasi, tarad, orasd, km, pret);
                curse.add(cursa);
            }


//            Camioane
            pr = conn.prepareStatement(sql5);
            rs = pr.executeQuery();
            while (rs.next()) {
                idCamion = rs.getInt(1);
                nrCamion = rs.getString(2);
                marca = rs.getString(3);
                disponibil = rs.getBoolean(4);
                consum = rs.getInt(5);
                Camion camion = new Camion(idCamion, nrCamion, marca, disponibil, consum);
                camioane.add(camion);
            }

            List<Cursa> curseRuta1 = new ArrayList<>();
            List<Cursa> curseRuta2 = new ArrayList<>();
            Ruta ruta1 = new Ruta("Romania", "Grecia", curseRuta1);
            Ruta ruta2 = new Ruta("Grecia", "Romania", curseRuta2);

            for (Cursa cursa : curse) {
                if (cursa.getTaraIncarcare().equals("Romania") && cursa.getTaraDescarcare().equals("Grecia")) {
                    ruta1.adaugaCursa(cursa);
                }
                else {
                    ruta2.adaugaCursa(cursa);
                }
            }
            rute.add(ruta1); rute.add(ruta2);


            Flota flota = new Flota(camioane, soferi);


//            Date Companie
            pr = conn.prepareStatement(sql1);
            rs = pr.executeQuery();
            if (rs.next()) {
                nume = rs.getString(1);
                adresa = rs.getString(2);
                cui = rs.getString(3);
                iban = rs.getString(4);
                return new Companie(nume, adresa, cui, iban, garaj, rute, angajati, flota);
            }
        }
        catch (SQLException e) {
            System.err.println("Eroare " + e);
        }

        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dc = new DbConnection();
        try {
            Connection conn = DbConnection.getConnection();
            assert conn != null;
            companie = creareaCompanie(conn);
            conn.close();
            this.numeCompanie.setText(companie.getNume());
            this.adresaCompanie.setText(companie.getAdresa());
            this.cuiCompanie.setText(companie.getCui());
            this.ibanCompanie.setText(companie.getIBAN());

            this.rutaObservableList = FXCollections.observableArrayList();

            for (Ruta ruta : companie.getRute()) {
                this.rutaObservableList.add(new Ruta(ruta.getTaraIncarcare(), ruta.getTaraDescarcare(), ruta.getCurse()));
            }


        }
        catch (SQLException e) {
            System.err.println("Eroare " + e);
        }


        this.incarcareRute.setCellValueFactory(new PropertyValueFactory<>("taraIncarcare"));
        this.descarcareRute.setCellValueFactory(new PropertyValueFactory<>("taraDescarcare"));
        this.tabelRute.setItems(null);
        this.tabelRute.setItems(this.rutaObservableList);

    }

    public void afiseazaCurse(javafx.event.ActionEvent actionEvent) {

        try {
            TablePosition pos = tabelRute.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            Ruta item = tabelRute.getItems().get(row);
            List<Cursa> curse = item.getCurse();

            this.cursaObservableList = FXCollections.observableArrayList();

            for (Cursa cursa : curse) {
                this.cursaObservableList.add(new Cursa(cursa.getId(), cursa.getTaraIncarcare(), cursa.getOrasIncarcare(), cursa.getTaraDescarcare(),
                        cursa.getOrasDescarcare(), cursa.getKm(), cursa.getPret()));
            }


            this.idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
            this.incarcareTcol.setCellValueFactory(new PropertyValueFactory<>("taraIncarcare"));
            this.incarcareOcol.setCellValueFactory(new PropertyValueFactory<>("orasIncarcare"));
            this.descarcareTcol.setCellValueFactory(new PropertyValueFactory<>("taraDescarcare"));
            this.DescarcareOcol.setCellValueFactory(new PropertyValueFactory<>("orasDescarcare"));
            this.kmcol.setCellValueFactory(new PropertyValueFactory<>("km"));
            this.pretcol.setCellValueFactory(new PropertyValueFactory<>("pret"));

            this.tabelCurse.setItems(null);
            this.tabelCurse.setItems(this.cursaObservableList);
        }
        catch (RuntimeException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Ruta neselectata");
            alert.setContentText("Va rugam selectati o ruta disponibila!");

            alert.showAndWait();
        }
    }

    public void mergiLaGaraj(ActionEvent actionEvent) {
        boolean ok = true;
        for (Tab tab : tabPan.getTabs()) {
            if (tab.getText().equalsIgnoreCase("garaj"))
                ok = false;
        }
        if (ok) {
            try {
                FXMLLoader loader = new FXMLLoader();
                AnchorPane root = (AnchorPane) loader.load(getClass().getResource("/Garaj/Garaj.fxml").openStream());
                Tab tab = new Tab("Garaj");

                tab.setContent(root);
                GarajController garajController = (GarajController) loader.getController();

                tabPan.getTabs().add(tab);


                SingleSelectionModel<Tab> selectionModel = tabPan.getSelectionModel();
                selectionModel.select(tab);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
                SingleSelectionModel<Tab> selectionModel = tabPan.getSelectionModel();
                for (Tab tab : tabPan.getTabs()) {
                    if (tab.getText().equalsIgnoreCase("garaj")) {
                        selectionModel.select(tab);
                        break;
                    }

                }
        }
    }

    public void mergiLaFlota(ActionEvent actionEvent) {
        boolean ok = true;
        for (Tab tab : tabPan.getTabs()) {
            if (tab.getText().equalsIgnoreCase("flota"))
                ok = false;
        }
        if (ok) {
            try {
                FXMLLoader loader = new FXMLLoader();
                AnchorPane root = (AnchorPane) loader.load(getClass().getResource("/Flota/Flota.fxml").openStream());
                Tab tab = new Tab("Flota");

                tab.setContent(root);
                FlotaController flotaController = (FlotaController) loader.getController();

                tabPan.getTabs().add(tab);


                SingleSelectionModel<Tab> selectionModel = tabPan.getSelectionModel();
                selectionModel.select(tab);

            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            SingleSelectionModel<Tab> selectionModel = tabPan.getSelectionModel();
            for (Tab tab : tabPan.getTabs()) {
                if (tab.getText().equalsIgnoreCase("Flota")) {
                    selectionModel.select(tab);
                    break;
                }

            }
        }
    }

    public void acceptaCursa(ActionEvent actionEvent) {
        try {
            TablePosition pos = tabelCurse.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            Cursa cursa = tabelCurse.getItems().get(row);
            
        }
        catch (RuntimeException e) {
            System.out.println("Cursa neselectata");
        }
    }


}
