package Flota;

import Angajati.Mecanic;
import Angajati.Sofer;
import Companie.Companie;
import Companie.CompanieController;
import DbUtil.DbConnection;
import Ruta.Cursa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;


public class FlotaController implements Initializable {

    @FXML
    private TextField idCamion;
    @FXML
    private TextField numarCamion;
    @FXML
    private TextField marcaCamion;
    @FXML
    private TextField disponibilCamion;
    @FXML
    private TextField consumCamion;

    @FXML
    private TextField idSofer;
    @FXML
    private TextField functieSofer;
    @FXML
    private TextField numeSofer;
    @FXML
    private TextField vechimeSofer;
    @FXML
    private TextField disponibilSofer;
    @FXML
    private TextField salariuSofer;

    @FXML
    private TableView<Camion> tabelCamion;
    @FXML
    private TableColumn<Camion, Integer> colCid;
    @FXML
    private TableColumn<Camion, String> colCnumar;
    @FXML
    private TableColumn<Camion, String> colCmarca;
    @FXML
    private TableColumn<Camion, Boolean> colCdisponibil;
    @FXML
    private TableColumn<Camion, Integer> colCconsum;

    @FXML
    private TableView<Sofer> tabelSofer;
    @FXML
    private TableColumn<Sofer, Integer> colSid;
    @FXML
    private TableColumn<Sofer, String> colSfunctie;
    @FXML
    private TableColumn<Sofer, String> colSnume;
    @FXML
    private TableColumn<Sofer, Integer> colSvechime;
    @FXML
    private TableColumn<Sofer, Boolean> colSdisponibil;
    @FXML
    private TableColumn<Sofer, Double> colSsalariu;

    @FXML
    private ImageView imgFlota;

    @FXML
    private  Button preiaCursa;

    private ObservableList<Sofer> soferObservableList;
    private ObservableList<Camion> camionObservableList;

    public static Sofer soferSelectat;
    public static Camion camionSelectat;


    private void afiseazaSoferi() {

        this.soferObservableList = FXCollections.observableArrayList();

        this.soferObservableList.addAll(CompanieController.companie.getFlota().getSoferi());

        this.colSid.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colSfunctie.setCellValueFactory(new PropertyValueFactory<>("functie"));
        this.colSnume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        this.colSvechime.setCellValueFactory(new PropertyValueFactory<>("vechime"));
        this.colSdisponibil.setCellValueFactory(new PropertyValueFactory<>("disponibil"));
        this.colSsalariu.setCellValueFactory(new PropertyValueFactory<>("salariuSofer"));

        this.tabelSofer.setItems(null);
        this.tabelSofer.setItems(this.soferObservableList);
    }

