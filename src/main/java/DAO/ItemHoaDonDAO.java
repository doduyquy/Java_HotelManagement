package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DTO.HoaDonDTO;
import DTO.ItemHoaDon;

public class ItemHoaDonDAO {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    DecimalFormat dcf = new DecimalFormat("###,###");

    public static ItemHoaDonDAO getInstance() {
        return new ItemHoaDonDAO();
    }

    public ArrayList<ItemHoaDon> selectAll(String mactt) {
        System.out.println("ItemHoaDonDAO -> selectAll() -> mactt: " + mactt);
        ArrayList<ItemHoaDon> listHD = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "select DISTINCT PHONG.tenP, CHITIETTHUEPHONG.loaiHinhThue,CHITIETTHUEPHONG.ngayThue,CHITIETTHUEPHONG.ngayCheckOut, CHITIETTHUEPHONG.giaThue\r\n"
                    + "from CHITIETTHUE inner join CHITIETTHUEPHONG on  CHITIETTHUE.maCTT = CHITIETTHUEPHONG.maCTT\r\n"
                    + "				inner join PHONG on CHITIETTHUEPHONG.maP = PHONG.maP\r\n"
                    + "				left join HOADON on HOADON.maCTT = CHITIETTHUE.maCTT\r\n"
                    + "				where CHITIETTHUEPHONG.maCTT = '" + mactt + "' and CHITIETTHUEPHONG.tinhtrang = 2";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("ItemHoaDonDAO -> selectAll() -> After get data from DB" );  
            
            // Print all data from ResultSet
            // Option 1:
            // while (rs.next()) {
            //     System.out.println("ItemHoaDonDAO -> selectAll() -> rs.getString(1): " + rs.getString(1));  
            //     System.out.println("ItemHoaDonDAO -> selectAll() -> rs.getInt(2): " + rs.getInt(2));  
            //     System.out.println("ItemHoaDonDAO -> selectAll() -> rs.getDate(3): " + rs.getDate(3));  
            //     System.out.println("ItemHoaDonDAO -> selectAll() -> rs.getDate(4): " + rs.getDate(4));  
            //     System.out.println("ItemHoaDonDAO -> selectAll() -> rs.getInt(5): " + rs.getInt(5));  
            // }

            // Option 2:
            // while (rs.next()) {
            //     ItemHoaDon hd = new ItemHoaDon();
            //     System.out.println("ItemHoaDonDAO -> selectAll() -> After create ItemHoaDon object" );  

            //     String tenPhong = rs.getString(1);
            //     hd.setTenP(tenPhong);
            //     // hd.setTenP(rs.getString(1));
            //     hd.setLoaiHinhThue(rs.getInt(2));
            //     hd.setNgayThue(sdf.format(rs.getDate(3)));
            //     hd.setNgayTra(sdf.format(rs.getDate(4)));
            //     hd.setGiaThue(dcf.format(rs.getInt(5)));

            //     System.out.println("ItemHoaDonDAO -> selectAll() -> After create ItemHoaDon -> setData" );

            //     listHD.add(hd);
            // }
            while (rs.next()) {
                ItemHoaDon hd = new ItemHoaDon();
                System.out.println("ItemHoaDonDAO -> selectAll() -> After create ItemHoaDon object" );  
            
                String tenPhong = rs.getString(1);
                hd.setTenP(tenPhong);
                hd.setLoaiHinhThue(rs.getInt(2));
                
                // Kiểm tra null cho ngày thuê
                Date ngayThue = rs.getDate(3);
                hd.setNgayThue(ngayThue != null ? sdf.format(ngayThue) : "N/A"); // Hoặc giá trị mặc định khác
                
                // Kiểm tra null cho ngày trả
                Date ngayTra = rs.getDate(4);
                hd.setNgayTra(ngayTra != null ? sdf.format(ngayTra) : "N/A"); // Hoặc giá trị mặc định khác
                
                hd.setGiaThue(dcf.format(rs.getInt(5)));
            
                System.out.println("ItemHoaDonDAO -> selectAll() -> After create ItemHoaDon -> setData" );
            
                listHD.add(hd);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return listHD;
    }

}
