package panel;

import DAO.DichVuDAO;
import component.Card;
import helper.SaveImageSQL;
import controller.QlDichVuController;
import helper.ChuyenDoi;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import model.Model_Card;
import swing.ScrollBar;
import swing.WrapLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import model.DanhMuc;
import model.DichVu;
import model.DonViTinh;

public class ProductPnl extends javax.swing.JPanel {

    private QlDichVuController qlDichVuController;
    private byte[] personalImage ;
    DichVuDAO dichVuDAO;
    int idDichVu=UNDEFINED_CONDITION ;
    
    public ProductPnl() {
        initComponents();
        init();
        
    }

    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        panel.revalidate();
        panel.repaint();
    }

    public void viewDichVu(List<Object[]> data,List<DichVu> dichVuss){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        for(int i =0;i<data.size();i++){
            DichVu dv = dichVuss.get(i);
            String tenDV =data.get(i)[1].toString();
            String gia = data.get(i)[3].toString();
            int idDV =(int) data.get(i)[0];
            byte[] img = (byte[]) dv.getAnhSanPham();
            personalImage=img;
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage());
//            lbImage.setIcon(imageIcon);
            
            Card card = new Card(new Model_Card(imageIcon,tenDV,data.get(i)[2].toString()+ "\n"+data.get(i)[3].toString()));
            panel.add(card);
            card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    idDichVu=idDV;
                    txtTenDV.setText(tenDV);
                    
                    for (int i=0; i<cbbDanhMuc.getItemCount();i++){
                        DanhMuc c= (DanhMuc) cbbDanhMuc.getItemAt(i);
                        if(c.getIdDanhMuc().equals(dv.getIdDanhMuc())){
                            cbbDanhMuc.setSelectedIndex(i);
                        }
                    }
                    for (int i=0; i<cbbDonViTinh.getItemCount();i++){
                        DonViTinh c= (DonViTinh) cbbDonViTinh.getItemAt(i);
                        if(c.getIdDonVi().equals(dv.getIdDonVi())){
                            cbbDonViTinh.setSelectedIndex(i);
                        }
                    }
                    txtGiaDV.setText(gia);
                    byte[] img = (byte[]) dv.getAnhSanPham();
                    personalImage=img;
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH));
                    lbImage.setIcon(imageIcon);
                }
            });  
            
        }
    }
    
   
    public void setController (QlDichVuController qlDichVuController) {
        this.qlDichVuController = qlDichVuController;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDeleteDV = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtGiaDV = new javax.swing.JTextField();
        lbImage = new javax.swing.JLabel();
        btnAddDV = new javax.swing.JButton();
        btnUpdateDV = new javax.swing.JButton();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        cbbDonViTinh = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(242, 242, 242));

        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("DANH SÁCH DỊCH VỤ");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteDV.setText("Xoá");
        btnDeleteDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDVActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 60, -1));

        jLabel3.setText("Tên Dịch vụ:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 14, 92, -1));
        jPanel1.add(txtTenDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 160, -1));

        jLabel7.setText("Loại danh mục:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 40, 92, -1));

        jLabel8.setText("Đơn vị tính:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 71, 92, -1));

        jLabel9.setText("Giá:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 102, 92, -1));

        txtGiaDV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaDVKeyReleased(evt);
            }
        });
        jPanel1.add(txtGiaDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.setText("Hình ảnh");
        lbImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });
        jPanel1.add(lbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 110, 120));

        btnAddDV.setText("Thêm");
        btnAddDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDVActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, -1, -1));

        btnUpdateDV.setText("Sửa");
        btnUpdateDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDVActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdateDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 60, -1));

        jPanel1.add(cbbDanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, -1));

        cbbDonViTinh.setToolTipText("");
        jPanel1.add(cbbDonViTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                        .addGap(30, 30, 30))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDVActionPerformed
        if (idDichVu==UNDEFINED_CONDITION) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sp cần xoá !");
        }else{
            int click = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
            if (click == JOptionPane.YES_OPTION) {
                qlDichVuController.delele(idDichVu);
            }
        }
        qlDichVuController.loadDichVu();
    }//GEN-LAST:event_btnDeleteDVActionPerformed

    private void lbImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImageMouseClicked
        JFileChooser ch = new JFileChooser("E:\\FPOLY\\4\\DuAnMau\\src\\icon");
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
            Image img = SaveImageSQL.resize(icon.getImage(), 200 , 200);
            ImageIcon resizedIcon = new ImageIcon(img);
            lbImage.setIcon(resizedIcon);
            personalImage = SaveImageSQL.toByteArray(img, "jpg");
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH));
            lbImage.setIcon(imageIcon);
        } catch (Exception e) {
            e.printStackTrace();          
        }
    }//GEN-LAST:event_lbImageMouseClicked

    private void btnAddDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDVActionPerformed
        String tenDichVu = txtTenDV.getText();
        
        DanhMuc dm =(DanhMuc) cbbDanhMuc.getSelectedItem();
        Integer idDanhMuc = dm.getId();
        
        DonViTinh dvt =(DonViTinh) cbbDonViTinh.getSelectedItem();
        Integer idDonViTinh = dvt.getId();
                
        Double gia=ChuyenDoi.SoDouble(txtGiaDV.getText());
        
        DichVu dv = new DichVu(0, tenDichVu, gia, idDonViTinh, personalImage, idDanhMuc);
        qlDichVuController.insert(dv);
        qlDichVuController.loadDichVu();
        idDichVu=UNDEFINED_CONDITION;
    }//GEN-LAST:event_btnAddDVActionPerformed

    private void btnUpdateDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDVActionPerformed
        String tenDichVu = txtTenDV.getText();
        
        DanhMuc dm =(DanhMuc) cbbDanhMuc.getSelectedItem();
        Integer idDanhMuc = dm.getId();
        
        DonViTinh dvt =(DonViTinh) cbbDonViTinh.getSelectedItem();
        Integer idDonViTinh = dvt.getId();
                
        Double gia=ChuyenDoi.SoDouble(txtGiaDV.getText());
        
        DichVu dv = new DichVu(idDichVu, tenDichVu, gia, idDonViTinh, personalImage, idDanhMuc);
        qlDichVuController.edit(dv);
        qlDichVuController.loadDichVu();
        idDichVu=UNDEFINED_CONDITION;
    }//GEN-LAST:event_btnUpdateDVActionPerformed

    private void txtGiaDVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaDVKeyReleased
        Double gia = ChuyenDoi.SoDouble(txtGiaDV.getText());
        txtGiaDV.setText(ChuyenDoi.SoString(gia));
    }//GEN-LAST:event_txtGiaDVKeyReleased
    
    
    public void setCbbDonViTinh(){
        List<DonViTinh> dvTinhs= qlDichVuController.getDonViTinh();
        cbbDonViTinh.removeAllItems();
        for (DonViTinh dvTinh : dvTinhs) {
            cbbDonViTinh.addItem(dvTinh);
        }
    }
    
    public void setCbbDanhMuc(){
        List<DanhMuc> danhMucs= qlDichVuController.getDanhMuc();
        cbbDanhMuc.removeAllItems();
        for (DanhMuc danhMuc : danhMucs) {
            cbbDanhMuc.addItem(danhMuc);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDV;
    private javax.swing.JButton btnDeleteDV;
    private javax.swing.JButton btnUpdateDV;
    private javax.swing.JComboBox<DanhMuc> cbbDanhMuc;
    private javax.swing.JComboBox<DonViTinh> cbbDonViTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtGiaDV;
    private javax.swing.JTextField txtTenDV;
    // End of variables declaration//GEN-END:variables
}
