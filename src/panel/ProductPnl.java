package panel;

import DAO.DichVuDAO;
import component.Card;
import helper.SaveImageSQL;
import controller.QlDichVuController;
import java.awt.Image;
import java.io.File;
import java.util.List;
import model.Model_Card;
import swing.ScrollBar;
import swing.WrapLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import model.DichVu;

public class ProductPnl extends javax.swing.JPanel {

    private QlDichVuController qlDichVuController;
    private byte[] personalImage ;
    DichVuDAO dichVuDAO;
    
    public ProductPnl() {
        initComponents();
        init();
        
    }

    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp.jpg")), "Fanta", "Nước ngọt\n10000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp2.jpg")), "Mirinda", "Nước ngọt\n10000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp3.jpg")), "Pepsi", "Nước ngọt\n10000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp5.jpg")), "7UP", "Nước ngọt\n10000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp4.jpg")), "Swing", "Bim bim\n5000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp.jpg")), "Fanta", "Nước ngọt\n10000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp2.jpg")), "Mirinda", "Nước ngọt\n10000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp3.jpg")), "Pepsi", "Nước ngọt\n10000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp5.jpg")), "7UP", "Nước ngọt\n10000đ")));
        panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp4.jpg")), "Swing", "Bim bim\n5000đ")));
        
//        List<Object[]> data=qlDichVuController.showDichVu();

        dichVuDAO= new DichVuDAO();
        List<Object[]> data = dichVuDAO.showDichVu();
        
        
        for(int i =0;i<data.size();i++){
            DichVu dv= dichVuDAO.getById(Integer.parseInt(data.get(i)[0].toString()));
            byte[] img = (byte[]) dv.getAnhSanPham();
            personalImage=img;
//            System.out.println(personalImage);
            panel.add(new Card(new Model_Card(new ImageIcon(getClass().getResource("/icon/sp.jpg")), data.get(i)[1].toString(),data.get(i)[4].toString()+ "\n"+data.get(i)[2].toString())));
            
        }
        
        panel.revalidate();
        panel.repaint();
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
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        lbImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));

        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
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

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 58, -1, -1));

        jLabel3.setText("Tên Dịch vụ:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 14, 92, -1));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 11, 206, -1));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 37, 206, -1));

        jLabel7.setText("Loại Dịch vụ:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 40, 92, -1));

        jLabel8.setText("Đơn vị tính:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 71, 92, -1));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 68, 206, -1));

        jLabel9.setText("Giá:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 102, 92, -1));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 99, 206, -1));

        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.setText("Hình ảnh");
        lbImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });
        jPanel1.add(lbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 101, 107));

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
                        .addComponent(jScrollPane1)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DichVu dv  = new DichVu(1,"pepsi",10000.0,6,personalImage,2);
        dichVuDAO.insert(dv);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImageMouseClicked
        JFileChooser ch = new JFileChooser("E:\\avatar");
        ch.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }else{
                    return f.getName().toLowerCase().endsWith(".png");
                }
            }
            @Override
            public String getDescription() {
                return "Image File (*.png)";
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lbImage;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
