package panel;

import DAO.DanhMucDAO;
import DAO.PhongDAO;
import DAO.cbbHinhThucThueDAO;
import helper.DBConnection;
import controller.DichVuController;
import controller.HoaDonController;
import controller.KhacHangController;
import controller.PhieuThuePhongController;
import controller.PhongController;
import dialog.DoiPhongDialog;
import dialog.ThanhToan;
import helper.DataValidate;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import static javax.swing.JComponent.UNDEFINED_CONDITION;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.DanhMuc;
import model.Phong;
import model.GiaPhong;
import model.HoaDon;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import swing.ScrollBar;
import swing.WrapLayout;

public class PhongPnl extends javax.swing.JPanel {
    private KhacHangController khacHangController;
    private PhieuThuePhongController phieuThuePhongController;
    private HoaDonController hoaDonController;
    private DichVuController dichVuController;
    private PhongController phongController;
    DanhMucDAO danhMucDAO = new DanhMucDAO();  
    PhongDAO phongDAO = new PhongDAO();
    private cbbHinhThucThueDAO hinhThucThueDAO;
    private Button button;
    private boolean isCMND = false;
    int phongHienTai =UNDEFINED_CONDITION;
    int phongCanDoi =UNDEFINED_CONDITION;
    int idLoaiPhongCanDoi =UNDEFINED_CONDITION;
    int idLoaiPhongMuonDoi =UNDEFINED_CONDITION;
    boolean click = false;
    Double tongTien=0.0;
    Double tienPhong = 0.0;
    Double tienDichVu = 0.0;
    ThanhToan tt = null;
    private DoiPhongDialog doiPhongDialog;
    
