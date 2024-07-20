package com.example.Lab3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "Lab3_Bai5Servlet", value = "/send-email")
public class Lab3_Bai5Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/send_mail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("thongbao", "Gửi mail thành công");

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        props.setProperty("mail.smtp.host", "smtp.outlook.com");
        props.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                String username = req.getParameter("from");
                String password = req.getParameter("password");;

                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(req.getParameter("from")));
            message.setRecipients(Message.RecipientType.TO, req.getParameter("to"));
            message.setSubject(req.getParameter("subject"), "utf-8");
            message.setText(req.getParameter("body"), "utf-8", "html");
            message.setReplyTo(message.getFrom());
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        this.doGet(req, resp);
    }
}
