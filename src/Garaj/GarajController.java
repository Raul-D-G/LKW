package Garaj;

import Angajati.Mecanic;
import Companie.Companie;
import Companie.CompanieController;
import DbUtil.DbConnection;
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


public class GarajController implements Initializable {

    @FXML
    private TableView<Mecanic> tabelMecanic;
    @FXML
    private TableColumn<Mecanic, Integer> colMid;
    @FXML
    private TableColumn<Mecanic, String> colMfunctie;
    @FXML
    private TableColumn<Mecanic, String> colMnume;
    @FXML
    private TableColumn<Mecanic, Integer> colMvechime;
    @FXML
    private TableColumn<Mecanic, Boolean> colMdisponibil;
    @FXML
    private TableColumn<Mecanic, Double> colMsalariu;

    @FXML
    private TableView<Piesa> tabelPiesa;
    @FXML
    private TableColumn<Piesa, Integer> colPid;
    @FXML
    private TableColumn<Piesa, String> colPnume;
    @FXML
    private TableColumn<Piesa, String> colPpret;
    @FXML
    private TableColumn<Piesa, Integer> colPnumar;

    @FXML
    private TextField idMecanic;
    @FXML
    private TextField functieMecanic;
    @FXML
    private TextField numeMecanic;
    @FXML
    private TextField vechimeMecanic;
    @FXML
    private TextField disponibilMecanic;
    @FXML
    private TextField salariuMecanic;
    @FXML
    private TextField idPiesa;
    @FXML
    private TextField numePiesa;
    @FXML
    private TextField pretPiesa;
    @FXML
    private TextField nrPiesa;

    @FXML
    private ImageView imgM;
    @FXML
    private ImageView imgP;


    private ObservableList<Mecanic> mecanicObservableList;
    private ObservableList<Piesa> piesaObservableList;

    private void afiseazaMecanici() {

        this.mecanicObservableList = FXCollections.observableArrayList();

        this.mecanicObservableList.addAll(CompanieController.companie.getGaraj().getMecanici());

        this.colMid.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colMfunctie.setCellValueFactory(new PropertyValueFactory<>("functie"));
        this.colMnume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        this.colMvechime.setCellValueFactory(new PropertyValueFactory<>("vechime"));
        this.colMdisponibil.setCellValueFactory(new PropertyValueFactory<>("disponibil"));
        this.colMsalariu.setCellValueFactory(new PropertyValueFactory<>("salariuMecanic"));

        this.tabelMecanic.setItems(null);
        this.tabelMecanic.setItems(this.mecanicObservableList);
    }

    private void afiseazaPiese() {

        this.piesaObservableList = FXCollections.observableArrayList();

        this.piesaObservableList.addAll(CompanieController.companie.getGaraj().getPiese());

        this.colPid.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colPnume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        this.colPpret.setCellValueFactory(new PropertyValueFactory<>("pret"));
        this.colPnumar.setCellValueFactory(new PropertyValueFactory<>("numarDePiese"));

        this.tabelPiesa.setItems(null);
        this.tabelPiesa.setItems(this.piesaObservableList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afiseazaMecanici();
        afiseazaPiese();

        File file = new File("src/Untitled.jpg");
        Image image = new Image(file.toURI().toString());
        imgM.setImage(image);

        File file1 = new File("src/piese.jpg");
        Image image1 = new Image(file1.toURI().toString());
        imgP.setImage(image1);

    }

    public void selecteazaMecanic(ActionEvent actionEvent) {
        String sql = "UPDATE Angajati SET Disponibil = ? WHERE Id = ?";
        boolean ok = true, status = true;
        int id = 0;

        try {
            TablePosition pos = tabelMecanic.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            Mecanic mecanic = tabelMecanic.getItems().get(row);

            status = mecanic.isDisponibil();
            id = mecanic.getId();

            int indx = mecanicObservableList.indexOf(mecanic);
            mecanic.setDisponibil(!mecanic.isDisponibil());
            mecanicObservableList.set(indx, mecanic);



        }
        catch (RuntimeException e) {
            ok = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Mecanic neselectat");
            alert.setContentText("Va rugam selectati un mecanic!");

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

    public void adaugaMecanic(ActionEvent actionEvent) {
        String sql = "INSERT INTO Angajati(Id,Functie, Nume,Vechime, Disponibil, Salariu) VALUES(?,?,?,?,?,?)";
        boolean ok = true;

        try {
            Mecanic mecanicNou = new Mecanic(Integer.parseInt(this.idMecanic.getText()), this.functieMecanic.getText(), this.numeMecanic.getText(),
                    Integer.parseInt(this.vechimeMecanic.getText()), Boolean.parseBoolean(this.disponibilMecanic.getText()), Double.parseDouble(this.salariuMecanic.getText()));
            CompanieController.companie.getGaraj().adaugaMecanic(mecanicNou);

            this.mecanicObservableList.add(mecanicNou);
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

                stmt.setString(1, this.idMecanic.getText());
                stmt.setString(2, this.functieMecanic.getText());
                stmt.setString(3, this.numeMecanic.getText());
                stmt.setString(4, this.vechimeMecanic.getText());
                stmt.setString(5, this.disponibilMecanic.getText());
                stmt.setString(6, this.salariuMecanic.getText());

                stmt.execute();
                conn.close();

                this.idMecanic.setText("");
                this.functieMecanic.setText("");
                this.numeMecanic.setText("");
                this.vechimeMecanic.setText("");
                this.disponibilMecanic.setText("");
                this.salariuMecanic.setText("");

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void selecteazaPiesa(ActionEvent actionEvent) {
        String sql = "UPDATE Piese SET Nrpiese = ? WHERE Id = ?";
        boolean ok = true;
        int id = 0, nrpiese = 0;
        try {
            TablePosition pos = tabelPiesa.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            Piesa piesa = tabelPiesa.getItems().get(row);
            id = piesa.getId();
            nrpiese = piesa.getNumarDePiese();

            int indx = piesaObservableList.indexOf(piesa);
            piesa.setNumarDePiese(piesa.getNumarDePiese() - 1);
            piesaObservableList.set(indx, piesa);
        }
        catch (RuntimeException e) {
            ok = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertisment");
            alert.setHeaderText("Piesa neselectata");
            alert.setContentText("Va rugam selectati o piesa!");

            alert.showAndWait();
        }
        if (ok) {
            try {
                PreparedStatement pr;
                Connection conn = DbConnection.getConnection();

                assert conn != null;
                pr = conn.prepareStatement(sql);
                pr.setInt(1,nrpiese - 1);
                pr.setInt(2,id);
                pr.execute();
                conn.close();

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void adaugaPiesa(ActionEvent actionEvent) {
        String sql = "INSERT INTO Piese(Id,Nume,Pret, Nrpiese) VALUES(?,?,?,?)";
        boolean ok = true;


        try {
            Piesa piesaNoua = new Piesa(Integer.parseInt(this.idPiesa.getText()), this.numePiesa.getText(), Double.parseDouble(this.pretPiesa.getText()),
                    Integer.parseInt(this.nrPiesa.getText()));

            CompanieController.companie.getGaraj().adaugaPiesa(piesaNoua);
            this.piesaObservableList.add(piesaNoua);
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

                stmt.setString(1, this.idPiesa.getText());
                stmt.setString(2, this.numePiesa.getText());
                stmt.setString(3, this.pretPiesa.getText());
                stmt.setString(4, this.nrPiesa.getText());

                stmt.execute();
                conn.close();

                this.idPiesa.setText("");
                this.numePiesa.setText("");
                this.pretPiesa.setText("");
                this.nrPiesa.setText("");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
