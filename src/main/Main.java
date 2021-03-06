package main;

import component.Menu;
import controller.DichVuController;
import controller.HoaDonController;
import controller.KhacHangController;
import controller.NhanVienController;
import controller.PhieuThuePhongController;
import controller.PhongController;
import controller.QlDichVuController;
import controller.ThongKeController;
import dialog.DoiPhongDialog;
import event.EventMenuSelected;
import model.ModelMenu;
import panel.HomePnl;
import panel.NhanVienPnl;
import panel.ProductPnl;
import panel.ThongKePnl;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import panel.PhongPnl;

public class Main extends javax.swing.JFrame {

    private PhongPnl phongPnl;
    private ProductPnl productPnl;
    private NhanVienPnl nhanVienpnl;
    private HomePnl HomePnl;
    private ThongKePnl thongKepnl;
    private MigLayout layout;
    private Animator animator;
    private Menu menu = new Menu();
    private JPanel main = new JPanel();
    private boolean menuShow;

    public Main() {
        initComponents();
        init();
        nhanVienpnl = new NhanVienPnl();
        NhanVienController nhanVienController = new NhanVienController(nhanVienpnl);
        phongPnl = new PhongPnl();
        PhongController phongController = new PhongController(phongPnl);
        productPnl= new ProductPnl();
        QlDichVuController qlDichVuController = new QlDichVuController(productPnl);
        DichVuController dichVuController = new DichVuController(phongPnl);
        PhieuThuePhongController phieuThuePhongController = new PhieuThuePhongController(phongPnl);
        KhacHangController khacHangController = new KhacHangController(phongPnl);
        
        HoaDonController hoaDonController = new HoaDonController(phongPnl);
        thongKepnl = new ThongKePnl();
        ThongKeController thongKeController = new ThongKeController(thongKepnl);
    }
    
    private void init() {
        layout = new MigLayout("fill", "0[]10[]5", "0[fill]0");
        body.setLayout(layout);
        main.setOpaque(false);
        main.setLayout(new BorderLayout());
        menu.addEventLogout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/icon/quiz.png"));
                int a = JOptionPane.showConfirmDialog(new Frame(), "X??c nh???n ????ng xu???t ?", "Logout", JOptionPane.YES_NO_OPTION, HEIGHT, icon);
                if (a == 0) {
                    Login login = new Login();
                    login.setVisible(true);
                    dispose();
                }
            }
        });
        
        menu.addEventMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        
        menu.setEvent(new EventMenuSelected() {      
            @Override
            public void selected(int index) {
                if (index == 0) {
                    showForm(phongPnl);
                } else if (index == 1) {
                    showForm(nhanVienpnl);
                } else if (index == 2) {
                    showForm(thongKepnl);
                } else if (index == 3) {
                    showForm(productPnl);
                }
            }
        });
        menu.addMenu(new ModelMenu("Ph??ng", new ImageIcon(getClass().getResource("/icon/room.png"))));
        menu.addMenu(new ModelMenu("Nh??n vi??n", new ImageIcon(getClass().getResource("/icon/id-card.png"))));
        menu.addMenu(new ModelMenu("Th???ng k??", new ImageIcon(getClass().getResource("/icon/statistics.png"))));
        menu.addMenu(new ModelMenu("S???n ph???m", new ImageIcon(getClass().getResource("/icon/food.png"))));
        menu.addMenu(new ModelMenu("Kh??ch h??ng", new ImageIcon(getClass().getResource("/icon/data.png"))));        
        menu.addMenu(new ModelMenu("Admin", new ImageIcon(getClass().getResource("/icon/key.png"))));
        body.add(menu, "w 50!");
        body.add(main, "w 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuShow) {
                    width = 50 + (150 * (1f - fraction));
                    menu.setAlpha(1f - fraction);
                } else {
                    width = 50 + (150 * fraction);
                    menu.setAlpha(fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                body.revalidate();
            }

            @Override
            public void end() {
                menuShow = !menuShow;
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        showForm(new HomePnl());
    }

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1290, 750));

        body.setPreferredSize(new java.awt.Dimension(1200, 800));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    // End of variables declaration//GEN-END:variables
}
