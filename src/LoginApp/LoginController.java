package LoginApp;

import Companie.CompanieController;
import Inregistrare.InregistrareController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbStatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;

    public static int idCompanie;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (this.loginModel.isDataBaseConnected()) {
            this.dbStatus.setText("Connected to DataBase");
        }
        else {
            this.dbStatus.setText("Not Connected to DataBase");
        }
    }

    @FXML
    public void Login(ActionEvent event) {
        try {

            if (this.loginModel.isLogin(this.username.getText(), this.password.getText()) ) {
                Stage stage = (Stage) this.loginButton.getScene().getWindow();
                stage.close();
                companieTransportLogin();

            }
            else {
                this.loginStatus.setText("Nume/Parola gresit!");
            }
        }
        catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void companieTransportLogin() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Companie/Companie.fxml").openStream());

            CompanieController companieController = (CompanieController) loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Companie");
            userStage.setResizable(false);
            userStage.show();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void inregistrare(ActionEvent actionEvent) {
        Stage stage = (Stage) this.loginButton.getScene().getWindow();
        stage.close();

        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Inregistrare/Inregistrare.fxml").openStream());

            InregistrareController inregistrareController = (InregistrareController) loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Inregistrare");
            userStage.setResizable(false);
            userStage.show();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
