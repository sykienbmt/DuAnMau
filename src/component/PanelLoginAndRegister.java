package component;

import helper.DBConnection;
import main.Main;
import swing.Button;
import swing.MyPasswordField;
import swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import model.Account;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private Account account;
    private Loading loading;
    
    public Account getUser() {
        return account;
    }
    
    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("ĐĂNG KÍ");
        label.setFont(new Font("sansserif", 1, 35));
        label.setForeground(new Color(165, 105, 189 ));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Tên");
        register.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Mật khẩu");
        register.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setText("ĐĂNG KÍ");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ten = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String pass = String.valueOf(txtPass.getPassword());
                account = new Account(0, ten, email, pass);
            }
        }); 
    }

    private void initLogin() {
        loading = new Loading();
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("ĐĂNG NHẬP");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(165, 105, 189));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Mật khẩu");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Quên mật khẩu ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        login.add(loading, "pos 10 400 100% 100%");
        Button cmd = new Button();
        cmd.setText("ĐĂNG NHẬP");
        login.add(cmd, "w 40%, h 40");     
        
        cmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String email = txtEmail.getText();
                String password = String.valueOf(txtPass.getPassword());
                loading.setVisible(true);
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            this.sleep(3000);                           
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        
                        try {
                            PreparedStatement pst = DBConnection.prepareStatement("select * from Account where Email='" + email + "'");
                            ResultSet rs = pst.executeQuery();
                                if (rs.next()) {
                                    String pass = rs.getString("pass");
                                    if (password.equals(pass)) {
                                        loading.setVisible(false);                                        
                                        Main ss = new Main();
                                        ss.show();
                                    } else {
                                        System.out.println("SAi");
                                    }
                                } else {
                                        System.out.println("email not found");
                                }
                        } catch (Exception e) {
                                    e.printStackTrace();
                        }
                    }
                }.start();  
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
