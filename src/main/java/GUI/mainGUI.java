package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
// import GUI.GUI_FUNCTION_ACCOUNT.FormLoading;
import GUI.GUI_FUNCTION_ACCOUNT.FormLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException; 

public class mainGUI {
    public static NhanVienDTO nv = new NhanVienDTO();

    public static void main(String[] args) {
        // setLookAndFeel(); // Đặt Look and Feel trước khi mở form
        // connectToDatabase();
        new FormLogin();
    }
    private static void setLookAndFeel() {
        try {
            // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (ClassNotFoundException | InstantiationException | 
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private static void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/QuanLyKhachSan";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");
            if (connection != null) {
                showAllUsers(connection);
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    private static void showAllUsers(Connection connection) {
        String query = "SELECT * FROM TAIKHOAN";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String taiKhoan = rs.getString("taiKhoan");
                String maNV = rs.getString("maNV");
                String vaiTro = rs.getString("vaiTro");
                System.out.println("User: " + taiKhoan + ", Employee ID: " + maNV + ", Role: " + vaiTro);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve users.");
            e.printStackTrace();
        }
    }
}
