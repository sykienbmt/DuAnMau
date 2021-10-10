package panel;

import component.Card;
import model.Model_Card;
import swing.ScrollBar;
import swing.WrapLayout;
import javax.swing.ImageIcon;

public class ProductPnl extends javax.swing.JPanel {

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
        
        panel.revalidate();
        panel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
