package homecredit.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conn {

    Connection conn = null;

    public Conn() {
        openConnection();
    }

    private void openConnection() {

        String user = (String) JOptionPane.showInputDialog("Digite el usuario:");
        String contra = (String) JOptionPane.showInputDialog("Digite la contraseña:");
        String connectionUrl = "jdbc:sqlserver://DESKTOP-ID1JPQK:1433;"
                + "database=ProyectoBasesDatos2;"
                + "user=" + user + ";"
                + "password=" + contra + ";"
                + "loginTimeout=30;";
        try {
            this.conn = DriverManager.getConnection(connectionUrl);

        } catch (SQLException ex) {

            System.out.println(ex.toString());
        }
    }

    public Connection obtainConnection() {
        return conn;
    }

    public void closeConnection() {

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
