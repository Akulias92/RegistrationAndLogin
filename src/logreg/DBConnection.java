package logreg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/aliexpress";
    private String user = "root";
    private String password = "root92";

    private Connection conn = null;
    private static DBConnection instance = null;

    public DBConnection() throws SQLException {
        // treba nam konstruktor za konekciju!!//
        conn = DriverManager.getConnection(url, user, password);

    }

    // Getter da dohvati konekciju posto je private//
    public Connection getConn() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance.conn;
    }

}
