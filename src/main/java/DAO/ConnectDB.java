package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static Connection getConnection() throws SQLException {

        // QUY: connect to MySQL on VSCode:

        String url = "jdbc:mysql://localhost:3306/QuanLyKhachSan";
        String user = "root";
        String password = "";

        try {
            Connection cons = null;
            cons = DriverManager.getConnection(url, user, password);
            System.out.println("DAO -> ConnectDB -> Connected  and return cons !");
            return cons;
        } catch (Exception ex) {
        }
        return null;

        // try {
        //     Connection connection = DriverManager.getConnection(url, user, password);
        //     System.out.println("Connected to the database successfully!");
        //     if (connection != null) {
        //         return connection;
        //     }
        // } catch (SQLException e) {
        //     System.out.println("Failed to connect to the database.");
        //     e.printStackTrace();
        // }
    }
}
