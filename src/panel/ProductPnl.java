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
        jPanel2 = new javax.swing.JPanel();
        panelCoverDialog2 = new component.PanelCoverDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbbDonViTinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();
        txtTenDV = new swing.TextInput();
        txtGiaDV = new swing.TextInput();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        textInput1 = new swing.TextInput();
        btnXoa = new swing.ButtonOutLine();
        buttonOutLine1 = new swing.ButtonOutLine();
        btnUpdateDV = new swing.ButtonOutLine();

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
            .addGap(0, 669, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("DANH SÁCH DỊCH VỤ");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Tên Dịch vụ");
        panelCoverDialog2.add(jLabel3);
        jLabel3.setBounds(20, 390, 90, 35);

        jLabel7.setText("Loại danh mục");
        panelCoverDialog2.add(jLabel7);
        jLabel7.setBounds(20, 450, 92, 35);

        panelCoverDialog2.add(cbbDanhMuc);
        cbbDanhMuc.setBounds(120, 450, 160, 35);

        jLabel8.setText("Đơn vị tính");
        panelCoverDialog2.add(jLabel8);
        jLabel8.setBounds(20, 510, 92, 35);

        cbbDonViTinh.setToolTipText("");
        panelCoverDialog2.add(cbbDonViTinh);
        cbbDonViTinh.setBounds(120, 510, 160, 35);

        jLabel9.setText("Giá");
        panelCoverDialog2.add(jLabel9);
        jLabel9.setBounds(20, 570, 92, 35);

        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.setText("Hình ảnh");
        lbImage.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        lbImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });
        panelCoverDialog2.add(lbImage);
        lbImage.setBounds(50, 120, 210, 230);
        panelCoverDialog2.add(txtTenDV);
        txtTenDV.setBounds(120, 390, 160, 35);
        panelCoverDialog2.add(txtGiaDV);
        txtGiaDV.setBounds(120, 570, 160, 35);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý dịch vụ");
        panelCoverDialog2.add(jLabel2);
        jLabel2.setBounds(4, 10, 290, 20);
        panelCoverDialog2.add(jSeparator1);
        jSeparator1.setBounds(10, 40, 280, 10);

        textInput1.setText("Search");
        panelCoverDialog2.add(textInput1);
        textInput1.setBounds(20, 60, 260, 29);

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        panelCoverDialog2.add(btnXoa);
        btnXoa.setBounds(10, 640, 80, 40);

        buttonOutLine1.setBackground(new java.awt.Color(255, 0, 204));
        buttonOutLine1.setText("Thêm");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });
        panelCoverDialog2.add(buttonOutLine1);
        buttonOutLine1.setBounds(210, 640, 80, 40);

        btnUpdateDV.setBackground(new java.awt.Color(153, 153, 0));
        btnUpdateDV.setText("Sửa");
        btnUpdateDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDVActionPerformed(evt);
            }
        });
        panelCoverDialog2.add(btnUpdateDV);
        btnUpdateDV.setBounds(110, 640, 80, 40);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImageMouseClicked
        JFileChooser ch = new JFileChooser("C:\\Users\\Dongnguyen\\Documents\\GitHub\\DuAnMau\\src\\icon\\sanPham");
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
        if (ch.showOpenDialog(jPanel2)==JFileChooser.CANCEL_OPTION) {
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (idDichVu==UNDEFINED_CONDITION) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sp cần xoá !");
        }else{
            int click = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
            if (click == JOptionPane.YES_OPTION) {
                qlDichVuController.delele(idDichVu);
            }
        }
        qlDichVuController.loadDichVu();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
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
    }//GEN-LAST:event_buttonOutLine1ActionPerformed

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
    private swing.ButtonOutLine btnUpdateDV;
    private swing.ButtonOutLine btnXoa;
    private swing.ButtonOutLine buttonOutLine1;
    private javax.swing.JComboBox<DanhMuc> cbbDanhMuc;
    private javax.swing.JComboBox<DonViTinh> cbbDonViTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JPanel panel;
    private component.PanelCoverDialog panelCoverDialog2;
    private swing.TextInput textInput1;
    private swing.TextInput txtGiaDV;
    private swing.TextInput txtTenDV;
    // End of variables declaration//GEN-END:variables
}
