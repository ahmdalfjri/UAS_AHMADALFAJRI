/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

/**
 *
 * @author ilham
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() throws SQLException {
        String url = "jdbc:derby://localhost:1527/gymdb";
        String user = "admin123";
        String password = "admin123";
        return DriverManager.getConnection(url, user, password);
    }
}
