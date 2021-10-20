package panel;

import controller.NhanVienController;
import dialog.ThemNvDialog;
import swing.ScrollBar;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    
    public NhanVienPnl() {
        initComponents();
        //  css table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
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
        jLabel2 = new javax.swing.JLabel();
        txtSearchNhanVien = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        textInput1 = new swing.TextInput();
        jLabel3 = new javax.swing.JLabel();
        textInput2 = new swing.TextInput();
        jLabel4 = new javax.swing.JLabel();
        textInput3 = new swing.TextInput();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        textInput4 = new swing.TextInput();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textInput5 = new swing.TextInput();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jdcNgayVao1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jdcNgayVao2 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnXoa = new swing.ButtonOutLine();
        btnSua = new swing.ButtonOutLine();
        btnThem = new swing.ButtonOutLine();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

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
                "Id", "Tên", "Email", "Số điện thoại", "Giới tính", "Lương", "Chức vụ", "Địa chỉ", "Ngày sinh", "Ngày vào", "Trạng thái"
            }
        ));
        spTable.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setMinWidth(45);
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblNhanVien.getColumnModel().getColumn(0).setMaxWidth(45);
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
            tblNhanVien.getColumnModel().getColumn(10).setMinWidth(75);
            tblNhanVien.getColumnModel().getColumn(10).setPreferredWidth(75);
            tblNhanVien.getColumnModel().getColumn(10).setMaxWidth(75);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tìm");

        txtSearchNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNhanVienKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Họ tên");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Email");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SĐT");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Giới tính");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Khác");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Nữ");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Nam");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lương");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Chức vụ");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Địa chỉ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ngày sinh");

        jdcNgayVao1.setBackground(new java.awt.Color(255, 255, 255));
        jdcNgayVao1.setForeground(new java.awt.Color(255, 255, 255));
        jdcNgayVao1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ngày vào");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("REST");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("OFF");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("ON");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Trạng thái");

        jdcNgayVao2.setBackground(new java.awt.Color(255, 255, 255));
        jdcNgayVao2.setForeground(new java.awt.Color(255, 255, 255));
        jdcNgayVao2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jComboBox2.setForeground(new java.awt.Color(122, 140, 141));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcNgayVao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdcNgayVao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textInput5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgayVao2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcNgayVao1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXoa.setBackground(new java.awt.Color(239, 15, 15));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(241, 40, 223));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(14, 243, 221));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSearchNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(12, 12, 12)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(spTable)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private ThemNvDialog themNvDialog = null;
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
        }}
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int chonDong = tblNhanVien.getSelectedRow();
        if (chonDong == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa !!!","Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            if (themNvDialog == null) {
                themNvDialog = new ThemNvDialog(null,true);
                int click = tblNhanVien.getSelectedRow();
                NhanVien nv = nhanVienController.getByIdNhanVien((Integer) tblNhanVien.getValueAt(click, 0));
                themNvDialog.txtTen.setText(nv.getTen());
                themNvDialog.txtEmail.setText(nv.getEmail());
                themNvDialog.txtSdt.setText(nv.getSdt());
                if(nv.getSex().equals("Nam")){
                    themNvDialog.rdbNam.setSelected(true);
                }else if(nv.getSex().equals("Nữ")){
                    themNvDialog.rdbNu.setSelected(true);
                }else themNvDialog.rdbKhac.setSelected(true);
                themNvDialog.txtLuong.setText(nv.getLuong().toString()); 
                for (int i = 0; i < themNvDialog.cbxChucVu.getItemCount(); i++) {
                    ChucVu c = (ChucVu) themNvDialog.cbxChucVu.getItemAt(i);
                    if (c.getIdChucVu().equals(nv.getIdChucVu())) {
                        themNvDialog.cbxChucVu.setSelectedIndex(i);
                    }
                }
                themNvDialog.txtDiaChi.setText(nv.getDiaChi());
                Date date = new Date(nv.getNgaySinh().getTime());
                themNvDialog.jdcNgaySinh.setDate(date);
                date = new Date(nv.getNgayVaoLam().getTime());
                themNvDialog.jdcNgayVao.setDate(date);
                if(nv.getTrangThai().equals("ON")){
                    themNvDialog.rdbOn.setSelected(true);
                }else if(nv.getTrangThai().equals("OFF")){
                    themNvDialog.rdbOff.setSelected(true);
                }else themNvDialog.rdbRest.setSelected(true);     
                
                themNvDialog.btnThem.setVisible(false);
                
                themNvDialog.btnLuu.addActionListener(new AbstractAction(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int clickLuu = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn sửa không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
                        if (clickLuu == JOptionPane.YES_OPTION) {
                            String ten = themNvDialog.txtTen.getText();
                            String email = themNvDialog.txtEmail.getText();
                            String sdt = themNvDialog.txtSdt.getText(); 
                            String sex = null;
                            Double luong = Double.parseDouble(themNvDialog.txtLuong.getText()) ;
                            ChucVu chucVu =(ChucVu) themNvDialog.cbxChucVu.getSelectedItem();
                            Integer tenChucVu = chucVu.getIdChucVu();
                            String diaChi = themNvDialog.txtDiaChi.getText(); 
                            java.util.Date DateOfBirth1 = themNvDialog.jdcNgaySinh.getDate();
                            java.sql.Date ngaySinh= new java.sql.Date(DateOfBirth1.getTime());
                            java.util.Date StartingDate1 = themNvDialog.jdcNgayVao.getDate();
                            java.sql.Date ngayVao = new java.sql.Date(StartingDate1.getTime());
                            String trangThai = null;

                            if(themNvDialog.rdbNam.isSelected()){
                                sex="Nam";
                            }else if(themNvDialog.rdbNu.isSelected()){
                                sex = "Nữ";
                            }else sex = "Khác";

                            if(themNvDialog.rdbOn.isSelected()){
                                trangThai="ON";
                            }else if(themNvDialog.rdbOff.isSelected()){
                                trangThai = "OFF";
                            }else trangThai = "REST";

                            Integer idNhanVien = (Integer) tblNhanVien.getValueAt(chonDong, 0);
                            nhanVienController.update(idNhanVien,ten, email, sdt, sex, luong, tenChucVu, diaChi, ngaySinh, ngayVao,trangThai);
                            themNvDialog.setVisible(false);
                            JOptionPane.showMessageDialog(new Frame(),"Update success !!!");
                        }
                    }
                });
            }
            DefaultComboBoxModel <ChucVu> model = (DefaultComboBoxModel<ChucVu>) themNvDialog.cbxChucVu.getModel();
            model.removeAllElements();
            List<ChucVu> chucVus = nhanVienController.getChucVu();
            model.addAll(nhanVienController.getChucVu());
            model.setSelectedItem(chucVus.get(0));
            themNvDialog.setVisible(true);
            themNvDialog=null;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (themNvDialog == null) {
            themNvDialog = new ThemNvDialog(null,true);
            themNvDialog.btnLuu.setVisible(false);
            themNvDialog.btnThem.addActionListener(new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int clickThem = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn thêm không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
                    if (clickThem == JOptionPane.YES_OPTION) {
                        String ten = themNvDialog.txtTen.getText();
                        String email = themNvDialog.txtEmail.getText();
                        String sdt = themNvDialog.txtSdt.getText(); 
                        String sex = null;
                        Double luong = Double.parseDouble(themNvDialog.txtLuong.getText()) ;
                        ChucVu chucVu =(ChucVu) themNvDialog.cbxChucVu.getSelectedItem();
                        Integer tenChucVu = chucVu.getIdChucVu();
                        String diaChi = themNvDialog.txtDiaChi.getText(); 
                        java.util.Date DateOfBirth1 = themNvDialog.jdcNgaySinh.getDate();
                        java.sql.Date ngaySinh= new java.sql.Date(DateOfBirth1.getTime());
                        java.util.Date StartingDate1 = themNvDialog.jdcNgayVao.getDate();
                        java.sql.Date ngayVao = new java.sql.Date(StartingDate1.getTime());
                        String trangThai = null;
                                             
                        if(themNvDialog.rdbNam.isSelected()){
                            sex="Nam";
                        }else if(themNvDialog.rdbNu.isSelected()){
                            sex = "Nữ";
                        }else sex = "Khác";

                        if(themNvDialog.rdbOn.isSelected()){
                            trangThai="ON";
                        }else if(themNvDialog.rdbOff.isSelected()){
                            trangThai = "OFF";
                        }else trangThai = "REST";
                        
                        nhanVienController.insert(ten, email, sdt, sex, luong, tenChucVu, diaChi, ngaySinh, ngayVao,trangThai);
                        themNvDialog.setVisible(false);
                    }
                }
            });
        }
        DefaultComboBoxModel <ChucVu> model = (DefaultComboBoxModel<ChucVu>) themNvDialog.cbxChucVu.getModel();
        model.removeAllElements();
        List<ChucVu> chucVus = nhanVienController.getChucVu();
        model.addAll(nhanVienController.getChucVu());
        model.setSelectedItem(chucVus.get(0));
        themNvDialog.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtSearchNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNhanVienKeyReleased
        String tenNhanVien = txtSearchNhanVien.getText();
        List<Object[]> data = nhanVienController.searchNhanVien(tenNhanVien);
        viewTableStaff(data);
    }//GEN-LAST:event_txtSearchNhanVienKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
    private swing.ButtonOutLine btnSua;
    private swing.ButtonOutLine btnThem;
    private swing.ButtonOutLine btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<ChucVu> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    public com.toedter.calendar.JDateChooser jdcNgayVao1;
    public com.toedter.calendar.JDateChooser jdcNgayVao2;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private swing.Table tblNhanVien;
    private swing.TextInput textInput1;
    private swing.TextInput textInput2;
    private swing.TextInput textInput3;
    private swing.TextInput textInput4;
    private swing.TextInput textInput5;
    private javax.swing.JTextField txtSearchNhanVien;
    // End of variables declaration//GEN-END:variables
}