    public PhongPnl() {
        initComponents();
        init();
        viewListDanhMuc();
        placeholderDichVu();
        jdNgayDat.setDateFormatString("dd-MM-yyyy HH:mm:ss");
        btnMoPhong.setEnabled(false);
        btnThemDichVu.setEnabled(false);
        btnKetToan.setEnabled(false);
        btnThanhToan.setEnabled(false);
        txtTenKhach.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtHoChieu.setEnabled(false);
        txtSdt.setEnabled(false);
        txtTenPhong.setEnabled(false);
        btnKetToan.setEnabled(false);
        btnThanhToan.setEnabled(false);
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
        //css table Dịch vụ
        tblDichVu.setRowHeight(30);
        tblListDichVu.setRowHeight(25);
    }

    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());    
        panel.revalidate();
        panel.repaint();
    }   
    
    public void viewListDanhMuc() {
        DefaultListModel<DanhMuc> listDanhMuc = new DefaultListModel<DanhMuc>();
        List<Object[]> data = danhMucDAO.loadAllDichVu();
        viewTableDichVu(data);
        for (DanhMuc danhMucs : danhMucDAO.getAll()) {
            listDanhMuc.addElement(danhMucs);
            jlDanhMuc.addMouseListener(new MouseAdapter(){
            @Override
                public void mouseClicked(MouseEvent e) {
                    DanhMuc dm = jlDanhMuc.getSelectedValue();
                    if(dm.getId() == 1) {
                        List<Object[]> data = dichVuController.loadAllDichVu();
                        viewTableDichVu(data);
                    }else {
                        List<Object[]> data = dichVuController.loadDichVu(dm.getId());
                        viewTableDichVu(data);
                    }
                }
            });
        }
        jlDanhMuc.setModel(listDanhMuc);      
    }
    
    public void viewTableDichVu(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();  
        if (data == null) {
            for (int i = tblDichVu.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = tblDichVu.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }
        }
    }
    
    public void viewBtnPhong(List<Phong> data) {
        setNullValue();
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
                    phongHienTai = phong.getId();
                    setcbb(phongHienTai);
                    button = btnphong;
                    
                    if (phong.getTrangThai().equals("Đang sử dụng")) {
                        setThongTinPhong(phong.getId());
                    }else{
                        setNullValue();
                    }
                    if(phong.getTrangThai().equals("Bảo trì")){
                        btnMoPhong.setEnabled(false);
                        jdNgayRoi.setEnabled(false);
                        viewTableChiTietDichVu(null);
                        btnThemDichVu.setEnabled(false);
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
        };
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbHinhThucThue.getModel();
        cbbHinhThucThue.removeAllItems();

        for (int i=0;i<=giaphongs.length-1;i++) {
            cbbModel.addElement(giaphongs[i]);
        }
    }
    
    public void setThongTinPhong(int idPhong){
        List<Object[]> data = phongController.layChiTietDichVu(idPhong);
        viewTableChiTietDichVu(data);
        btnMoPhong.setEnabled(false);
        btnThemDichVu.setEnabled(true);
        btnKetToan.setEnabled(true);
        btnThanhToan.setEnabled(true);
        jdNgayRoi.setEnabled(true);
        List<Object[]> ptp = phongController.loadDataPhong(idPhong);
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
        txtTenPhong.setText(ptp.get(0)[12].toString());
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
    
    public void XuatHoaDon(int idHoaDon){
        try {            
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src/panel/HoaDon.jrxml");
            
            map.put("idHoaDon", idHoaDon);
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Java;", "sa", "123456");
            JasperPrint p = JasperFillManager.fillReport(report,  map, connection );
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }   
    
    public void placeholderDichVu() {
        txtTimDichVu.setText("Tìm dịch vụ");
        txtTimDichVu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimDichVu.getText().equals("Tìm dịch vụ") || txtTimDichVu.getText().equals(txtTimDichVu.getText())) {
                    txtTimDichVu.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimDichVu.getText().isEmpty()) {
                    txtTimDichVu.setText("Tìm dịch vụ");
                }
            }
        });
    }
    
    public void reLoadPhong(){
        panel.removeAll();
        phongController.loadListBtnPhong();
        panel.revalidate();
        panel.repaint();  
    }
    
    public void getPhongDangDung() {
        List<Object[]> data = phongController.getPhongDangDung();
        DefaultTableModel model = (DefaultTableModel) doiPhongDialog.tblPhongCanDoi.getModel();  
        if (data == null) {
            for (int i = doiPhongDialog.tblPhongCanDoi.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = doiPhongDialog.tblPhongCanDoi.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        btnThemDichVu = new swing.PhongButton();
        btnKetToan = new swing.PhongButton();
        btnThanhToan = new swing.PhongButton();
        btnDoiPhong = new swing.PhongButton();
        panelCoverDialog2 = new component.PanelCoverDialog();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txtTenPhong = new swing.TextInput();
        jdNgayDat = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtHoChieu = new swing.TextInput();
        jLabel13 = new javax.swing.JLabel();
        jdNgayRoi = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        txtSoNguoi = new swing.TextInput();
        jLabel28 = new javax.swing.JLabel();
        txtDiaChi = new swing.TextInput();
        jLabel29 = new javax.swing.JLabel();
        txtTenKhach = new swing.TextInput();
        jLabel30 = new javax.swing.JLabel();
        txtSdt = new swing.TextInput();
        jLabel19 = new javax.swing.JLabel();
        cbbHinhThucThue = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        lbTenNhanVien = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCMND = new swing.TextInput();
        btnMoPhong = new swing.PhongButton();
        jPanel1 = new javax.swing.JPanel();
        panelCoverDialog1 = new component.PanelCoverDialog();
        jLabel21 = new javax.swing.JLabel();
        txtTienPhong = new swing.TextInput();
        txtTienKhachDua = new swing.TextInput();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtTienDichVu = new swing.TextInput();
        jLabel23 = new javax.swing.JLabel();
        txtTongTien = new swing.TextInput();
        jPanel2 = new javax.swing.JPanel();
        panelCoverDialog3 = new component.PanelCoverDialog();
        jLabel20 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtTimDichVu = new swing.TextInput();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlDanhMuc = new javax.swing.JList<>();

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

        tblListDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        tblDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        tblDichVu.setFocusable(false);
        tblDichVu.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblDichVu.setShowVerticalLines(false);
        tblDichVu.getTableHeader().setReorderingAllowed(false);
        spTableDichVu.setViewportView(tblDichVu);
        if (tblDichVu.getColumnModel().getColumnCount() > 0) {
            tblDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel3.setBackground(new java.awt.Color(246, 246, 246));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Số lượng");

        spnSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        btnThemDichVu.setText("+");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        btnKetToan.setText("Trả phòng");
        btnKetToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetToanActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnDoiPhong.setText("Đổi phòng");
        btnDoiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKetToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btnThemDichVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(btnDoiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnDoiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKetToan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đặt phòng");
        panelCoverDialog2.add(jLabel5);
        jLabel5.setBounds(0, 7, 507, 20);
        panelCoverDialog2.add(jSeparator1);
        jSeparator1.setBounds(10, 30, 490, 10);

        jLabel15.setText("CMND");
        panelCoverDialog2.add(jLabel15);
        jLabel15.setBounds(10, 50, 51, 30);
        panelCoverDialog2.add(txtTenPhong);
        txtTenPhong.setBounds(310, 50, 150, 29);

        jdNgayDat.setBackground(new java.awt.Color(213, 245, 227));
        panelCoverDialog2.add(jdNgayDat);
        jdNgayDat.setBounds(310, 90, 150, 30);

        jLabel12.setText("Phòng");
        panelCoverDialog2.add(jLabel12);
        jLabel12.setBounds(250, 50, 51, 30);

        jLabel26.setText("Số khách");
        panelCoverDialog2.add(jLabel26);
        jLabel26.setBounds(10, 90, 51, 30);
        panelCoverDialog2.add(txtHoChieu);
        txtHoChieu.setBounds(310, 210, 150, 29);

        jLabel13.setText("Ngày rời");
        panelCoverDialog2.add(jLabel13);
        jLabel13.setBounds(250, 130, 51, 30);

        jdNgayRoi.setBackground(new java.awt.Color(213, 245, 227));
        panelCoverDialog2.add(jdNgayRoi);
        jdNgayRoi.setBounds(310, 130, 150, 30);

        jLabel27.setText("Họ tên");
        panelCoverDialog2.add(jLabel27);
        jLabel27.setBounds(10, 130, 51, 30);
        panelCoverDialog2.add(txtSoNguoi);
        txtSoNguoi.setBounds(70, 90, 150, 29);

        jLabel28.setText("SDT");
        panelCoverDialog2.add(jLabel28);
        jLabel28.setBounds(250, 170, 51, 30);
        panelCoverDialog2.add(txtDiaChi);
        txtDiaChi.setBounds(70, 170, 150, 29);

        jLabel29.setText("Địa chỉ");
        panelCoverDialog2.add(jLabel29);
        jLabel29.setBounds(10, 170, 51, 30);
        panelCoverDialog2.add(txtTenKhach);
        txtTenKhach.setBounds(70, 130, 150, 29);

        jLabel30.setText("Hộ Chiếu");
        panelCoverDialog2.add(jLabel30);
        jLabel30.setBounds(250, 210, 51, 30);
        panelCoverDialog2.add(txtSdt);
        txtSdt.setBounds(310, 170, 150, 29);

        jLabel19.setText("Thuê");
        panelCoverDialog2.add(jLabel19);
        jLabel19.setBounds(10, 210, 51, 30);

        cbbHinhThucThue.setBackground(new java.awt.Color(213, 245, 227));
        panelCoverDialog2.add(cbbHinhThucThue);
        cbbHinhThucThue.setBounds(70, 210, 150, 30);

        jLabel18.setText("Nhân viên");
        panelCoverDialog2.add(jLabel18);
        jLabel18.setBounds(10, 270, 51, 30);
        panelCoverDialog2.add(lbTenNhanVien);
        lbTenNhanVien.setBounds(70, 270, 150, 30);

        jLabel14.setText("Ngày đặt");
        panelCoverDialog2.add(jLabel14);
        jLabel14.setBounds(250, 90, 51, 30);

        txtCMND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCMNDKeyReleased(evt);
            }
        });
        panelCoverDialog2.add(txtCMND);
        txtCMND.setBounds(70, 50, 150, 29);

        btnMoPhong.setText("Mở phòng");
        btnMoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoPhongActionPerformed(evt);
            }
        });
        panelCoverDialog2.add(btnMoPhong);
        btnMoPhong.setBounds(360, 255, 90, 40);

        jLabel21.setText("Giá phòng");
        panelCoverDialog1.add(jLabel21);
        jLabel21.setBounds(10, 10, 50, 30);

        txtTienPhong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienPhong.setText("0");
        panelCoverDialog1.add(txtTienPhong);
        txtTienPhong.setBounds(80, 10, 150, 29);

        txtTienKhachDua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienKhachDua.setText("0");
        panelCoverDialog1.add(txtTienKhachDua);
        txtTienKhachDua.setBounds(300, 10, 150, 29);

        jLabel24.setText("Phụ thu");
        panelCoverDialog1.add(jLabel24);
        jLabel24.setBounds(250, 10, 50, 30);

        jLabel22.setText("Giá dịch vụ");
        panelCoverDialog1.add(jLabel22);
        jLabel22.setBounds(10, 70, 59, 14);

        txtTienDichVu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienDichVu.setText("0");
        panelCoverDialog1.add(txtTienDichVu);
        txtTienDichVu.setBounds(80, 60, 150, 29);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Thành tiền");
        panelCoverDialog1.add(jLabel23);
        jLabel23.setBounds(160, 100, 71, 30);

        txtTongTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTongTien.setText("0");
        panelCoverDialog1.add(txtTongTien);
        txtTongTien.setBounds(260, 100, 190, 50);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Danh mục dịch vụ");
        panelCoverDialog3.add(jLabel20);
        jLabel20.setBounds(10, 0, 280, 30);
        panelCoverDialog3.add(jSeparator2);
        jSeparator2.setBounds(10, 30, 280, 10);

        txtTimDichVu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimDichVuKeyReleased(evt);
            }
        });
        panelCoverDialog3.add(txtTimDichVu);
        txtTimDichVu.setBounds(20, 40, 260, 29);

        jScrollPane2.setViewportView(jlDanhMuc);

        panelCoverDialog3.add(jScrollPane2);
        jScrollPane2.setBounds(20, 80, 260, 220);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTableListDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(panelCoverDialog2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTableDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelCoverDialog2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spTableListDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spTableDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents
        
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

    private void txtTimDichVuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimDichVuKeyReleased
        String tenDichVu = txtTimDichVu.getText();
        List<Object[]> data = dichVuController.searchDichVu(tenDichVu);
        viewTableDichVu(data);
    }//GEN-LAST:event_txtTimDichVuKeyReleased

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        int clickDv = tblDichVu.getSelectedRow();
        if (clickDv == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dịch vụ cần thêm !","Thông báo", JOptionPane.ERROR_MESSAGE);
        } else { 
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
        }       
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void btnKetToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetToanActionPerformed
        List<Object[]> data = phongController.loadDataPhong(phongHienTai);
        click=true;
        String giaPhongString=data.get(0)[11].toString();
        int num = giaPhongString.indexOf("-");
        String hinhThucThue = giaPhongString.substring(0,num);
        Double giaThue = Double.valueOf(giaPhongString.substring(num+1,giaPhongString.length()));
        
        Date now = new Date();
        Timestamp ngayDat = (Timestamp) data.get(0)[1];
        Date ngayDatDate=(Date) ngayDat;
        long thoiGian = now.getTime()-ngayDatDate.getTime();
        
        long diffHours = thoiGian / (60 * 60 * 1000);
        if(thoiGian % (60 * 60 * 1000)!=0){
            diffHours+=1;
        }
        long diffDays = thoiGian / (24 * 60 * 60 * 1000);
        if(thoiGian % (24 * 60 * 60 * 1000)!=0){
            diffDays+=1;
        }

        if(hinhThucThue.equalsIgnoreCase("Giờ")){
            if(diffHours<=1){
                tienPhong=giaThue;
            }else{
                tienPhong=giaThue+(diffHours-1)*(giaThue*0.2);
            }
        }else if(hinhThucThue.equals("Ngày")){
            tienPhong=diffDays*giaThue;
        }

        txtTienPhong.setText(tienPhong.toString());
        
        for(int i=0;i<=tblListDichVu.getRowCount()-1;i++){
            System.out.println(tblListDichVu.getValueAt(i, 5));
            tienDichVu+= Double.parseDouble(tblListDichVu.getValueAt(i, 5).toString());
        }
        
        //update lại tiền dịch vụ
        List <Object[]> data2 = phongController.layIdHoaDonDichVu(phongHienTai);
        phongController.updateTienHoaDonDV(tienDichVu,(Integer.valueOf(data2.get(0)[0].toString())));
        txtTienDichVu.setText(tienDichVu.toString());
        tongTien = tienDichVu+tienPhong;
        txtTongTien.setText(tongTien.toString());
    }//GEN-LAST:event_btnKetToanActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if(click){
            tt = new ThanhToan(null,true);
            tt.jTextField1.setEnabled(false);
            tt.jTextField3.setEnabled(false);
            tt.jTextField1.setText(tongTien.toString());
            
            tt.jTextField2.addKeyListener(new KeyAdapter(){
                @Override
                public void keyReleased(KeyEvent e) {
                    Double traLai  = Double.parseDouble(tt.jTextField2.getText())-tongTien;
                    tt.jTextField3.setText(traLai.toString());                    
                }
            });
            
            tt.btnThanhToanDone.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("Thanh toán");
                    List<Object[]> data2 = phongController.getIdPhieuThue(phongHienTai);
                    List<Object[]> data3 = phongController.layIdHoaDonDichVu(phongHienTai);
                    
                    HoaDon hd = new HoaDon(0,(int) data2.get(0)[0],(int) data3.get(0)[0],tienPhong,tienDichVu);
                    System.out.println(hd.getIdPhieuThue()+"   "+hd.getIdHoaDonDichVu()+"   "+tienPhong+"    "+tienDichVu);
