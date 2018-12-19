
package mailapp;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.net.*;
import javax.mail.internet.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class mail {
//    public void password(){
//        String pass= "";
//            JPasswordField passwordField = new JPasswordField();
//            Object[] obj = {"Please enter the password:\n\n", passwordField};
//            Object stringArray[] = {"OK","Cancel"};
//            if (JOptionPane.showOptionDialog(null, obj, "Need password",
//            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj) == JOptionPane.YES_OPTION)
//            pass = passwordField.getPassword().toString();
//    }
    public void sendM(String diaChiNhan, String thongDiep, String loiNhan, String filess) throws Exception{
        String userAdmin = "ngophutuathuy2018@gmail.com";
        String passAdmin = "huy12345";
       
        int port = 587;
        //Tạo đối tượng Properties và chỉ định thông tin host, port
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", port);
        try{
            Session se = Session.getInstance(p, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(userAdmin, passAdmin);
                }
            });
        //Tao mot doi tuong MimeMessage mac dinh (admin gui) 
        MimeMessage msg = new MimeMessage(se);
        //dia chi email admin
        msg.setFrom(new InternetAddress(userAdmin));
        //gắn địa chỉ người nhận
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(diaChiNhan));
     //   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cc));
        //Tiêu đề
        msg.setSubject(thongDiep);
        msg.setContent(thongDiep, "text/html; charset=UTF-8");
        
        // Nội dung email
        //Tạo phần tin nhắn
        BodyPart meBodyPart = new MimeBodyPart(); 
        meBodyPart.setText(loiNhan);
        //Tạo thông báo multipar 
        Multipart multipart = new MimeMultipart();
        //Đặt phần tin nhắn văn bản
        multipart.addBodyPart(meBodyPart);
        
       //tệp đính kèm 
        meBodyPart = new  MimeBodyPart();
        App_mail a = new App_mail();
     //   String file = a.filese.getText();
        String fileName = "file";
        //String filess="C:\\Users\\Admin\\Documents\\aa.txt";
        // = a.fileat;
        javax.activation.DataSource source = new FileDataSource(filess);   //đóng gói một tệp tin   
        meBodyPart.setDataHandler(new DataHandler(source));//thiết lập nội dung tệp tin
        meBodyPart.setFileName(source.getName());
        multipart.addBodyPart(meBodyPart);
        msg.setContent(multipart);
        //để phân tích và lưu trữ
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        //cung cấp các phương thức để lấy và thiết lập các phần con của nó.
//        Multipart multipart = new MimeMultipart();
//     

        msg.setSentDate(new Date());
        Transport.send(msg);
    }catch(Exception ex){
        ex.printStackTrace();
    }
    }
    public void fileAtt(String file,String diaChiNhan) throws Exception{
    }}
