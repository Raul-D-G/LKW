package Contabilitate;

import DbUtil.DbConnection;
import LoginApp.LoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ContabilitateController implements Initializable {

    @FXML
    private TableView<Contabilitate> tabelContabilitate;
    @FXML
    private TableColumn<Contabilitate, Integer> colId;
    @FXML
    private TableColumn<Contabilitate, String > colCursa;
    @FXML
    private TableColumn<Contabilitate, String > colCamion;
    @FXML
    private TableColumn<Contabilitate, String > colSofer;
    @FXML
    private TableColumn<Contabilitate, Double> colProfit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String sql = "SELECT * FROM Contabilitate WHERE IdCompanie = ?";
        DbConnection dc = new DbConnection();
        int id;
        String cursa, camion, sofer;
        double profit;

        try {
            Connection conn = DbConnection.getConnection();
            assert conn != null;
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setInt(1,LoginController.idCompanie);
            ResultSet rs = pr.executeQuery();

            ObservableList<Contabilitate> contabilitateObservableList = FXCollections.observableArrayList();

            while (rs.next()) {
                id = rs.getInt(1);
                cursa = rs.getString(2);
                camion = rs.getString(3);
                sofer = rs.getString(4);
                profit = rs.getDouble(5);

                Contabilitate cont = new Contabilitate(id, cursa, camion, sofer, profit);
                contabilitateObservableList.add(cont);
            }

            this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            this.colCursa.setCellValueFactory(new PropertyValueFactory<>("cursa"));
            this.colCamion.setCellValueFactory(new PropertyValueFactory<>("camion"));
            this.colSofer.setCellValueFactory(new PropertyValueFactory<>("sofer"));
            this.colProfit.setCellValueFactory(new PropertyValueFactory<>("profit"));

            this.tabelContabilitate.setItems(null);
            this.tabelContabilitate.setItems(contabilitateObservableList);
            conn.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
