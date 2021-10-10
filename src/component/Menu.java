package component;

import event.EventMenuSelected;
import model.ModelMenu;
import swing.ButtonCustom;
import swing.MenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import main.Login;
import main.Main;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    public void setEvent(EventMenuSelected event) {
        this.event = event;
    }

    private MigLayout layout;
    private JPanel panelMenu;
    private JButton cmdMenu;
    private JButton cmdLogOut;
    private Header header;
    private Bottom bottom;
    private EventMenuSelected event;
    private Login login;

    public Menu() {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "5[]0[]push[60]0"));
        panelMenu = new JPanel();
        header = new Header();
        bottom = new Bottom();
        createButtonMenu();
        createButtonLogout();
        panelMenu.setOpaque(false);
        layout = new MigLayout("fillx, wrap", "0[fill]0", "0[]3[]0");
        panelMenu.setLayout(layout);
        add(cmdMenu, "pos 1al 0al 100% 50");
        add(cmdLogOut, "pos 1al 1al 100% 100, height 60!");
        add(header);
        add(panelMenu);
        add(bottom);
    }

    public void addMenu(ModelMenu menu) {
        MenuItem item = new MenuItem(menu.getIcon(), menu.getMenuName(), panelMenu.getComponentCount());
        item.addEvent(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                clearMenu(index);
            }
        });
        item.addEvent(event);
        panelMenu.add(item);
    }

    private void createButtonMenu() {
        cmdMenu = new JButton();
        cmdMenu.setContentAreaFilled(false);
        cmdMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMenu.setIcon(new ImageIcon(getClass().getResource("/icon/menu-bar.png")));
        cmdMenu.setBorder(new EmptyBorder(5, 12, 5, 12));
    }

    private void createButtonLogout() {
        cmdLogOut = new ButtonCustom();
        cmdLogOut.setIcon(new ImageIcon(getClass().getResource("/icon/exit.png")));
        
//        cmdLogOut.addActionListener(new java.awt.event.ActionListener() {           
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int choice = JOptionPane.showConfirmDialog(new Frame(), "Do you want to logout ?", "Confimation",JOptionPane.YES_NO_OPTION);
//                if (choice == JOptionPane.YES_OPTION) {
//                    Login lg = new Login();
//                    Main mn = new Main();
//                    mn.dispose();
//                    lg.setVisible(true);
//                    
//                }
//            }
//        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, new Color(125, 60, 152  ), 0, getHeight(), new Color(34, 153, 84 ));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    private void clearMenu(int exceptIndex) {
        for (Component com : panelMenu.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.getIndex() != exceptIndex) {
                item.setSelected(false);
            }
        }
    }

    public void addEventMenu(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    public void addEventLogout(ActionListener event) {
        cmdLogOut.addActionListener(event);
    }

    public void setAlpha(float alpha) {
        header.setAlpha(alpha);
        bottom.setAlpha(alpha);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
