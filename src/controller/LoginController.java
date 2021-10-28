/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.NhanVienDAO;
import dialog.getPass;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Administrator
 */
public class LoginController {
    getPass view ;
    NhanVienDAO nhanVienDAO= new NhanVienDAO();
    
    public LoginController(getPass view) {
        this.view = view;
        view.setController(this);
    }
    
    public void resetVerifycode(String email ,String code){
        nhanVienDAO.resetVerifycode(email, code);
    }
    
    public String getVerifycode(String email){
        List<Object[]> data = nhanVienDAO.getVerifycode(email);
        return data.get(0)[0].toString();
    }
    
    public void updatePass(String email ,String pass){
        nhanVienDAO.updatePass(email, pass);
    }
    
    public void sendMail(Object[] info){
        final String username = "sikienbmto1@gmail.com";
        final String password = "01263500";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        //đăng nhập gmail
        Session session = Session.getInstance(prop,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("EmailFromASMJava3"));
                message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(info[0].toString())
                );
                message.setSubject(info[1].toString());
                message.setText(info[2].toString());
                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
    }
}
