package component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class PhongBtn extends JButton{
    private Color color1 = Color.decode("#7B7D7D");
    private Color color2 = Color.decode("#B3B6B7");
    private float alpha = 0.3f;
    private boolean mouseOver;
    private boolean pressed;
    private Point pressedLocation;
    private float pressedSize;
    private float sizeSpeed = 1f;
    private float alphaPressed = 0.5f;
    
    public float getSizeSpeed() {
        return sizeSpeed;
    }

    public void setSizeSpeed(float sizeSpeed) {
        this.sizeSpeed = sizeSpeed;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public PhongBtn() {
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(20, 25, 20, 25));     
    }
    
    public void getIdPhong (Integer id) {
        
    }
    
    public void tenPhong(String phong) {
        setText(phong);
    }
   
    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Create Gradients Color
        GradientPaint gra = new GradientPaint(0, 0, color1, width, 0, color2);
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, width, height, height, height);
        if (pressed) {
            paintPressed(g2);
        }
        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }

    private void paintPressed(Graphics2D g2) {
        if (pressedLocation.x - (pressedSize / 2) < 0 && pressedLocation.x + (pressedSize / 2) > getWidth()) {
            alphaPressed -= 0.05f;
            if (alphaPressed < 0) {
                alphaPressed = 0;
            }
        }
        g2.setColor(Color.WHITE);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alphaPressed));
        float x = pressedLocation.x - (pressedSize / 2);
        float y = pressedLocation.y - (pressedSize / 2);
        g2.fillOval((int) x, (int) y, (int) pressedSize, (int) pressedSize);
    }
}
