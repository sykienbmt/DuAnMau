package panel;

import helper.SaveImageSQL;
import controller.NhanVienController;
import dialog.GuiMail;
import helper.ChuyenDoi;
import helper.DataValidate;
import helper.MD5Convert;
import helper.MailSender;
import swing.ScrollBar;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import model.NhanVien;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class NhanVienPnl extends javax.swing.JPanel {
    private NhanVienController nhanVienController;
    private byte[] hinhAnh;
    private GuiMail guiMail = null;
    private String pass ;
    
    public NhanVienPnl() {
        initComponents();
        //  css table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        jdcNgaySinh.setDateFormatString("dd-MM-yyyy");
        jdcNgayVao.setDateFormatString("dd-MM-yyyy");
        //placeholder search
        txtTimNhanVien.setText("Tìm tên nhân viên");
        txtTimNhanVien.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimNhanVien.getText().equals("Tìm tên nhân viên")) {
                    txtTimNhanVien.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimNhanVien.getText().isEmpty()) {
                    txtTimNhanVien.setText("Tìm tên nhân viên");
                }
            }
        });   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblNhanVien = new swing.Table();
        jPanel2 = new javax.swing.JPanel();
        txtHoten = new swing.TextInput();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new swing.TextInput();
        jLabel4 = new javax.swing.JLabel();
        txtSdt = new swing.TextInput();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLuong = new swing.TextInput();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new swing.TextInput();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jdcNgayVao = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        cbxChucVu = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        rdbNam = new swing.RadioButtonCustom();
        rdbNu = new swing.RadioButtonCustom();
        rdbKhac = new swing.RadioButtonCustom();
        rdbOn = new swing.RadioButtonCustom();
        rdbRest = new swing.RadioButtonCustom();
        rdbOff = new swing.RadioButtonCustom();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new swing.ButtonOutLine();
        btnSua = new swing.ButtonOutLine();
        btnXoa = new swing.ButtonOutLine();
        btnEmail = new swing.ButtonOutLine();
        btnXuatFile = new swing.ButtonOutLine();
        txtTimNhanVien = new swing.TextInput();
        jldTimLuongNv = new swing.JsliderCustom();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblValueLuong = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        spTable.setBorder(null);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên", "Email", "Số điện thoại", "Giới tính", "Lương", "Chức vụ", "Địa chỉ", "Ngày sinh", "Ngày vào", "TT", "Hình ảnh", "pass"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        spTable.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(0).setMaxWidth(0);
            tblNhanVien.getColumnModel().getColumn(2).setMinWidth(135);
            tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(135);
            tblNhanVien.getColumnModel().getColumn(2).setMaxWidth(135);
            tblNhanVien.getColumnModel().getColumn(4).setMinWidth(65);
            tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(65);
            tblNhanVien.getColumnModel().getColumn(4).setMaxWidth(65);
            tblNhanVien.getColumnModel().getColumn(5).setMinWidth(80);
            tblNhanVien.getColumnModel().getColumn(5).setPreferredWidth(80);
            tblNhanVien.getColumnModel().getColumn(5).setMaxWidth(80);
            tblNhanVien.getColumnModel().getColumn(6).setMinWidth(70);
            tblNhanVien.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblNhanVien.getColumnModel().getColumn(6).setMaxWidth(70);
            tblNhanVien.getColumnModel().getColumn(10).setMinWidth(40);
            tblNhanVien.getColumnModel().getColumn(10).setPreferredWidth(40);
            tblNhanVien.getColumnModel().getColumn(10).setMaxWidth(40);
            tblNhanVien.getColumnModel().getColumn(11).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(11).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(11).setMaxWidth(0);
            tblNhanVien.getColumnModel().getColumn(12).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(12).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(12).setMaxWidth(0);
        }

        jPanel2.setBackground(new java.awt.Color(246, 246, 246));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Họ tên");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Email");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("SĐT");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Giới tính");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Lương");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Chức vụ");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Địa chỉ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Ngày sinh");

        jdcNgayVao.setBackground(new java.awt.Color(213, 245, 227));
        jdcNgayVao.setForeground(new java.awt.Color(255, 255, 255));
        jdcNgayVao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Ngày vào");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Trạng thái");

        jdcNgaySinh.setBackground(new java.awt.Color(213, 245, 227));
        jdcNgaySinh.setForeground(new java.awt.Color(255, 255, 255));
        jdcNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbxChucVu.setBackground(new java.awt.Color(213, 245, 227));
        cbxChucVu.setForeground(new java.awt.Color(122, 140, 141));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255)));

        lblImage.setBackground(new java.awt.Color(204, 204, 204));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonGroup1.add(rdbNam);
        rdbNam.setText("Nam");

        rdbNu.setBackground(new java.awt.Color(255, 102, 102));
        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nữ");

        rdbKhac.setBackground(new java.awt.Color(0, 255, 153));
        buttonGroup1.add(rdbKhac);
        rdbKhac.setText("Khác");

        buttonGroup2.add(rdbOn);
        rdbOn.setText("ON");

        rdbRest.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup2.add(rdbRest);
        rdbRest.setText("REST");

        rdbOff.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup2.add(rdbOff);
        rdbOff.setText(" OFF");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcNgayVao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdbOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(rdbOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(rdbRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rdbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(rdbNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdbKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxChucVu, javax.swing.GroupLayout.Alignment.TRAILING, 0, 211, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtHoten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcNgayVao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(246, 246, 246));

        btnThem.setBackground(new java.awt.Color(14, 243, 221));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(241, 40, 223));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/updating.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(239, 15, 15));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnEmail.setBackground(new java.awt.Color(180, 27, 247));
        btnEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gmail.png"))); // NOI18N
        btnEmail.setText("Gửi Email");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        btnXuatFile.setBackground(new java.awt.Color(249, 185, 23));
        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png"))); // NOI18N
        btnXuatFile.setText("Xuất Fiile");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtTimNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimNhanVienKeyReleased(evt);
            }
        });

        jldTimLuongNv.setMajorTickSpacing(10000);
        jldTimLuongNv.setMaximum(100000);
        jldTimLuongNv.setToolTipText("");
        jldTimLuongNv.setValue(0);
        jldTimLuongNv.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jldTimLuongNvStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("0");

        jLabel14.setText("Lương");

        lblValueLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValueLuong.setText("0đ");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jldTimLuongNv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblValueLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(498, 498, 498))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(8, 8, 8))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jldTimLuongNv, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(lblValueLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int dongXoa = tblNhanVien.getSelectedRow();
        if (dongXoa == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa !","Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {        
            int click = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
            if (click == JOptionPane.YES_OPTION) {
            int[] vt = tblNhanVien.getSelectedRows();
            List<Integer> idStaffs  = new ArrayList<>();
            for (int i = vt.length-1; i >= 0; i--) {
                idStaffs.add((Integer)tblNhanVien.getValueAt(vt[i], 0));
            }
            nhanVienController.delete(idStaffs);
            nhanVienController.loadList();
        }}
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int chonDong = tblNhanVien.getSelectedRow();
        if (chonDong == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa !!!","Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            int clickLuu = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn sửa không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
            if (clickLuu == JOptionPane.YES_OPTION) {
                StringBuilder sb = new StringBuilder();
                
                String hoTen = txtHoten.getText();
                DataValidate.checkEmpty(hoTen, sb, "Tên không được để trống! ");
                 
                String email = txtEmail.getText();
                DataValidate.checkEmpty(email, sb, "Email không được để trống! ");
                DataValidate.checkEmailForm(email, sb);
                
                String sdt = txtSdt.getText(); 
                DataValidate.checkEmpty(sdt, sb, "Số đt không được để trống! ");
                DataValidate.checkSdtForm(sdt, sb);
                
                //validate sex
                String sex = null;
                if(rdbNam.isSelected()){
                    sex="Nam";
                }else if(rdbNu.isSelected()){
                    sex = "Nữ";
                }else if (rdbNu.isSelected()){
                    sex = "Khác";
                }else{
                    sb.append("Vui lòng chọn giới tính! \n");
                }
                
                
                double luong = 0;
                try {
                    luong = ChuyenDoi.SoDouble(txtLuong.getText()) ;
                    if(luong < 0){
                        sb.append("Lương phải lớn hớn 0 \n");
                    }
                } catch (Exception e) {
                    sb.append("Lương phải là số \n");
                }
                
                ChucVu chucVu =(ChucVu) cbxChucVu.getSelectedItem();
                Integer tenChucVu = chucVu.getIdChucVu();
                
                String diaChi = txtDiaChi.getText();
                DataValidate.checkEmpty(diaChi, sb, "Địa chỉ không được để trống! ");
                
                //validate day
                java.sql.Date ngaySinh = null,ngayVao = null;
                if(jdcNgaySinh.getDate() == null || jdcNgayVao.getDate() == null){
                    sb.append("Vui lòng điền đủ ngày tháng ! \n");
                }else{
                    java.util.Date nSinhRaw = jdcNgaySinh.getDate();
                    ngaySinh = new java.sql.Date(nSinhRaw.getTime());

                    java.util.Date nVaoRaw = jdcNgayVao.getDate();
                    ngayVao = new java.sql.Date(nVaoRaw.getTime());
                    DataValidate.checkNgayThang(nSinhRaw, nVaoRaw, sb);
                }
                
                
                //validate trangThai
                String trangThai = null;
                if(rdbOn.isSelected()){
                    trangThai="ON";
                }else if(rdbOff.isSelected()){
                    trangThai = "OFF";
                }else if(rdbOff.isSelected()){
                    trangThai = "REST";
                }else{
                    sb.append("Vui lòng chọn trạng thái! \n");
                }

                Integer idNhanVien = (Integer) tblNhanVien.getValueAt(chonDong, 0);
                
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    nhanVienController.update(idNhanVien,hoTen, email, sdt, sex, luong, tenChucVu, diaChi, ngaySinh, ngayVao,trangThai,hinhAnh,pass);
                    JOptionPane.showMessageDialog(new Frame(),"Update success !!!");    
                }                           
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //validate hoTen
        StringBuilder sb = new StringBuilder();
        String ten = txtHoten.getText();
        DataValidate.checkEmpty(ten, sb, "Tên không được để trống! ");
        
        //validate phone
        String email = txtEmail.getText();
        DataValidate.checkEmpty(email, sb, "Email không được để trống! ");
        DataValidate.checkEmailForm(email, sb);
        DataValidate.checkEmailExist(email, sb);
        
        //validate sdt
        String sdt = txtSdt.getText(); 
        DataValidate.checkEmpty(sdt, sb, "Số đt không được để trống! ");
        DataValidate.checkSdtForm(sdt, sb);
        DataValidate.checkPhoneExist(sdt, sb);
        
        //validate luong
        //Double luong = Double.parseDouble(txtLuong.getText()) ;
        double luong = 0;
        try {
            luong = Double.parseDouble(txtLuong.getText()) ;
            if(luong < 0){
                sb.append("Lương phải lớn hớn 0 \n");
            }
        } catch (Exception e) {
            sb.append("Lương phải là số \n");
        }
        
        ChucVu chucVu =(ChucVu) cbxChucVu.getSelectedItem();
        Integer tenChucVu = chucVu.getIdChucVu();
        
        //validate diaChi
        String diaChi = txtDiaChi.getText(); 
        DataValidate.checkEmpty(diaChi, sb, "Địa chỉ không được để trống! ");
        
        
//        java.util.Date DateOfBirth1 = jdcNgaySinh.getDate();
//        java.sql.Date ngaySinh= new java.sql.Date(DateOfBirth1.getTime());
//        java.util.Date StartingDate1 = jdcNgayVao.getDate();
//        java.sql.Date ngayVao = new java.sql.Date(StartingDate1.getTime());
        
        
        //validate day
        java.sql.Date ngaySinh = null,ngayVao = null;
        if(jdcNgaySinh.getDate() == null || jdcNgayVao.getDate() == null){
            sb.append("Vui lòng điền đủ ngày tháng ! \n");
        }else{
            java.util.Date nSinhRaw = jdcNgaySinh.getDate();
            ngaySinh = new java.sql.Date(nSinhRaw.getTime());
            
            java.util.Date nVaoRaw = jdcNgayVao.getDate();
            ngayVao = new java.sql.Date(nVaoRaw.getTime());
            DataValidate.checkNgayThang(nSinhRaw, nVaoRaw, sb);
        }

        
        //validate sex
        String sex = null;
        if(rdbNam.isSelected()){
            sex="Nam";
        }else if(rdbNu.isSelected()){
            sex = "Nữ";
        }else if (rdbKhac.isSelected()){
            sex = "Khác";
        }else{
            sb.append("Vui lòng chọn giới tính! \n");
        }

        //validate trangThai
        String trangThai = null;
        if(rdbOn.isSelected()){
            trangThai="ON";
        }else if(rdbOff.isSelected()){
            trangThai = "OFF";
        }else if(rdbRest.isSelected()){
            trangThai = "REST";
        }else{
            sb.append("Vui lòng chọn trạng thái! \n");
        }

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            nhanVienController.insert(ten, email, sdt, sex, luong, tenChucVu, diaChi, ngaySinh, ngayVao,trangThai,hinhAnh,sdt);
            hinhAnh = null;            
        }

    }//GEN-LAST:event_btnThemActionPerformed

    
    
    
    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        DefaultTableModel ml = (DefaultTableModel) tblNhanVien.getModel();
        int click = tblNhanVien.getSelectedRow();
        NhanVien nv = nhanVienController.getByIdNhanVien((Integer) tblNhanVien.getValueAt(click, 0));     
        
        txtHoten.setText((String) tblNhanVien.getValueAt(click, 1));
        txtEmail.setText((String) tblNhanVien.getValueAt(click, 2));
        txtSdt.setText((String) tblNhanVien.getValueAt(click, 3));
        pass=(String) tblNhanVien.getValueAt(click, 12);
        if(tblNhanVien.getValueAt(click, 4).toString().equals("Nam")){
            rdbNam.setSelected(true);
        }else if(tblNhanVien.getValueAt(click, 4).toString().equals("Nữ")){
            rdbNu.setSelected(true);
        }else rdbKhac.setSelected(true);       
        txtLuong.setText(tblNhanVien.getValueAt(click, 5).toString());
        
        for (int i = 0; i < cbxChucVu.getItemCount(); i++) {
            ChucVu c = (ChucVu) cbxChucVu.getItemAt(i);
            if (c.getIdChucVu().equals(nv.getIdChucVu())) {
                cbxChucVu.setSelectedIndex(i);
            }
        }
        txtDiaChi.setText(nv.getDiaChi());
        Date date = new Date(nv.getNgaySinh().getTime());
        jdcNgaySinh.setDate(date);
        date = new Date(nv.getNgayVaoLam().getTime());
        jdcNgayVao.setDate(date);
        if(nv.getTrangThai().equals("ON")){
            rdbOn.setSelected(true);
        }else if(nv.getTrangThai().equals("OFF")){
            rdbOff.setSelected(true);
        }else rdbRest.setSelected(true);     

        byte[] img = (byte[]) nv.getHinhAnh();
        hinhAnh = img;
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
        lblImage.setIcon(imageIcon);   
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        JFileChooser ch = new JFileChooser("C:\\Users\\Dongnguyen\\Documents\\GitHub\\DuAnMau\\src\\icon");
        ch.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }else{
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }
            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        if (ch.showOpenDialog(jPanel1)==JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = ch.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = SaveImageSQL.resize(icon.getImage(), 142, 173);
            ImageIcon resizedIcon = new ImageIcon(img);
            lblImage.setIcon(resizedIcon);
            hinhAnh = SaveImageSQL.toByteArray(img, "jpg");
        } catch (Exception e) {
            e.printStackTrace();           
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        int chonDong = tblNhanVien.getSelectedRow();
        int[] vt = tblNhanVien.getSelectedRows();
        String sendMails ="";
        if (chonDong == -1) {
            JOptionPane.showMessageDialog(this, "Chọn nhân viên cần gửi !!!","Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            if(vt.length>1){
                for (int i = vt.length-1; i >= 0; i--) {
                    sendMails += tblNhanVien.getValueAt(vt[i], 2) + ",";
                }
                sendMails= sendMails.substring(0, sendMails.length()-1);
            }else{
                sendMails +=tblNhanVien.getValueAt(chonDong, 2).toString();
            }
            
            if (guiMail == null) {
                guiMail = new GuiMail(null,true);          
                guiMail.txtNguoiNhan.setText(sendMails);
                guiMail.btnChonFile.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jf = new JFileChooser();
                        int re = jf.showOpenDialog(null);
                        if (re == JFileChooser.APPROVE_OPTION){
                            guiMail.txtCC.setText(jf.getSelectedFile().getPath());
                            JOptionPane.showMessageDialog(new Frame(), "Get file success !!!");
                        }
                    }
                });

                guiMail.btnGuiMail.addActionListener(new AbstractAction(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int clickThem = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn gửi không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
                        if (clickThem == JOptionPane.YES_OPTION) {
                            MailSender mail = new MailSender();
                            Properties prop = new Properties();
                            prop.put("mail.smtp.host", "smtp.gmail.com");
                            prop.put("mail.smtp.port", "587");
                            prop.put("mail.smtp.auth", "true");
                            prop.put("mail.smtp.starttls.enable", "true"); //TLS

                            final String username = "sikienbmto1@gmail.com";
                            final String password = "01263500";

                            Session session = Session.getInstance(prop,
                                new javax.mail.Authenticator() {
                                    @Override
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(username, password);
                                    }
                            });  
                            try {                           
                                Message message = new MimeMessage(session);
                                message.setFrom(new InternetAddress("EmailFromJava"));
                                message.setRecipients(
                                    Message.RecipientType.TO,
                                    InternetAddress.parse(guiMail.txtNguoiNhan.getText())
                                );
                                message.setSubject(guiMail.txtTieuDe.getText());
                                message.setText(guiMail.jtaNoiDung.getText());

                                MimeBodyPart texBodyPart = new MimeBodyPart();
                                texBodyPart.setContent(guiMail.jtaNoiDung.getText(),"text/plain");

                                Multipart emailContent = new MimeMultipart();
                                emailContent.addBodyPart(texBodyPart);

                                String strAtt = guiMail.txtCC.getText().trim();
                                if (!strAtt.equals("")) {
                                    MimeBodyPart pdfAtt = new MimeBodyPart();
                                    FileDataSource fds = new FileDataSource(strAtt);
                                    pdfAtt.setDataHandler(new DataHandler(fds));
                                    pdfAtt.setFileName(fds.getName());
                                    emailContent.addBodyPart(pdfAtt);
                                }
                                message.setContent(emailContent);
                                mail.queue((MimeMessage) message);

                                guiMail.txtCC.setText("");
                                guiMail.txtNguoiNhan.setText("");
                                guiMail.txtTieuDe.setText("");
                                guiMail.jtaNoiDung.setText("");   
                            } catch (Exception err) {
                                JOptionPane.showMessageDialog(new Frame(), err.getMessage());
                                err.printStackTrace();
                            }
                            guiMail.setVisible(false);
                        }
                    }
                });
            }
            guiMail.setVisible(true);
            guiMail=null;
        }        
    }//GEN-LAST:event_btnEmailActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        try{
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
           
            if(saveFile != null){
                saveFile = new File(saveFile.toString()+".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("customer");

                Row rowCol = sheet.createRow(0);
                for(int i=0;i<tblNhanVien.getColumnCount();i++){
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblNhanVien.getColumnName(i));
                }
               
                for(int j=0;j<tblNhanVien.getRowCount();j++){
                    Row row = sheet.createRow(j+1);
                    for(int k=0;k<tblNhanVien.getColumnCount();k++){
                        Cell cell = row.createCell(k);
                        if(tblNhanVien.getValueAt(j, k)!=null){
                            cell.setCellValue(tblNhanVien.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                int clickLuu = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn mở file vừa xuất ?", "Thông báo",JOptionPane.YES_NO_OPTION);
                if (clickLuu == JOptionPane.YES_OPTION) {
                    openFile(saveFile.toString());
                }

           }else{
               JOptionPane.showMessageDialog(null,"Error al generar archivo");
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void txtTimNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimNhanVienKeyReleased
        String tenNhanVien = txtTimNhanVien.getText();
        List<Object[]> data = nhanVienController.searchNhanVien(tenNhanVien);
        viewTableStaff(data);
    }//GEN-LAST:event_txtTimNhanVienKeyReleased

    private void jldTimLuongNvStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jldTimLuongNvStateChanged
        Integer luong = jldTimLuongNv.getValue();
        lblValueLuong.setText(luong.toString()+" đ");
        List<Object[]> data = nhanVienController.searchLuongNhanVien(luong);
        viewTableStaff(data);
    }//GEN-LAST:event_jldTimLuongNvStateChanged
        
    public void FillDataComboBox() {
        List<ChucVu> chucVus = nhanVienController.getChucVu();
        cbxChucVu.removeAllItems();
        for (ChucVu chucVu : chucVus) {
            cbxChucVu.addItem(chucVu);
        }
    }
    
    public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
      
    public void viewTableStaff(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();      
        for (int i = tblNhanVien.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }      
        for (Object[] objects : data) {
            model.addRow(objects);
        }
    }
    
    public void setController (NhanVienController nhanVienController) {
        this.nhanVienController = nhanVienController;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonOutLine btnEmail;
    private swing.ButtonOutLine btnSua;
    private swing.ButtonOutLine btnThem;
    private swing.ButtonOutLine btnXoa;
    private swing.ButtonOutLine btnXuatFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<ChucVu> cbxChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public com.toedter.calendar.JDateChooser jdcNgaySinh;
    public com.toedter.calendar.JDateChooser jdcNgayVao;
    private swing.JsliderCustom jldTimLuongNv;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblValueLuong;
    private swing.PanelBorder panelBorder1;
    private swing.RadioButtonCustom rdbKhac;
    private swing.RadioButtonCustom rdbNam;
    private swing.RadioButtonCustom rdbNu;
    private swing.RadioButtonCustom rdbOff;
    private swing.RadioButtonCustom rdbOn;
    private swing.RadioButtonCustom rdbRest;
    private javax.swing.JScrollPane spTable;
    private swing.Table tblNhanVien;
    private swing.TextInput txtDiaChi;
    private swing.TextInput txtEmail;
    private swing.TextInput txtHoten;
    private swing.TextInput txtLuong;
    private swing.TextInput txtSdt;
    private swing.TextInput txtTimNhanVien;
    // End of variables declaration//GEN-END:variables
}
