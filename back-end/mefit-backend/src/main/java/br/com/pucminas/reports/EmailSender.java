package br.com.pucminas.reports;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    private final Properties emailProperties;

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

        final Session session = Session.getInstance(emailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {
            final Message message = setUpMessage(emailObject, session);

            Transport.send(message);
        } catch (MessagingException e) {
            log.error("Error while sending email ", e);
        } catch (IOException e) {
            log.error("IO error while sending email", e);
        }

    }

    private Message setUpMessage(EmailObject emailObject, Session session) throws MessagingException, IOException {
        final Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(sender));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailObject.sendTo));

        message.setSubject(emailObject.subject);

        final MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(emailObject.messageBody, "text/html; charset=utf-8");

        final Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        if (emailObject.hasAttachment) {
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(emailObject.attachment);
            multipart.addBodyPart(attachmentBodyPart);
        }

        message.setContent(multipart);
        return message;
    }


}
