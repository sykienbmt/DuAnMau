package helper;

import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Admin
 */
public class MailSender extends Thread{
    static {
        MailSender sender = new MailSender();
        sender.start();
    }
    static final List<MimeMessage> queue = new ArrayList<>();
    
    public static void queue(MimeMessage mail) {
        synchronized(queue) {
            queue.add(mail);
            queue.notify();
        }
    }
    
    @Override
    public void run() {
        while (true) {            
            try {
                synchronized(queue) {
                    if(queue.size() > 0) {
                        try {
                            MimeMessage mail = queue.remove(0);
                            Transport.send(mail);
                            //progressbar 
                            JOptionPane.showMessageDialog(new JFrame(), "The mail was sent");
                        } catch (MessagingException e) {
                            JOptionPane.showMessageDialog(new JFrame(), "Unable to send mail");
                        }    
                    }else{
                        queue.wait();
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
