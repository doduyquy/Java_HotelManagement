package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static final String URL = "jdbc:mysql://localhost:3306/java"; // Cổng mặc định MySQL là 3306
    private static final String USER = "root"; // Tài khoản mặc định của XAMPP
    private static final String PASSWORD = ""; // Mặc định của XAMPP không có mật khẩu

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver mới nhất của MySQL
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy Driver MySQL!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối MySQL!");
            e.printStackTrace();
        }
        return conn;
    }
}
