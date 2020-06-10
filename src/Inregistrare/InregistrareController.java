package Inregistrare;

import Companie.CompanieController;
import DbUtil.DbConnection;
import LoginApp.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;


public class InregistrareController implements Initializable {

    @FXML
    private TextField numeUtilizator;
    @FXML
    private TextField parola;
    @FXML
    private TextField nume;
    @FXML
    private TextField adresa;
    @FXML
    private TextField cui;
    @FXML
    private TextField iban;
    @FXML
    private ImageView img;
    @FXML
    private Button buton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("src/Volvo.jpg");
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }

    public void inregistrare(ActionEvent actionEvent) {


        String sql = "INSERT INTO Login(IdCompanie, Nume, Parola) VALUES(?,?,?)";
        String sqlComp = "INSERT INTO Companie(Id, Nume, Adresa, CUI, IBAN) VALUES(?, ?, ?, ?, ?)";
        boolean ok = true;
        int id = 0;
        String nume = null, adresa = null, cui = null, iban = null, numUtilizator = null, parola = null;

        try {
            id = new Random().nextInt(10000);
            nume = this.nume.getText();
            adresa = this.adresa.getText();
            cui = this.cui.getText();
            iban = this.iban.getText();

            numUtilizator = this.numeUtilizator.getText();
            parola = this.parola.getText();

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
                stmt.setInt(1, id);
                stmt.setString(2, numUtilizator);
                stmt.setString(3, parola);

                stmt.execute();

                PreparedStatement stmt1 = conn.prepareStatement(sqlComp);
                stmt1.setInt(1, id);
                stmt1.setString(2, nume);
                stmt1.setString(3, adresa);
                stmt1.setString(4, cui);
                stmt1.setString(5, iban);
                stmt1.execute();

                conn.close();

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }



        Stage stage = (Stage) this.buton.getScene().getWindow();
        stage.close();

        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/LoginApp/login.fxml").openStream());

            LoginController loginController = (LoginController) loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Administrare Companie Transport");
            userStage.setResizable(false);
            userStage.show();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
