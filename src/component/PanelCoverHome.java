package component;

import swing.ButtonOutLine;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCoverHome extends javax.swing.JPanel {

    private final DecimalFormat df = new DecimalFormat("##0.###");
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    private JLabel description2;
    private ButtonOutLine button;
    private boolean isLogin;

    public PanelCoverHome() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]25[]10[]10[]25[]push");
        setLayout(layout);
        init();

    }

    private void init() {
        title = new JLabel("DỰ ÁN JAVA - GROUP FPT");
        title.setFont(new Font("corbel", 1, 35));
        title.setForeground(new Color(245, 245, 245));
        add(title);
        title = new JLabel("DỰ ÁN QUẢN LÝ KHÁCH SẠN");
        title.setFont(new Font("corbel", 1, 25));
        title.setForeground(new Color(245, 245, 245));
        add(title);
        description = new JLabel("Nguyễn Sỹ Kiên");
        description.setFont(new Font("Segoe UI Light", 1, 20));
        description.setForeground(new Color(245, 245, 245));
        add(description);
        description1 = new JLabel("Nguyễn Sơn Đông");
        description1.setFont(new Font("Segoe UI Light", 1, 20));
        description1.setForeground(new Color(245, 245, 245));
        add(description1);
        description2 = new JLabel("Trần Tuấn Anh");
        description2.setFont(new Font("Segoe UI Light", 1, 20));
        description2.setForeground(new Color(245, 245, 245));
        add(description2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, new Color(179, 182, 183 ), 0, getHeight(), new Color(52, 152, 219));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    public void addEvent(ActionListener event) {
        this.event = event;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
