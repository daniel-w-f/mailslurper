import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void versendeEMail( String betreff, String inhalt, String absender, String empfaenger, String smtpHost ) throws MessagingException
    {
       Properties properties = System.getProperties();
       properties.setProperty( "mail.smtp.host", smtpHost );
       Session session = Session.getDefaultInstance( properties );
       MimeMessage message = new MimeMessage( session );
       message.setFrom( new InternetAddress( absender ) );
       message.addRecipient( Message.RecipientType.TO, new InternetAddress( empfaenger ) );
       message.setSubject( betreff, "ISO-8859-1" );
       message.setText( inhalt, "UTF-8" );
       Transport.send( message );
    }
}
