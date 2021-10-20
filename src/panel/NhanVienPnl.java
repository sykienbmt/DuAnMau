package panel;

import controller.NhanVienController;
import dialog.ThemNvDialog;
import swing.ScrollBar;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import model.NhanVien;

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

        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblNhanVien = new swing.Table();
        jLabel2 = new javax.swing.JLabel();
        txtSearchNhanVien = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnXoa = new swing.ButtonOutLine();
        btnSua = new swing.ButtonOutLine();
        btnThem = new swing.ButtonOutLine();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jdcNgayVao = new com.toedter.calendar.JDateChooser();
        jdcNgayVao1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        myTextField2 = new swing.MyTextField();
        myTextField3 = new swing.MyTextField();
        myTextField5 = new swing.MyTextField();
        textInput1 = new swing.TextInput();
        jButton1 = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
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

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Họ tên");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Email");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SĐT");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Giới tính");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lương");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Chức vụ");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Địa chỉ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ngày sinh");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ngày vào");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Trạng thái");

        jdcNgayVao.setBackground(new java.awt.Color(255, 255, 255));
        jdcNgayVao.setForeground(new java.awt.Color(255, 255, 255));
        jdcNgayVao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jdcNgayVao1.setBackground(new java.awt.Color(255, 255, 255));
        jdcNgayVao1.setForeground(new java.awt.Color(255, 255, 255));
        jdcNgayVao1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jRadioButton1.setText("Nam");

        jRadioButton2.setText("Nữ");

        jRadioButton3.setText("Khác");

        jRadioButton4.setText("ON");

        jRadioButton5.setText("OFF");

        jRadioButton6.setText("REST");

        textInput1.setText("textInput1");

        jButton1.setText("jButton1");

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
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
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10))
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jdcNgayVao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(myTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(myTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(myTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jdcNgayVao1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                                            .addComponent(jRadioButton1)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jRadioButton3)))
                                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                                        .addComponent(jRadioButton4)
                                                        .addGap(6, 6, 6)
                                                        .addComponent(jRadioButton5)
                                                        .addGap(7, 7, 7)
                                                        .addComponent(jRadioButton6))))
                                            .addComponent(textInput1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSearchNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jComboBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcNgayVao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcNgayVao1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)))
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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    public com.toedter.calendar.JDateChooser jdcNgayVao;
    public com.toedter.calendar.JDateChooser jdcNgayVao1;
    private swing.MyTextField myTextField2;
    private swing.MyTextField myTextField3;
    private swing.MyTextField myTextField5;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private swing.Table tblNhanVien;
    private swing.TextInput textInput1;
    private javax.swing.JTextField txtSearchNhanVien;
    // End of variables declaration//GEN-END:variables
}
