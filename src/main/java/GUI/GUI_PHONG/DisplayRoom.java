package GUI.GUI_PHONG;

import BUS.PhongBUS;
import DTO.PhongDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class DisplayRoom extends JPanel {

    private int LightDark;
    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    JPanel pnTop = new JPanel();
    JPanel pnContent = new JPanel();
    JPanel pnTopHeader = new JPanel();
    JPanel pnTopHeaderLeft = new JPanel();
    JPanel pnTopHeaderRight = new JPanel();
    JLabel lbTopHeaderLeftTop = new JLabel("Quản lý phòng");
    JLabel lbTopHeaderLeftBottom = new JLabel("Bấm vào hàng của bảng danh sách phòng để chỉnh sửa");
    JButton btnAdd = new JButton("Thêm phòng");
    JButton btnImportFile = new JButton("Nhập tệp");
    JButton btnExportFile = new JButton("Xuất tệp");
    JPanel pnMaP = new JPanel();
    JLabel lbMaP = new JLabel("Mã phòng");
    JTextField txtMaP = new JTextField();
    JPanel pnTenP = new JPanel();
    JLabel lbTenP = new JLabel("Tên phòng");
    JTextField txtTenP = new JTextField();
    JPanel pnLoaiP = new JPanel();
    JLabel lbLoaiP = new JLabel("Loại phòng");
    JComboBox cbLoaiP = new JComboBox();
    JPanel pnChiTietLoaiP = new JPanel();
    JLabel lbChiTietLoaiP = new JLabel("Phòng");
    JComboBox cbChiTietLoaiP = new JComboBox();
    JPanel pnGiaP = new JPanel();
    JLabel lbGiaP = new JLabel("Giá phòng");
    JComboBox cbGiaP = new JComboBox();
    JPanel pnTTP = new JPanel();
    JLabel lbTTP = new JLabel("Tình trạng phòng");
    JComboBox cbTTP = new JComboBox();
    JPanel pnHTP = new JPanel();
    JLabel lbHTP = new JLabel("Hiện trạng phòng");
    JComboBox cbHTP = new JComboBox();
    JPanel pnBtnSearch = new JPanel();

    JButton btnReset = new JButton("Làm mới");
    JButton btnSearch = new JButton("Tìm kiếm");
    JPanel pnEmp = new JPanel();

    LineBorder lineCB = new LineBorder(Color.white);
    ArrayList<JPanel> listPN = new ArrayList<>();
    JPanel pnTopCenter = new JPanel();
    JPanel pnContentCenter = new JPanel();
    JPanel pnContentCenterTop = new JPanel();
    JLabel lbContentCentertop = new JLabel("Danh sách phòng khách sạn");
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    MatteBorder matteBorderCBDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
    MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    MatteBorder borderTxtDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
    EmptyBorder emptyBorderTxt = new EmptyBorder(0, 7, 0, 7);
    EmptyBorder emptyBorderCB = new EmptyBorder(0, 7, 0, 0);
    JScrollPane scp = new JScrollPane();
    TablePhong tbP = new TablePhong();

    public DisplayRoom() {
        initComponents();
    }

    public void initComponents() {
        setLayout(new BorderLayout(5, 5));
        add(pnTop, BorderLayout.NORTH);
        add(pnContent, BorderLayout.CENTER);
        pnTop.setLayout(new BorderLayout(10, 10));
        pnTop.add(pnTopHeader, BorderLayout.NORTH);
        pnTop.add(pnTopCenter, BorderLayout.CENTER);

        pnTopHeader.setLayout(new BorderLayout());
        pnTopHeader.add(pnTopHeaderLeft, BorderLayout.WEST);
        pnTopHeader.add(pnTopHeaderRight, BorderLayout.CENTER);

        pnTopHeaderLeft.setLayout(new GridLayout(2, 1, 5, 5));
        pnTopHeaderLeft.add(lbTopHeaderLeftTop);
        pnTopHeaderLeft.add(lbTopHeaderLeftBottom);

        pnTopHeaderRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnTopHeaderRight.add(btnImportFile);
        pnTopHeaderRight.add(btnExportFile);
        pnTopHeaderRight.add(btnAdd);

        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);

        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);

        ImageIcon iconAdd = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/them.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnAdd.setIcon(iconAdd);
        btnAdd.setFocusPainted(false);
        btnAdd.setFont(sgUI13b);
        btnAdd.setBorderPainted(false);

        ImageIcon iconImport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnImportFile.setIcon(iconImport);
        btnImportFile.setFocusPainted(false);
        btnImportFile.setFont(sgUI13b);
        btnImportFile.setBorderPainted(false);

        ImageIcon iconExport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnExportFile.setIcon(iconExport);
        btnExportFile.setFocusPainted(false);
        btnExportFile.setFont(sgUI13b);
        btnExportFile.setBorderPainted(false);
        setMouse(btnAdd);
        setMouse(btnExportFile);
        setMouse(btnImportFile);

        //edit label 
        lbTopHeaderLeftTop.setFont(sgUI18b);
        lbTopHeaderLeftBottom.setFont(tNR13);
        lbTopHeaderLeftBottom.setBorder(new EmptyBorder(3, 0, 0, 0));
        actionAdd();
        actionExport();
        actionImport();

        // edit content
        pnTopCenter.setLayout(new GridLayout(2, 5, 10, 5));
        listPN.add(pnMaP);
        listPN.add(pnTenP);
        listPN.add(pnLoaiP);
        listPN.add(pnChiTietLoaiP);
        listPN.add(pnGiaP);
        listPN.add(pnEmp);
        listPN.add(pnTTP);
        listPN.add(pnHTP);
        listPN.add(pnBtnSearch);
        for (JPanel x : listPN) {
            pnTopCenter.add(x);
            x.setLayout(new BorderLayout(18, 10));
        }
        lbMaP.setFont(sgUI13b);
        lbTenP.setFont(sgUI13b);
        lbLoaiP.setFont(sgUI13b);
        lbChiTietLoaiP.setFont(sgUI13b);
        lbGiaP.setFont(sgUI13b);
        lbTTP.setFont(sgUI13b);
        lbHTP.setFont(sgUI13b);

        txtMaP.setFont(sgUI13);
        txtTenP.setFont(sgUI13);
        cbChiTietLoaiP.setFont(sgUI13);
        cbGiaP.setFont(sgUI13);
        cbTTP.setFont(sgUI13);
        cbHTP.setFont(sgUI13);
        cbLoaiP.setFont(sgUI13);

        String chiTietLoaiP[] = {"Chi tiết loại phòng", "Phòng đơn", "Phòng đôi", "Phòng gia đình"};
        String loaiP[] = {"Loại phòng", "VIP", "Thường"};
        String tTP[] = {"Trạng thái phòng", "Trống", "Đang được thuê", "Chưa dọn phòng", "Chưa có tiện ích"};
        String hTP[] = {"Hiện trạng", "Phòng mới", "Phòng cũ"};
        String giaP[] = {"Giá phòng", "Dưới 100000", "Từ 100000 đến 200000", "Từ 200000 đến 500000", "Từ 500000 đến 1000000", "Trên 1000000"};
        setDefaulComboBox(cbChiTietLoaiP, chiTietLoaiP);
        setDefaulComboBox(cbGiaP, giaP);
        setDefaulComboBox(cbTTP, tTP);
        setDefaulComboBox(cbHTP, hTP);
        setDefaulComboBox(cbLoaiP, loaiP);

        cbChiTietLoaiP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbHTP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbTTP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbGiaP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbLoaiP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        pnMaP.add(lbMaP, BorderLayout.WEST);
        pnMaP.add(txtMaP, BorderLayout.CENTER);
        pnTenP.add(lbTenP, BorderLayout.WEST);
        pnTenP.add(txtTenP, BorderLayout.CENTER);
        pnLoaiP.add(lbLoaiP, BorderLayout.WEST);
        pnLoaiP.add(cbLoaiP, BorderLayout.CENTER);
        pnChiTietLoaiP.add(lbChiTietLoaiP, BorderLayout.WEST);
        pnChiTietLoaiP.add(cbChiTietLoaiP, BorderLayout.CENTER);
        pnGiaP.add(lbGiaP, BorderLayout.WEST);
        pnGiaP.add(cbGiaP, BorderLayout.CENTER);
        pnTTP.add(lbTTP, BorderLayout.WEST);
        pnTTP.add(cbTTP, BorderLayout.CENTER);
        pnHTP.add(lbHTP, BorderLayout.WEST);
        pnHTP.add(cbHTP, BorderLayout.CENTER);
        pnBtnSearch.setLayout(new GridLayout(1, 2, 10, 10));
        pnBtnSearch.add(btnReset);
        pnBtnSearch.add(btnSearch);
        pnTopCenter.setBorder(new EmptyBorder(0, 5, 0, 5));
        setMouse(btnReset);
        setMouse(btnSearch);

        // edit content
        pnContent.setLayout(new BorderLayout(5, 5));
        pnContent.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnContent.add(pnContentCenter, BorderLayout.CENTER);

        pnContentCenter.setLayout(new BorderLayout());
        pnContentCenter.add(pnContentCenterTop, BorderLayout.NORTH);
        pnContentCenter.add(scp, BorderLayout.CENTER);

        pnContentCenterTop.setLayout(new BorderLayout());
        pnContentCenterTop.setBorder(new EmptyBorder(0, 0, 5, 0));
        pnContentCenterTop.add(lbContentCentertop, BorderLayout.WEST);
        lbContentCentertop.setFont(sgUI18b);

        scp.setBorder(BorderFactory.createEmptyBorder());
        scp.setViewportView(tbP);
        scp.setViewportBorder(null);
        tbP.renderTB();

        tbP.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tbP.getSelectedRowCount() > 0) {
                    tbP.setSelectionBackground(Color.decode("#F5F5F5"));
                    new FormChiTietPhong(1, tbP.getValueAt(tbP.getSelectedRow(), tbP.getColumnModel().getColumnIndex("Mã phòng")).toString(), DisplayRoom.this);
                }
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaP.getText().trim().length() == 0
                        && txtTenP.getText().trim().length() == 0
                        && cbLoaiP.getSelectedIndex() == 0
                        && cbChiTietLoaiP.getSelectedIndex() == 0
                        && cbGiaP.getSelectedIndex() == 0
                        && cbHTP.getSelectedIndex() == 0
                        && cbTTP.getSelectedIndex() == 0) {
                    new ThongBaoDialog("Vui lòng nhập thông tin muốn tìm", 1);
                    tbP.renderTB();
                } else {
                    ArrayList<PhongDTO> listAll = PhongBUS.getListP();
                    ArrayList<PhongDTO> listTmp = new ArrayList<>();
                    if (txtMaP.getText().trim().length() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getMaP().toUpperCase().contains(txtMaP.getText().trim().toUpperCase())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (txtTenP.getText().trim().length() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getTenP().toUpperCase().contains(txtTenP.getText().trim().toUpperCase())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbLoaiP.getSelectedIndex() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getLoaiP().equals(cbLoaiP.getSelectedItem().toString())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbChiTietLoaiP.getSelectedIndex() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getChiTietLoaiP().equals(cbChiTietLoaiP.getSelectedItem().toString())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }

                    if (cbTTP.getSelectedIndex() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getTinhTrang() == cbTTP.getSelectedIndex() - 1) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbHTP.getSelectedIndex() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getHienTrang() == cbHTP.getSelectedIndex() - 1) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbGiaP.getSelectedIndex() != 0) {
                        if (cbGiaP.getSelectedIndex() == 1) {
                            for (PhongDTO x : listAll) {
                                if (x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(1).toString().split("Dưới ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        } else if (cbGiaP.getSelectedIndex() == 5) {
                            for (PhongDTO x : listAll) {
                                if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(5).toString().split("Trên ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        } else {
                            for (PhongDTO x : listAll) {
                                if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[0])
                                        && x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }

                    if (listAll.isEmpty()) {
                        new ThongBaoDialog("Không tìm thấy phòng phù hợp", 1);
                        tbP.renderTB();
                        txtMaP.setText("");
                        txtTenP.setText("");
                        cbLoaiP.setSelectedIndex(0);
                        cbChiTietLoaiP.setSelectedIndex(0);
                        cbGiaP.setSelectedIndex(0);
                        cbHTP.setSelectedIndex(0);
                        cbTTP.setSelectedIndex(0);
                    } else {
                        tbP.renderTB(listAll);
                    }
                }
            }
        });

        actionReset();
    }

    public void setMouse(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#98befa"));
                } else {
                    x.setBackground(Color.decode("#D4D4D4"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#ebf2fc"));
                } else {
                    x.setBackground(Color.decode("#F0F0F0"));
                }
            }
        });
    }

    public void actionAdd() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPhongNew(DisplayRoom.this);
            }
        });
    }

    public void actionImport() {
        btnImportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void actionExport() {
        btnExportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void setDefaulComboBox(JComboBox x, String list[]) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (String y : list) {
            dcbm.addElement(y);
        }
        x.setModel(dcbm);
    }

    public void actionReset() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbChiTietLoaiP.setSelectedIndex(0);
                cbGiaP.setSelectedIndex(0);
                cbTTP.setSelectedIndex(0);
                cbHTP.setSelectedIndex(0);
                cbLoaiP.setSelectedIndex(0);
                txtMaP.setText("");
                txtTenP.setText("");
                tbP.renderTB();
            }
        });
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            this.LightDark = 0;
            setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnTopHeader.setBackground(Color.white);
            pnTopCenter.setBackground(Color.white);
            pnTopHeaderLeft.setBackground(Color.white);
            pnTopHeaderRight.setBackground(Color.white);
            pnContent.setBackground(Color.white);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, Color.white));
            btnAdd.setBackground(Color.decode("#ebf2fc"));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            for (JPanel x : listPN) {
                x.setBackground(Color.white);
            }

            cbChiTietLoaiP.setBorder(matteBorderCB);
            cbHTP.setBorder(matteBorderCB);
            cbTTP.setBorder(matteBorderCB);
            cbGiaP.setBorder(matteBorderCB);
            cbLoaiP.setBorder(matteBorderCB);
            cbGiaP.setBackground(Color.white);
            cbLoaiP.setBackground(Color.white);
            cbChiTietLoaiP.setBackground(Color.white);
            cbTTP.setBackground(Color.white);
            cbHTP.setBackground(Color.white);
            txtMaP.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txtTenP.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            scp.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.white));
            scp.getViewport().setBackground(Color.white);
            scp.setBackground(Color.white);
            pnContentCenterTop.setBackground(Color.white);
            tbP.getTableHeader().setBackground(Color.decode("#dee9fc"));
            lbTopHeaderLeftBottom.setForeground(Color.black);
            lbTopHeaderLeftTop.setForeground(Color.black);
            lbMaP.setForeground(Color.black);
            lbTenP.setForeground(Color.black);
            lbLoaiP.setForeground(Color.black);
            lbChiTietLoaiP.setForeground(Color.black);
            lbGiaP.setForeground(Color.black);
            lbTTP.setForeground(Color.black);
            lbHTP.setForeground(Color.black);
            lbContentCentertop.setForeground(Color.black);
            cbGiaP.setForeground(Color.black);
            cbLoaiP.setForeground(Color.black);
            cbChiTietLoaiP.setForeground(Color.black);
            cbTTP.setForeground(Color.black);
            cbHTP.setForeground(Color.black);
            txtMaP.setForeground(Color.black);
            txtTenP.setForeground(Color.black);
            txtMaP.setBackground(Color.decode("#FFFFFF"));
            txtTenP.setBackground(Color.decode("#FFFFFF"));
            tbP.getTableHeader().setForeground(Color.black);
        } else {
            this.LightDark = 1;
            lbTopHeaderLeftBottom.setForeground(Color.white);
            lbTopHeaderLeftTop.setForeground(Color.white);
            lbContentCentertop.setForeground(Color.white);
            Color black = Color.decode("#333333");
            setBackground(black);
            pnTop.setBackground(black);
            pnTopHeader.setBackground(black);
            pnTopCenter.setBackground(black);
            pnTopHeaderLeft.setBackground(black);
            pnTopHeaderRight.setBackground(black);
            pnContent.setBackground(black);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, black));
            btnAdd.setBackground(Color.decode("#F0F0F0"));
            btnImportFile.setBackground(Color.decode("#F0F0F0"));
            btnExportFile.setBackground(Color.decode("#F0F0F0"));
            btnReset.setBackground(Color.decode("#F0F0F0"));
            btnSearch.setBackground(Color.decode("#F0F0F0"));
            for (JPanel x : listPN) {
                x.setBackground(black);
            }
            lbMaP.setForeground(Color.white);
            lbTenP.setForeground(Color.white);
            lbLoaiP.setForeground(Color.white);
            lbChiTietLoaiP.setForeground(Color.white);
            lbGiaP.setForeground(Color.white);
            lbTTP.setForeground(Color.white);
            lbHTP.setForeground(Color.white);
            cbChiTietLoaiP.setBorder(matteBorderCBDark);
            cbHTP.setBorder(matteBorderCBDark);
            cbTTP.setBorder(matteBorderCBDark);
            cbGiaP.setBorder(matteBorderCBDark);
            cbLoaiP.setBorder(matteBorderCBDark);
            cbGiaP.setBackground(Color.decode("#474747"));
            cbLoaiP.setBackground(Color.decode("#474747"));
            cbChiTietLoaiP.setBackground(Color.decode("#474747"));
            cbTTP.setBackground(Color.decode("#474747"));
            cbHTP.setBackground(Color.decode("#474747"));
            txtMaP.setBackground(Color.decode("#474747"));
            txtTenP.setBackground(Color.decode("#474747"));
            txtMaP.setForeground(Color.white);
            txtTenP.setForeground(Color.white);
            cbGiaP.setForeground(Color.white);
            cbLoaiP.setForeground(Color.white);
            cbChiTietLoaiP.setForeground(Color.white);
            cbTTP.setForeground(Color.white);
            cbHTP.setForeground(Color.white);
            txtMaP.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txtTenP.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            scp.setVerticalScrollBar(new ScrollBar(Color.decode("#202020"), black));
            scp.getViewport().setBackground(black);
            scp.setBackground(black);
            pnContentCenterTop.setBackground(black);
            tbP.getTableHeader().setBackground(Color.decode("#202020"));
            tbP.getTableHeader().setForeground(Color.white);
        }
    }

    public TablePhong getTablePhong() {
        return tbP;
    }
}
