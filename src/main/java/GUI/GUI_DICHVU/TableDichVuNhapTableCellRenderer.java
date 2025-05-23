package GUI.GUI_DICHVU;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableDichVuNhapTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        // Lấy component mặc định từ lớp cha
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Đặt icon null cho các cột khác
        if (column == table.getColumnModel().getColumnIndex("Mã dịch vụ") || column == table.getColumnModel().getColumnIndex("STT")) {
            setFont(new Font("Segoe UI", Font.BOLD, 13));
        } else {
            setFont(new Font("Segoe UI", Font.PLAIN, 13));
        }
        if (column == table.getColumnModel().getColumnIndex("Mã dịch vụ") || column == table.getColumnModel().getColumnIndex("Tên dịch vụ")) {
            setHorizontalAlignment(JLabel.LEFT);
        } else if (column == table.getColumnModel().getColumnIndex("Tồn kho") || column == table.getColumnModel().getColumnIndex("Đang nhập")
                || column == table.getColumnModel().getColumnIndex("Đơn giá bán")) {
            setHorizontalAlignment(JLabel.RIGHT);
        } else {
            setHorizontalAlignment(JLabel.CENTER);
        }
        setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(7, 7, 7, 7)));

        setBackground(Color.white);
        return c;
    }
}
