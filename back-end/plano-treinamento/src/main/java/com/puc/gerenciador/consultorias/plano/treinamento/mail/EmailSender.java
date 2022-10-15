package com.puc.gerenciador.consultorias.plano.treinamento.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

@Slf4j
@Component
public class EmailSender {

    @Value("${email.username}")
    private String userName;

    @Value("${email.password}")
    private String password;

    @Value("${email.sender}")
    private String sender;

    private Properties emailProperties;

    public EmailSender(
            @Value("${mail.smtp.auth:true}") final String smtpAuth,
            @Value("${mail.smtp.starttls.enable:true}") final String smtpStarttlsEnable,
            @Value("${mail.smtp.host:smtp-relay.sendinblue.com}") final String smtpHost,
            @Value("${mail.smtp.port:587}") final String smtpPort,
            @Value("${mail.smtp.ssl.trust:smtp-relay.sendinblue.com}") final String smtpSslTrust
    ) {
        emailProperties = new Properties();

        emailProperties.put("mail.smtp.auth", smtpAuth);
        emailProperties.put("mail.smtp.starttls.enable", smtpStarttlsEnable);
        emailProperties.put("mail.smtp.host", smtpHost);
        emailProperties.put("mail.smtp.port", smtpPort);
        emailProperties.put("mail.smtp.ssl.trust", smtpSslTrust);

    }

    public void sendEmail(final EmailObject emailObject) {

        Session session = Session.getInstance(emailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {


            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(emailObject.sendTo));

            message.setSubject(emailObject.subject);

            final MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(emailObject.messageBody, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            if (emailObject.hasAttachment) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                attachmentBodyPart.attachFile(emailObject.attachement);
                multipart.addBodyPart(attachmentBodyPart);
            }

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            log.error("Erro ao enviar mensagem", e);
        } catch (IOException e) {
            log.error("Erro no envio", e);
        }

    }


}