    private void afiseazaCamioane() {

        this.camionObservableList = FXCollections.observableArrayList();

        this.camionObservableList.addAll(CompanieController.companie.getFlota().getCamioane());

        this.colCid.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colCnumar.setCellValueFactory(new PropertyValueFactory<>("numarImatriculare"));
        this.colCmarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        this.colCdisponibil.setCellValueFactory(new PropertyValueFactory<>("disponibil"));
        this.colCconsum.setCellValueFactory(new PropertyValueFactory<>("consumPeKm"));

        this.tabelCamion.setItems(null);
        this.tabelCamion.setItems(this.camionObservableList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afiseazaSoferi();
        afiseazaCamioane();

        if (CompanieController.cursaAcceptata != null) {
            preiaCursa.setVisible(true);
        }


        File file = new File("src/imgFlota.png");
        Image image = new Image(file.toURI().toString());
        imgFlota.setImage(image);


    }

    public void adaugaCamion(ActionEvent actionEvent) {
        String sql = "INSERT INTO Camioane(Id, Nr, Marca, Disponibil, Consum) VALUES(?,?,?,?,?)";
        boolean ok = true;

        try {
            Camion camionNou = new Camion(Integer.parseInt(this.idCamion.getText()), this.numarCamion.getText(), this.marcaCamion.getText(),
                    Boolean.parseBoolean(this.disponibilCamion.getText()), Double.parseDouble(this.consumCamion.getText()));
            CompanieController.companie.getFlota().adaugaCamion(camionNou);

            this.camionObservableList.add(camionNou);
        }
        catch (RuntimeException e) {
            ok = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Campuri necompletate");
            alert.setContentText("Va rugam completati toate campurile!");

            alert.showAndWait();
        }
        if (ok) {
            try {
                Connection conn = DbConnection.getConnection();
                assert conn != null;
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, this.idCamion.getText());
                stmt.setString(2, this.numarCamion.getText());
                stmt.setString(3, this.marcaCamion.getText());
                stmt.setString(4, this.disponibilCamion.getText());
                stmt.setString(5, this.consumCamion.getText());

                stmt.execute();
                conn.close();

                this.idCamion.setText("");
                this.numarCamion.setText("");
                this.marcaCamion.setText("");
                this.disponibilCamion.setText("");
                this.consumCamion.setText("");

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void selecteazaCamion(ActionEvent actionEvent) {

        String sql = "UPDATE Camioane SET Disponibil = ? WHERE Id = ?";
        boolean ok = true, status = true;
        int id = 0;

        try {
            TablePosition pos = tabelCamion.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            Camion camion = tabelCamion.getItems().get(row);
            status = camion.isDisponibil();
            id = camion.getId();


            if (CompanieController.cursaAcceptata != null) {

                if (camion.isDisponibil())
                    camionSelectat = camion;
            }
            else {
                camionSelectat = null;
            }

            int indx = camionObservableList.indexOf(camion);
            camion.setDisponibil(!camion.isDisponibil());
            camionObservableList.set(indx, camion);

        }
        catch (RuntimeException e) {
            ok = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Camion neselectat");
            alert.setContentText("Va rugam selectati un camion!");
            alert.showAndWait();
        }

        if (ok) {
            try {
                PreparedStatement pr;
                Connection conn = DbConnection.getConnection();
                assert conn != null;
                pr = conn.prepareStatement(sql);
                pr.setBoolean(1,!status);
                pr.setInt(2,id);
                pr.execute();
                conn.close();

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Sofer selecteazaSofer(ActionEvent actionEvent) {
        String sql = "UPDATE Angajati SET Disponibil = ? WHERE Id = ?";
        boolean ok = true, status = true;
        int id = 0;
        Sofer soferReturn = null;

        try {
            TablePosition pos = tabelSofer.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            Sofer sofer = tabelSofer.getItems().get(row);
            soferReturn = sofer;

            status = sofer.isDisponibil();
            id = sofer.getId();

            if (CompanieController.cursaAcceptata != null) {
                if (sofer.isDisponibil()){
                    soferSelectat = sofer;
                }
            }
            else {
                soferSelectat = null;
            }


            int indx = soferObservableList.indexOf(sofer);
            sofer.setDisponibil(!sofer.isDisponibil());
            soferObservableList.set(indx, sofer);



        }
        catch (RuntimeException e) {
            ok = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Sofer neselectat");
            alert.setContentText("Va rugam selectati un sofer!");
            alert.showAndWait();
        }

        if (ok) {
            try {
                PreparedStatement pr;
                Connection conn = DbConnection.getConnection();
                assert conn != null;
                pr = conn.prepareStatement(sql);
                pr.setBoolean(1,!status);
                pr.setInt(2,id);
                pr.execute();
                conn.close();

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return soferReturn;
        }
        return null;
    }

    public void adaugaSofer(ActionEvent actionEvent) {

        String sql = "INSERT INTO Angajati(Id,Functie, Nume,Vechime, Disponibil, Salariu) VALUES(?,?,?,?,?,?)";
        boolean ok = true;

        try {
            Sofer soferNou = new Sofer(Integer.parseInt(this.idSofer.getText()), this.functieSofer.getText(), this.numeSofer.getText(),
                    Integer.parseInt(this.vechimeSofer.getText()), Boolean.parseBoolean(this.disponibilSofer.getText()), Double.parseDouble(this.salariuSofer.getText()));
            CompanieController.companie.getFlota().adaugaSofer(soferNou);

            this.soferObservableList.add(soferNou);
        }
        catch (RuntimeException e) {
            ok = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Campuri necompletate");
            alert.setContentText("Va rugam completati toate campurile!");

            alert.showAndWait();
        }
        if (ok) {
            try {
                Connection conn = DbConnection.getConnection();
                assert conn != null;
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, this.idSofer.getText());
                stmt.setString(2, this.functieSofer.getText());
                stmt.setString(3, this.numeSofer.getText());
                stmt.setString(4, this.vechimeSofer.getText());
                stmt.setString(5, this.disponibilSofer.getText());
                stmt.setString(6, this.salariuSofer.getText());

                stmt.execute();
                conn.close();

                this.idSofer.setText("");
                this.functieSofer.setText("");
                this.numeSofer.setText("");
                this.vechimeSofer.setText("");
                this.disponibilSofer.setText("");
                this.salariuSofer.setText("");

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void concediazaSofer(ActionEvent actionEvent) {

        Sofer sofer = this.selecteazaSofer(actionEvent);

        if (sofer != null) {

            soferObservableList.remove(sofer);
            CompanieController.companie.getFlota().getSoferi().remove(sofer);

            String sql = "DELETE FROM Angajati WHERE ID = ?";

            try {
                Connection conn = DbConnection.getConnection();
                assert conn != null;
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, String.valueOf(sofer.getId()));

                stmt.execute();
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void cursa(ActionEvent actionEvent) {

        String sql = "INSERT INTO Contabilitate(Id, NumeCursa, Camion, Sofer, Profit) VALUES(?, ?, ?, ?, ?)";
        Cursa cursa = CompanieController.cursaAcceptata;
        Sofer sofer = this.soferSelectat;
        Camion camion = this.camionSelectat;

        if (cursa == null) {
            this.preiaCursa.setVisible(false);
            return;
        }

        if (sofer == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Sofer neselectat");
            alert.setContentText("Va rugam selectati un sofer disponibil!");
            alert.showAndWait();
        }

        if (camion == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Camion neselectat");
            alert.setContentText("Va rugam selectati un Camion disponibil!");
            alert.showAndWait();
        }



        if (sofer != null && camion != null) {

            double cheltuieli = sofer.getSalariuSofer()/4 + cursa.getKm() * camion.getConsumPeKm()/100;
            double profit = cursa.getPret() - cheltuieli;
            String numeCursa = cursa.getOrasIncarcare() + " " + cursa.getOrasDescarcare();

            String uniqueID = String.valueOf(sofer.getId()) + String.valueOf(cursa.getId());

            try {
                Connection conn = DbConnection.getConnection();
                assert conn != null;
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, uniqueID);
                stmt.setString(2, numeCursa);
                stmt.setString(3, camion.getNumarImatriculare());
                stmt.setString(4, sofer.getNume());
                stmt.setString(5, String.valueOf(profit));

                this.camionSelectat = null;
                this.soferSelectat = null;
                CompanieController.cursaAcceptata = null;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informatie");
                alert.setHeaderText(null);
                alert.setContentText("Cursa a fost inregistrata in contabilitate!");

                alert.showAndWait();

                System.out.println(profit);

                stmt.executeUpdate();
                conn.close();
                this.preiaCursa.setVisible(false);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
