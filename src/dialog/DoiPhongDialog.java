package dialog;

import component.Loading;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import swing.ScrollBar;

/**
 *
 * @author tuanl
 */
public class DoiPhongDialog extends javax.swing.JDialog {
    
    public DoiPhongDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        loading.setVisible(false);
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        spTable2.setVerticalScrollBar(new ScrollBar());
        spTable2.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable2.getViewport().setBackground(Color.WHITE);
        spTable2.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        bg1 = new javax.swing.JLayeredPane();
        loading = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bg = new component.PanelCoverDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblPhongCanDoi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblPhongCanDoi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPhongMuonDoi = new javax.swing.JLabel();
        btnDoiPhong = new swing.PhongButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        spTable2 = new javax.swing.JScrollPane();
        tblPhongMuonDoi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bg1.setBackground(new java.awt.Color(255, 255, 255));
        bg1.setOpaque(true);

        loading.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/81908-loading.gif"))); // NOI18N
        loading.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -20, 600, 490));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phòng muốn đổi");
        bg.add(jLabel1);
        jLabel1.setBounds(270, 50, 250, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Phòng cần đổi");
        bg.add(jLabel3);
        jLabel3.setBounds(10, 50, 250, 30);

        tblPhongCanDoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên phòng", "Id Loai Phong", "Loại phòng"
            }
        ));
        spTable.setViewportView(tblPhongCanDoi);
        if (tblPhongCanDoi.getColumnModel().getColumnCount() > 0) {
            tblPhongCanDoi.getColumnModel().getColumn(0).setMinWidth(35);
            tblPhongCanDoi.getColumnModel().getColumn(0).setPreferredWidth(35);
            tblPhongCanDoi.getColumnModel().getColumn(0).setMaxWidth(35);
            tblPhongCanDoi.getColumnModel().getColumn(1).setMinWidth(75);
            tblPhongCanDoi.getColumnModel().getColumn(1).setPreferredWidth(75);
            tblPhongCanDoi.getColumnModel().getColumn(1).setMaxWidth(75);
            tblPhongCanDoi.getColumnModel().getColumn(2).setMinWidth(0);
            tblPhongCanDoi.getColumnModel().getColumn(2).setPreferredWidth(0);
            tblPhongCanDoi.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        bg.add(spTable);
        spTable.setBounds(10, 90, 250, 300);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exchange.png"))); // NOI18N
        jLabel2.setText("chuyển sang");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        btnDoiPhong.setText("Đổi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(lblPhongCanDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPhongMuonDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnDoiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhongMuonDoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPhongCanDoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnDoiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        bg.add(jPanel1);
        jPanel1.setBounds(10, 400, 510, 61);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ĐỔI PHÒNG");
        bg.add(jLabel4);
        jLabel4.setBounds(10, 0, 520, 40);
        bg.add(jSeparator1);
        jSeparator1.setBounds(10, 40, 550, 10);

        tblPhongMuonDoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên phòng", "Id phòng", "Loại phòng"
            }
        ));
        spTable2.setViewportView(tblPhongMuonDoi);
        if (tblPhongMuonDoi.getColumnModel().getColumnCount() > 0) {
            tblPhongMuonDoi.getColumnModel().getColumn(0).setMinWidth(35);
            tblPhongMuonDoi.getColumnModel().getColumn(0).setPreferredWidth(35);
            tblPhongMuonDoi.getColumnModel().getColumn(0).setMaxWidth(35);
            tblPhongMuonDoi.getColumnModel().getColumn(1).setMinWidth(75);
            tblPhongMuonDoi.getColumnModel().getColumn(1).setPreferredWidth(75);
            tblPhongMuonDoi.getColumnModel().getColumn(1).setMaxWidth(75);
            tblPhongMuonDoi.getColumnModel().getColumn(2).setMinWidth(0);
            tblPhongMuonDoi.getColumnModel().getColumn(2).setPreferredWidth(0);
            tblPhongMuonDoi.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        bg.add(spTable2);
        spTable2.setBounds(270, 92, 250, 300);

        bg1.setLayer(loading, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg1.setLayer(bg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bg1Layout = new javax.swing.GroupLayout(bg1);
        bg1.setLayout(bg1Layout);
        bg1Layout.setHorizontalGroup(
            bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
            .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
            .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(loading, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
        );
        bg1Layout.setVerticalGroup(
            bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
            .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
            .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(loading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public component.PanelCoverDialog bg;
    public javax.swing.JLayeredPane bg1;
    public swing.PhongButton btnDoiPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel lblPhongCanDoi;
    public javax.swing.JLabel lblPhongMuonDoi;
    public javax.swing.JPanel loading;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable2;
    public javax.swing.JTable tblPhongCanDoi;
    public javax.swing.JTable tblPhongMuonDoi;
    // End of variables declaration//GEN-END:variables
}
