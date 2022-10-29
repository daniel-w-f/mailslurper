package daniel.w.f;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        try {
            // in etc/host mapped 'blaserver' to 127.0.0.1
            String smtpHost = "blaserver";
            versendeEMail("Atreff", "Lorem Ipsum", "a@b.c", "d@e.f", smtpHost);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void versendeEMail( String betreff, String inhalt, String absender, String empfaenger, String smtpHost ) throws MessagingException
    {
       Properties properties = System.getProperties();
       properties.setProperty( "mail.smtp.host", smtpHost );
       properties.put( "mail.smtp.port", 1025);
       Session session = Session.getDefaultInstance( properties );
       MimeMessage message = new MimeMessage( session );
       message.setFrom( new InternetAddress( absender ) );
       message.addRecipient( Message.RecipientType.TO, new InternetAddress( empfaenger ) );
       message.setSubject( betreff, "ISO-8859-1" );
       message.setText( inhalt, "UTF-8" );
       Transport.send( message );
    }
}