//                    HoaDonDAO hdDAO = new HoaDonDAO();
                    hoaDonController.insert(hd);
                    List<Object[]> ttHoaDon = phongController.getIdHoaDon((int) data2.get(0)[0],(int) data3.get(0)[0]);
                    System.out.println((int)ttHoaDon.get(0)[0]);
                    XuatHoaDon((int)ttHoaDon.get(0)[0]);
                    
                    phongController.offPhieuThuePhong((int)data2.get(0)[0]);
                    phongController.updateTinhTrangPhong("Phòng trống", phongHienTai);
                    phongController.offHoaDonDichVu(phongHienTai);
                    tongTien=0.0;
                    tienPhong = 0.0;
                    tienDichVu = 0.0;
                    reLoadPhong();
                    setNullValue();
                    phongHienTai=UNDEFINED_CONDITION;
                    tt.setVisible(false);
                }});
            
            tt.btnTTKhongIn.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("Thanh toán");
                    List<Object[]> data2 = phongController.getIdPhieuThue(phongHienTai);
                    List<Object[]> data3 = phongController.layIdHoaDonDichVu(phongHienTai);
                    
                    HoaDon hd = new HoaDon(0,(int) data2.get(0)[0],(int) data3.get(0)[0],tienPhong,tienDichVu);
                    System.out.println(hd.getIdPhieuThue()+"   "+hd.getIdHoaDonDichVu()+"   "+tienPhong+"    "+tienDichVu);
                    hoaDonController.insert(hd);
                    List<Object[]> ttHoaDon = phongController.getIdHoaDon((int) data2.get(0)[0],(int) data3.get(0)[0]);                
                    phongController.offPhieuThuePhong((int)data2.get(0)[0]);
                    phongController.updateTinhTrangPhong("Phòng trống", phongHienTai);
                    phongController.offHoaDonDichVu(phongHienTai);
                    tongTien=0.0;
                    tienPhong = 0.0;
                    tienDichVu = 0.0;
                    reLoadPhong();
                    setNullValue();
                    phongHienTai=UNDEFINED_CONDITION;
                    tt.setVisible(false);
                }});
            tt.setLocationRelativeTo(null);
            tt.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Trả phòng trước đi 3, đm ns hoài !");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed
     
    private void btnMoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoPhongActionPerformed
        Timestamp ngayDat = null;
        Date date = new Date();         
        ngayDat=new Timestamp(date.getTime());
        String tenKhach = txtTenKhach.getText();
        String hoChieu =" ";
        if(!txtHoChieu.getText().equals("")){
            hoChieu=txtHoChieu.getText();
        }
        String diaChi = txtDiaChi.getText();
        String sdt = txtSdt.getText();
        String cmnd = txtCMND.getText();
        Integer soNguoi =Integer.parseInt(txtSoNguoi.getText());  
        GiaPhong myCbb = (GiaPhong) cbbHinhThucThue.getSelectedItem();
        String hinhThucThue = myCbb.tenHinhThuc();
        
        if (isCMND==false) {
            khacHangController.insert(0,cmnd, tenKhach, diaChi, hoChieu, sdt);
        }      
        phongController.updateTinhTrangPhong("Đang sử dụng",phongHienTai);
        phieuThuePhongController.insert(0, phongHienTai, 1, cmnd, soNguoi, ngayDat, null, hinhThucThue);
        button.setBackground(new Color(255,51,0));
        setNullValue();
        reLoadPhong();
        setThongTinPhong(phongHienTai);
        btnThemDichVu.setEnabled(true);
    }//GEN-LAST:event_btnMoPhongActionPerformed
    
    private void btnDoiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiPhongActionPerformed
        if (doiPhongDialog == null) {
            doiPhongDialog = new DoiPhongDialog(null,true);
            getPhongDangDung();

            doiPhongDialog.tblPhongCanDoi.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    DefaultTableModel p = (DefaultTableModel) doiPhongDialog.tblPhongCanDoi.getModel();
                    int click = doiPhongDialog.tblPhongCanDoi.getSelectedRow();
                    Integer idPhongCanDoi = (Integer) doiPhongDialog.tblPhongCanDoi.getValueAt(click, 0);
                    phongCanDoi = idPhongCanDoi;
                    Integer idLoaiPhong = (Integer) doiPhongDialog.tblPhongCanDoi.getValueAt(click, 2);
                    idLoaiPhongCanDoi = idLoaiPhong;
                    doiPhongDialog.lblPhongCanDoi.setText((String) doiPhongDialog.tblPhongCanDoi.getValueAt(click, 1));   
                    
                    List<Object[]> data = phongController.getPhongTrong(idLoaiPhongCanDoi);
                    DefaultTableModel model2 = (DefaultTableModel) doiPhongDialog.tblPhongMuonDoi.getModel();  
                    if (data == null) {
                        for (int i = doiPhongDialog.tblPhongMuonDoi.getRowCount()-1; i >= 0; i--) {
                            model2.removeRow(i);
                        }
                    }else {
                        for (int i = doiPhongDialog.tblPhongMuonDoi.getRowCount()-1; i >= 0; i--) {
                            model2.removeRow(i);
                        }      
                        for (Object[] objects : data) {
                            model2.addRow(objects);
                        }
                    }
                }
            });
            doiPhongDialog.tblPhongMuonDoi.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {                    
                    DefaultTableModel p = (DefaultTableModel) doiPhongDialog.tblPhongMuonDoi.getModel();
                    int click = doiPhongDialog.tblPhongMuonDoi.getSelectedRow();
                    Integer idPhongMuonDoi = (Integer) doiPhongDialog.tblPhongMuonDoi.getValueAt(click, 0);
                    phongHienTai = idPhongMuonDoi;
                    doiPhongDialog.lblPhongMuonDoi.setText((String) doiPhongDialog.tblPhongMuonDoi.getValueAt(click, 1));
                }
            });
            doiPhongDialog.btnDoiPhong.addActionListener(new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int click = doiPhongDialog.tblPhongCanDoi.getSelectedRow();    
                    int click2 = doiPhongDialog.tblPhongMuonDoi.getSelectedRow();
                    if (click == -1) {
                        JOptionPane.showMessageDialog(new Frame(), "Chọn phòng cần đổi !!!","Thông báo", JOptionPane.ERROR_MESSAGE);                       
                    }else {
                        if (click2 == -1) {
                            JOptionPane.showMessageDialog(new Frame(), "Chọn phòng muốn đổi !!!","Thông báo", JOptionPane.ERROR_MESSAGE);
                        }else {
                            phongController.updateTinhTrangPhong2("Phòng trống", phongCanDoi,idLoaiPhongCanDoi);
                            phongController.updateTinhTrangPhong2("Đang sử dụng", phongHienTai,idLoaiPhongCanDoi);
                            phongController.chuyenPhieuThuePhong(phongHienTai, phongCanDoi);
                            phongController.chuyenHoaDonDichVuPhong(phongHienTai, phongCanDoi);
                            JOptionPane.showMessageDialog(new Frame(), "Đổi phòng thành công !!!");
                            doiPhongDialog.dispose();
                            reLoadPhong();    
                            doiPhongDialog.lblPhongCanDoi.setText("");
                            doiPhongDialog.lblPhongMuonDoi.setText("");
                            setNullValue();
                        }                       
                    }                    
                }
            });
        }
        doiPhongDialog.setVisible(true);
    }//GEN-LAST:event_btnDoiPhongActionPerformed

    public void setNullValue(){
        btnThemDichVu.setEnabled(false);
        jdNgayRoi.setEnabled(false);
        viewTableChiTietDichVu(null);
        btnMoPhong.setEnabled(true);
        jdNgayDat.setDate(null);
        jdNgayRoi.setDate(null);
        txtCMND.setText("");
        txtDiaChi.setText("");
        txtHoChieu.setText("");
        txtSdt.setText("");
        txtTenKhach.setText("");
        lbTenNhanVien.setText("");
        txtSoNguoi.setText("");
        txtTienPhong.setText("0");
        txtTienDichVu.setText("0");
        txtTongTien.setText("0");
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
    
    public void setController (HoaDonController hoaDonController) {
        this.hoaDonController = hoaDonController;
    }   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.PhongButton btnDoiPhong;
    private swing.PhongButton btnKetToan;
    private swing.PhongButton btnMoPhong;
    private swing.PhongButton btnThanhToan;
    private swing.PhongButton btnThemDichVu;
    private javax.swing.JComboBox<String> cbbHinhThucThue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JDateChooser jdNgayDat;
    private com.toedter.calendar.JDateChooser jdNgayRoi;
    private javax.swing.JList<DanhMuc> jlDanhMuc;
    private javax.swing.JLabel lbTenNhanVien;
    private javax.swing.JPanel panel;
    private component.PanelCoverDialog panelCoverDialog1;
    private component.PanelCoverDialog panelCoverDialog2;
    private component.PanelCoverDialog panelCoverDialog3;
    private javax.swing.JScrollPane spTableDichVu;
    private javax.swing.JScrollPane spTableListDichVu;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblListDichVu;
    private swing.TextInput txtCMND;
    private swing.TextInput txtDiaChi;
    private swing.TextInput txtHoChieu;
    private swing.TextInput txtSdt;
    private swing.TextInput txtSoNguoi;
    private swing.TextInput txtTenKhach;
    private swing.TextInput txtTenPhong;
    private swing.TextInput txtTienDichVu;
    private swing.TextInput txtTienKhachDua;
    private swing.TextInput txtTienPhong;
    private swing.TextInput txtTimDichVu;
    private swing.TextInput txtTongTien;
    // End of variables declaration//GEN-END:variables
}
