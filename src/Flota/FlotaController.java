package Flota;

import Angajati.Mecanic;
import Angajati.Sofer;
import Companie.CompanieController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


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

    private ObservableList<Sofer> soferObservableList;
    private ObservableList<Camion> camionObservableList;


    private void afiseazaSoferi() {

        this.soferObservableList = FXCollections.observableArrayList();

        for (Sofer sofer : CompanieController.companie.getFlota().getSoferi()) {

            this.soferObservableList.add(new Sofer(sofer.getId(), sofer.getFunctie(), sofer.getNume(),
                    sofer.getVechime(), sofer.isDisponibil(), sofer.getSalariuSofer()));
        }

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

        for (Camion camion : CompanieController.companie.getFlota().getCamioane()) {

            this.camionObservableList.add(new Camion(camion.getId(), camion.getNumarImatriculare(), camion.getMarca(),
                    camion.isDisponibil(), camion.getConsumPeKm()));
        }

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

        File file = new File("src/imgFlota.png");
        Image image = new Image(file.toURI().toString());
        imgFlota.setImage(image);


    }

    public void selecteazaCamion(ActionEvent actionEvent) {

    }

    public void selecteazaSofer(ActionEvent actionEvent) {

    }

    public void adaugaSofer(ActionEvent actionEvent) {

    }

    public void concediazaSofer(ActionEvent actionEvent) {

    }

    public void adaugaCamion(ActionEvent actionEvent) {

    }
}
