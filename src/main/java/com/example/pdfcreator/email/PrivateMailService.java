package com.example.pdfcreator.email;

import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Primary
public class PrivateMailService implements EmailSender{
    private final JavaMailSender mailSender;
    static private String internalFilename;
    public PrivateMailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Override
    @Async
    public void send(String to, String email) throws MessagingException {
        try {
            MimeMessage mimeMessage= mailSender.createMimeMessage();
            MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setText(email,true);
            helper.setTo(to);
            helper.setSubject("Internion");
            helper.setFrom("priyanshulodha181@gmail.com");
            byte[] pdfBytes = Files.readAllBytes(Paths.get("C:\\Users\\Priyanshu\\OneDrive\\Desktop\\Training\\pdfcreator\\src\\main\\java\\com\\example\\pdfcreator\\datafolder\\"+internalFilename));
            Resource pdfAttachment = new ByteArrayResource(pdfBytes);
            mailSender.send(mimeMessage);
        } catch (MessagingException e){
            throw new IllegalStateException("failed to send email");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setInternalFilename(String file){
        this.internalFilename=file;
    }
}
