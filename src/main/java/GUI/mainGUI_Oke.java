package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
// import GUI.GUI_FUNCTION_ACCOUNT.FormLoading;
import GUI.GUI_FUNCTION_ACCOUNT.FormLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mainGUI_Oke {

    public static NhanVienDTO nv = new NhanVienDTO();

    public static void main(String[] args) {
        connectToDatabase();
        new FormLogin();
    }

    private static void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/QuanLyKhachSan";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
