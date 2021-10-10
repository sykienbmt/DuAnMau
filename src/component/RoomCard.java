package component;

import model.Model_Card;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class RoomCard extends javax.swing.JPanel {

    private final Model_Card data;
    private int y = 0;
    private int speed = 3;
    private boolean showing = true;

    public RoomCard(Model_Card data) {
        this.data = data;
        initComponents();
        setOpaque(false);    
        setPreferredSize(new Dimension(100, 100));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());
        add(jButton1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        Rectangle size = getAutoSize(data.getIcon());
        g2.drawImage(toImage(data.getIcon()), size.x, size.y, size.width, size.height, null);
        super.paintComponent(grphcs);
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, getHeight(), new Color(179, 182, 183, 50), 0, getHeight() - 30, new Color(52, 152, 219, 0));
        g2.setPaint(g);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    private Rectangle getAutoSize(Icon image) {
        int w = 200;
        int h = 50;
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
//        double xScale = (double) w / iw;
//        double yScale = (double) h / ih;
//        double scale = Math.max(xScale, yScale);
        int width = (int) (iw);
        int height = (int) (ih);
        int x = (w - width) / 5;
        int y = (h - height) / 5;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
