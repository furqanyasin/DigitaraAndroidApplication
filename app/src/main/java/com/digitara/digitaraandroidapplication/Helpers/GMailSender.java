package com.digitara.digitaraandroidapplication.Helpers;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GMailSender extends Authenticator {
    private String mailhost = "smtp.gmail.com";
    private String password;
    private Session session;
    private String user;

    static {
        Security.addProvider(new JSSEProvider());
    }

    public GMailSender(String user2, String password2) {
        this.user = user2;
        this.password = password2;
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", this.mailhost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");
        this.session = Session.getDefaultInstance(props, this);
    }


    @Override // javax.mail.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.user, this.password);
    }

    public synchronized void sendMail(String subject, String body, String sender, String recipients) throws Exception {
        try {
            MimeMessage message = new MimeMessage(this.session);
            DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/plain"));
            message.setSender(new InternetAddress(sender));
            message.setSubject(subject);
            message.setText(body);
            message.setDataHandler(handler);
            if (recipients.indexOf(44) > 0) {
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            } else {
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
            }
            Transport.send(message);
        } catch (Exception e) {
            Log.d("mylog", "Error in sending: " + e.toString());
        }
        return;
    }

    public class ByteArrayDataSource implements DataSource {
        private byte[] data;
        private String type;

        public ByteArrayDataSource(byte[] data2, String type2) {
            this.data = data2;
            this.type = type2;
        }

        public ByteArrayDataSource(byte[] data2) {
            this.data = data2;
        }

        public void setType(String type2) {
            this.type = type2;
        }

        @Override // javax.activation.DataSource
        public String getContentType() {
            String str = this.type;
            if (str == null) {
                return "application/octet-stream";
            }
            return str;
        }

        @Override // javax.activation.DataSource
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(this.data);
        }

        @Override // javax.activation.DataSource
        public String getName() {
            return "ByteArrayDataSource";
        }

        public String getPhone() {
            return "ByteArrayDataSource";
        }

        @Override // javax.activation.DataSource
        public OutputStream getOutputStream() throws IOException {
            throw new IOException("Not Supported");
        }
    }
}
