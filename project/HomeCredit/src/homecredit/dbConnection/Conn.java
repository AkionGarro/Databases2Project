package homecredit.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {

    Connection conn = null;

    public Conn() {
        openConnection();
    }

    private void openConnection() {

        String connectionUrl = "jdbc:sqlserver://DESKTOP-ID1JPQK:1433;"
                + "database=ProyectoBasesDatos2;"
                + "user=sa;"
                + "password=garroakion2908;"
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
