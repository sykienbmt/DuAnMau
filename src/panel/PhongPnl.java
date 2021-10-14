package panel;

import DAO.cbbHinhThucThueDAO;
import connect.DBConnection;
import controller.DichVuController;
import controller.KhacHangController;
import controller.PhieuThuePhongController;
import controller.PhongController;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.Phong;
import model.GiaPhong;
import swing.ScrollBar;
import swing.WrapLayout;

public class PhongPnl extends javax.swing.JPanel {
    private KhacHangController khacHangController;
    private PhieuThuePhongController phieuThuePhongController;
    private DichVuController dichVuController;
    private PhongController phongController;
    private cbbHinhThucThueDAO hinhThucThueDAO;
    private Button button;
    private boolean isCMND = false;
    int phongHienTai =UNDEFINED_CONDITION;
    
    public PhongPnl() {
        initComponents();
        init();
        jdNgayDat.setDateFormatString("dd-MM-yyyy HH:mm:ss");
        btnThue.setEnabled(false);
        btnThemDichVu.setEnabled(false);
        btnTruDichVu.setEnabled(false);
        txtTenKhach.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtHoChieu.setEnabled(false);
        txtSdt.setEnabled(false);
//        btnThemDichVu.setEnabled(true);
//        css table list dich vu
        spTableListDichVu.setVerticalScrollBar(new ScrollBar());
        spTableListDichVu.getVerticalScrollBar().setBackground(Color.WHITE);
        spTableListDichVu.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTableListDichVu.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//        //css table dich vu
        spTableDichVu.setVerticalScrollBar(new ScrollBar());
        spTableDichVu.getVerticalScrollBar().setBackground(Color.WHITE);
        spTableDichVu.getViewport().setBackground(Color.WHITE);
        spTableDichVu.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        
        
        
    }

    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());    
        panel.revalidate();
        panel.repaint(); 
    }
    
    public void viewBtnPhong(List<Phong> data) {
        for (Phong phong : data) {
            Button btnphong = new Button(phong.toString());           
            btnphong.setPreferredSize(new Dimension(95,60));
            btnphong.setFont(new java.awt.Font("Segoe UI Light", 1, 12));
            btnphong.setForeground(new java.awt.Color(255,255,255));
            if (phong.getTrangThai().equals("Đang sử dụng")) {
                btnphong.setBackground(new Color(255,51,0));
            }else if (phong.getTrangThai().equals("Phòng trống")) {
                btnphong.setBackground(new Color(0,204,204));
            }else {
                btnphong.setBackground(new Color(102,102,102));
            }
            
            btnphong.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    phongHienTai=phong.getId();
                    setcbb(phongHienTai);
                    button = btnphong;
                    if (phong.getTrangThai().equals("Đang sử dụng")) {
                        List<Object[]> data = phongController.layChiTietDichVu(phong.getId());
                        viewTableChiTietDichVu(data);
                        btnThemDichVu.setEnabled(true);
                        btnTruDichVu.setEnabled(true);
                        btnThue.setEnabled(false);
                        jdNgayRoi.setEnabled(true);
                        List<Object[]> ptp = phongController.loadDataPhong(phong.getId());
                        jdNgayDat.setDate((java.sql.Timestamp) ptp.get(0)[1]);
                        jdNgayRoi.setDate(null);
                        txtCMND.setText(ptp.get(0)[3].toString());
                        txtDiaChi.setText(ptp.get(0)[4].toString());
                        if(ptp.get(0)[5]==null){
                            txtHoChieu.setText("");
                        }else txtHoChieu.setText(ptp.get(0)[5].toString());
                        txtSdt.setText(ptp.get(0)[6].toString());
                        txtTenKhach.setText(ptp.get(0)[7].toString());
                        lbTenNhanVien.setText(ptp.get(0)[8].toString());
                        txtSoNguoi.setText(ptp.get(0)[9].toString());
                        cbbHinhThucThue.getModel().setSelectedItem(ptp.get(0)[11].toString());
//                        System.out.println(ptp.get(0)[11].toString());
                    }else{
                        btnThemDichVu.setEnabled(false);
                        btnTruDichVu.setEnabled(false);
                        jdNgayRoi.setEnabled(false);
                        viewTableChiTietDichVu(null);
                        btnThue.setEnabled(true);
                        jdNgayDat.setDate(null);
                        jdNgayRoi.setDate(null);
                        txtCMND.setText("");
                        txtDiaChi.setText("");
                        txtHoChieu.setText("");
                        txtSdt.setText("");
                        txtTenKhach.setText("");
                        lbTenNhanVien.setText("");
                        txtSoNguoi.setText("");
                    }
                    if(phong.getTrangThai().equals("Bảo trì")){
                        btnThue.setEnabled(false);
                        jdNgayRoi.setEnabled(false);
                        viewTableChiTietDichVu(null);
                        btnThemDichVu.setEnabled(false);
                        btnTruDichVu.setEnabled(false);
                    }
                }                    
            });
            panel.add(btnphong);
        }
    }
    
    public void setcbb(int idphong){
        List<Object[]> idLoaiPhong = phongController.getIdHinhThucThue(idphong);
        List<Object[]> data2 = phongController.getHinhThuc((int)idLoaiPhong.get(0)[0]);
        GiaPhong[] giaphongs = new GiaPhong[]{
            new GiaPhong("Giờ - " + data2.get(0)[0].toString(),"Giờ-"+(Double)data2.get(0)[0]),
            new GiaPhong("Ngày - " + data2.get(0)[1].toString() ,"Ngày-" +(Double)data2.get(0)[1]),
            new GiaPhong("Tháng - " + data2.get(0)[2].toString(),"Tháng-" +(Double)data2.get(0)[2]),
            new GiaPhong("Quý - " + data2.get(0)[3].toString(),"Quý-" +(Double)data2.get(0)[3])
        };
//                        String[] giaPhong = { "Giờ - " + data2.get(0)[0].toString(), "Ngày - " + data2.get(0)[1].toString(), "Tháng - " + data2.get(0)[2].toString(), "Quý - " + data2.get(0)[3].toString() };

//                        String[] gia = ["Giờ - " + data2.get(0)[0].toString()];
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbHinhThucThue.getModel();
        cbbHinhThucThue.removeAllItems();

        for (int i=0;i<=giaphongs.length-1;i++) {
            cbbModel.addElement(giaphongs[i]);
        }
    }

    public void viewTableDichVu(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();      
        for (int i = tblDichVu.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }      
        for (Object[] objects : data) {
            model.addRow(objects);
        }
    }
    
    public void viewTableChiTietDichVu(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblListDichVu.getModel();           
        if(data == null) {
            for (int i = tblListDichVu.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = tblListDichVu.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }
        }
    }
    
    public void setController (DichVuController dichVuController) {
        this.dichVuController = dichVuController;
    }
    
    public void setController (PhongController phongController) {
        this.phongController = phongController;
    }
    
    public void setController (PhieuThuePhongController phieuThuePhongController) {
        this.phieuThuePhongController = phieuThuePhongController;
    }
    
    public void setController (KhacHangController khacHangController) {
        this.khacHangController = khacHangController;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jdNgayDat = new com.toedter.calendar.JDateChooser();
        jdNgayRoi = new com.toedter.calendar.JDateChooser();
        btnThue = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbbHinhThucThue = new javax.swing.JComboBox<>();
        lbTenNhanVien = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtSoNguoi = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTenKhach = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtHoChieu = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtTienPhong = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTienDichVu = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienTraLai = new javax.swing.JTextField();
        spTableListDichVu = new javax.swing.JScrollPane();
        tblListDichVu = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        spTableDichVu = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnChuyen = new javax.swing.JButton();
        btnTruDichVu = new javax.swing.JButton();
        btnThemDichVu = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        btnThanhToan = new javax.swing.JButton();
        btnKetToan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtTimDichVu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 248, 248));
        setPreferredSize(new java.awt.Dimension(1200, 750));
        setRequestFocusEnabled(false);

        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("DANH SÁCH PHÒNG");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đặt phòng");

        jLabel12.setText("Ngày đặt");

        jLabel13.setText("Ngày rời");

        btnThue.setText("Mở phòng");
        btnThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThueActionPerformed(evt);
            }
        });

        jLabel15.setText("CMND");

        txtCMND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCMNDKeyReleased(evt);
            }
        });

        jLabel18.setText("Nhân viên");

        jLabel19.setText("Thuê: ");

        jLabel26.setText("Số khách");

        jLabel27.setText("Họ tên");

        jLabel28.setText("SDT");

        jLabel29.setText("Địa chỉ");

        jLabel30.setText("Hộ Chiếu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdNgayRoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbHinhThucThue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdNgayRoi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHoChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbHinhThucThue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnThue, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel21.setText("Giá phòng: ");

        txtTienPhong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienPhong.setText("0");

        jLabel22.setText("Giá dịch vụ: ");

        txtTienDichVu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienDichVu.setText("0");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Thành Tiền:");

        txtTongTien.setBackground(new java.awt.Color(255, 255, 204));
        txtTongTien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTongTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTongTien.setText("0");

        jLabel24.setText("Khách đưa:");

        jLabel25.setText("Trả lại: ");

        txtTienKhachDua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienKhachDua.setText("0");

        txtTienTraLai.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienTraLai.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachDua)
                            .addComponent(txtTienTraLai)))
                    .addComponent(txtTongTien))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTienDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap())
        );

        tblListDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idDichVu", "Dịch vụ", "ĐVT", "Ngày sử dụng", "SL", "Thành tiền"
            }
        ));
        spTableListDichVu.setViewportView(tblListDichVu);
        if (tblListDichVu.getColumnModel().getColumnCount() > 0) {
            tblListDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblListDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblListDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
            tblListDichVu.getColumnModel().getColumn(2).setMinWidth(50);
            tblListDichVu.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblListDichVu.getColumnModel().getColumn(2).setMaxWidth(50);
            tblListDichVu.getColumnModel().getColumn(4).setMinWidth(45);
            tblListDichVu.getColumnModel().getColumn(4).setPreferredWidth(45);
            tblListDichVu.getColumnModel().getColumn(4).setMaxWidth(45);
        }

        jButton1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setText("Bảo trì");

        jButton2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setText("Phòng trống");

        jButton3.setBackground(new java.awt.Color(255, 51, 0));

        jLabel4.setText("Sử dụng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jButton1)))
                    .addComponent(jButton2)
                    .addComponent(jLabel3)
                    .addComponent(jButton3))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Dịch vụ", "ĐVT", "Giá"
            }
        ));
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        spTableDichVu.setViewportView(tblDichVu);
        if (tblDichVu.getColumnModel().getColumnCount() > 0) {
            tblDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChuyen.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btnChuyen.setText("Chuyển");
        jPanel3.add(btnChuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 60, 58));

        btnTruDichVu.setText("-");
        jPanel3.add(btnTruDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 60, 30));

        btnThemDichVu.setText("+");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });
        jPanel3.add(btnThemDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 60, 30));

        jLabel9.setText("Số lượng");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        spnSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        jPanel3.add(spnSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 60, -1));

        btnThanhToan.setText("Pay");
        jPanel3.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 60, 50));

        btnKetToan.setText("End");
        btnKetToan.setToolTipText("");
        btnKetToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetToanActionPerformed(evt);
            }
        });
        jPanel3.add(btnKetToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 60, 50));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Danh mục dịch vụ");

        txtTimDichVu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimDichVuKeyReleased(evt);
            }
        });

        jLabel8.setText("Tìm dịch vụ: ");

        btnRefresh.setText("RS");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spTableListDichVu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spTableDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(16, 16, 16)
                            .addComponent(spTableDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spTableListDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThueActionPerformed
        Timestamp ngayDat = null;
        Date date = new Date();         
        ngayDat=new Timestamp(date.getTime());       
        String tenKhach = txtTenKhach.getText();
        String hoChieu ="";
        if(!txtHoChieu.getText().equals("")){
            hoChieu=txtHoChieu.getText();
        }
        String diaChi = txtDiaChi.getText();
        String sdt = txtSdt.getText();
        String cmnd = txtCMND.getText();
        Integer soNguoi =Integer.parseInt(txtSoNguoi.getText());       
        GiaPhong myCbb = (GiaPhong) cbbHinhThucThue.getSelectedItem();
        String hinhThucThue = myCbb.tenHinhThuc();
        
        phongController.updateTinhTrangPhong(phongHienTai);
        if (!isCMND) {
            khacHangController.insert(0,cmnd, tenKhach, diaChi, hoChieu, sdt);
        }      
        phieuThuePhongController.insert(0, phongHienTai, 1, cmnd, soNguoi, ngayDat, null, hinhThucThue);
        button.setBackground(new Color(255,51,0));
    }//GEN-LAST:event_btnThueActionPerformed

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        int clickThem = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn thêm không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
        if (clickThem == JOptionPane.YES_OPTION) {
            int click = tblDichVu.getSelectedRow();
            List<Object[]> list = phongController.checkHoaDonPhong(phongHienTai);
            if(!list.get(0)[0].toString().equals("1")){
                phongController.taoHoaDonDichVu(phongHienTai);
            }
            List<Object[]> idPhong = phongController.layIdHoaDonDichVu(phongHienTai);
            int idHoaDon = (int) idPhong.get(0)[0];
            phongController.themChiTietDichVu(idHoaDon,(int) tblDichVu.getValueAt(click, 0), (int) spnSoLuong.getValue());
            List<Object[]> data = phongController.layChiTietDichVu(phongHienTai);
            viewTableChiTietDichVu(data);
        }
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        btnThemDichVu.setEnabled(true);
        btnTruDichVu.setEnabled(true);
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void txtTimDichVuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimDichVuKeyReleased
        System.out.println("Tìm dịch vụ");
    }//GEN-LAST:event_txtTimDichVuKeyReleased

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        System.out.println("Làm mới ds dịch vụ");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtCMNDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCMNDKeyReleased
        String CMND = txtCMND.getText();
        try {
            String sql_getdata = "select tenKhach,diaChi,hoChieu,soDT from KhachHang where soCMND = '"+CMND+"'";
            ResultSet rs = DBConnection.executeQuery(sql_getdata);
            if (rs.next()) {
                isCMND = true;
                txtTenKhach.setText(rs.getString("tenKhach"));
                txtDiaChi.setText(rs.getString("diaChi"));
                txtHoChieu.setText(rs.getString("hoChieu"));
                txtSdt.setText(rs.getString("soDt"));
                txtTenKhach.setEnabled(false);
                txtDiaChi.setEnabled(false);
                txtHoChieu.setEnabled(false);
                txtSdt.setEnabled(false);
            }else {
                txtTenKhach.setEnabled(true);
                txtDiaChi.setEnabled(true);
                txtHoChieu.setEnabled(true);
                txtSdt.setEnabled(true);
                txtTenKhach.setText("");
                txtDiaChi.setText("");
                txtHoChieu.setText("");
                txtSdt.setText("");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtCMNDKeyReleased

    private void btnKetToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetToanActionPerformed
        List<Object[]> data = phongController.loadDataPhong(phongHienTai);
        String giaPhongString=data.get(0)[11].toString();
        int num = giaPhongString.indexOf("-");
        String hinhThucThue = giaPhongString.substring(0,num);
        Double giaThue = Double.valueOf(giaPhongString.substring(num+1,giaPhongString.length()));
        System.out.println("-HÌnh thức thuê: " +hinhThucThue+"-  Giá: "+giaThue);
        
        Date now = new Date();
        Timestamp ngayDat = (Timestamp) data.get(0)[1];
        Date ngayDatDate=(Date) ngayDat;
        System.out.println(ngayDatDate);
        long thoiGian = now.getTime()-ngayDatDate.getTime();
        System.out.println("Khoảng cách là :" +thoiGian);
        
        Double tienPhong = 0.0;
        long diffHours = thoiGian / (60 * 60 * 1000);
        if(thoiGian % (60 * 60 * 1000)!=0){
            diffHours+=1;
        }
        long diffDays = thoiGian / (24 * 60 * 60 * 1000);
        if(thoiGian % (24 * 60 * 60 * 1000)!=0){
            diffDays+=1;
        }
        long diffMonths= thoiGian/ (30 * 24 * 60 * 60 * 1000);
        long diffQuys= thoiGian/ (3 * 30 * 24 * 60 * 60 * 1000);

        System.out.print(diffDays + " days, ");
        System.out.print(diffHours + " hours, ");
        System.out.print(diffMonths + " Month, ");
        System.out.print(diffQuys + " Quys, ");
        if(hinhThucThue.equalsIgnoreCase("Giờ")){
            if(diffHours<=1){
                tienPhong=giaThue;
            }else{
                tienPhong=giaThue+(diffHours-1)*(giaThue*0.2);
            }
        }else if(hinhThucThue.equals("Ngày")){
            tienPhong=diffDays*giaThue;
        }else if(hinhThucThue.equals("Tháng")){
            tienPhong=diffMonths*giaThue;
        }else if(hinhThucThue.equals("Quý")){
            tienPhong=diffQuys*giaThue;
        }
        
        txtTienPhong.setText(tienPhong.toString());
//        System.out.println("Giá phòng là: "+tienPhong);
        
        Double tienDichVu = 0.0;
        
        for(int i=0;i<=tblListDichVu.getRowCount()-1;i++){
            System.out.println(tblListDichVu.getValueAt(i, 5));
            tienDichVu+= Double.parseDouble(tblListDichVu.getValueAt(i, 5).toString());
        }
        System.out.println("Tiền dịch vụ là: " +tienDichVu);
        txtTienDichVu.setText(tienDichVu.toString());
    }//GEN-LAST:event_btnKetToanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyen;
    private javax.swing.JButton btnKetToan;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnThue;
    private javax.swing.JButton btnTruDichVu;
    private javax.swing.JComboBox<String> cbbHinhThucThue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdNgayDat;
    private com.toedter.calendar.JDateChooser jdNgayRoi;
    private javax.swing.JLabel lbTenNhanVien;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane spTableDichVu;
    private javax.swing.JScrollPane spTableListDichVu;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblListDichVu;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoChieu;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSoNguoi;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JTextField txtTienDichVu;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienPhong;
    private javax.swing.JTextField txtTienTraLai;
    private javax.swing.JTextField txtTimDichVu;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
