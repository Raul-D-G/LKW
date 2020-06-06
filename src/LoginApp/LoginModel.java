package LoginApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtil.DbConnection;

import javax.swing.*;

public class LoginModel {
    Connection connection;

    public LoginModel() {
        try {
            this.connection = DbConnection.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if (this.connection == null) {
            System.exit(1);
        }
    }


    public boolean isDataBaseConnected() {
        return this.connection != null;
    }

    public boolean isLogin(String user, String password) throws Exception {
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login where Nume = ? and Parola = ?";

        try {
            pr = this.connection.prepareStatement(sql);

            pr.setString(1,user);
            pr.setString(2,password);

            rs = pr.executeQuery();
            return rs.next();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                assert pr != null;
                pr.close();
                assert rs != null;
                rs.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
