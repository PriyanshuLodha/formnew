package com.example.pdfcreator.service;

import com.example.pdfcreator.email.EmailSender;
import com.example.pdfcreator.email.PrivateMailService;
import com.example.pdfcreator.entity.ListOfUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class PrivateMailSender {

//    private PrivateMailService privateMailService;
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendPrivateMail(ListOfUser listOfUser) throws MessagingException {
        if (listOfUser != null && listOfUser.getListUser() != null) {
        for (int i=0;i<listOfUser.getListUser().size();i++){
            sendEmailWithAttachment(listOfUser.getListUser().get(i),buildEmail(listOfUser.getUsername(),listOfUser.getListUser().get(i)),listOfUser.getUsername(),listOfUser.getFilename());
//            privateMailService.setInternalFilename(listOfUser.getFilename());
//            privateMailService.send(listOfUser.getListUser().get(i),buildEmail(listOfUser.getUsername(),listOfUser.getListUser().get(i)));
        }
        }
    }
    private String buildEmail(String senderName, String receiverName) {
        return "Sent from "+senderName;
    }
    public void sendEmailWithAttachment(String to, String text,String sender,String filename){
        try {
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setTo(to);
            helper.setSubject("Internion (Document)");
            helper.setText(buildEmail(sender,to));
            byte[] pdfBytes = Files.readAllBytes(Paths.get("C:\\Users\\Priyanshu\\OneDrive\\Desktop\\Training\\pdfcreator\\src\\main\\java\\com\\example\\pdfcreator\\datafolder\\user1\\"+filename));
            Resource pdfAttachment = new ByteArrayResource(pdfBytes);
            helper.addAttachment("document.pdf", pdfAttachment);

            javaMailSender.send(message);
        }catch (MessagingException | IOException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}
