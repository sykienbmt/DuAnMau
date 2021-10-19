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
        jPanel1 = new javax.swing.JPanel();
        btnThem = new swing.ButtonOutLine();
        btnSua = new swing.ButtonOutLine();
        btnXoa = new swing.ButtonOutLine();
        jPanel2 = new javax.swing.JPanel();

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
        jLabel2.setText("Tìm");

        txtSearchNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNhanVienKeyReleased(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(14, 243, 221));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(241, 40, 223));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(239, 15, 15));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSearchNhanVien))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(121, 121, 121))))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearchNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private swing.Table tblNhanVien;
    private javax.swing.JTextField txtSearchNhanVien;
    // End of variables declaration//GEN-END:variables
}
