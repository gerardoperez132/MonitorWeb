package ve.gob.gobiernoenlinea.monitor;


import ve.gob.gobiernoenlinea.config.properties;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import ve.gob.gobiernoenlinea.buscadorWeb.Buscador;

/**
 * @author   @gerardoperez132
 *
  */
public class MonitorWeb
{
  //  public static void main(String[] args) { 
  public void Monitor () {
       Properties propiedades = new properties().getProperties();//Declaro el objeto q contiene los valores de mis propiedades
       Buscador b = new Buscador () ; //declaro el objeto
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            System.out.println("H:"+propiedades.getProperty("mailSmtpHost"));
            System.out.println("H:"+propiedades.getProperty("connectCorreo"));
            System.out.println("H:"+propiedades.getProperty("connectContraseña"));
            System.out.println("H:"+propiedades.getProperty("mailSmtpStarttlsEnable"));
            System.out.println("H:"+propiedades.getProperty("mailSmtpPort"));
            System.out.println("H:"+propiedades.getProperty("mailSmtpUser"));
            System.out.println("H:"+propiedades.getProperty("mailSmtpAuth"));
            System.out.println("H:"+propiedades.getProperty("correoDestino"));
            System.out.println("H:"+propiedades.getProperty("subject"));
            System.out.println("H:"+propiedades.getProperty("msjText"));
            
            props.setProperty("mail.smtp.host", propiedades.getProperty("mailSmtpHost"));
            props.setProperty("mail.smtp.starttls.enable", propiedades.getProperty("mailSmtpStarttlsEnable"));
            props.setProperty("mail.smtp.port", propiedades.getProperty("mailSmtpPort"));
            props.setProperty("mail.smtp.user", propiedades.getProperty("mailSmtpUser"));
            props.setProperty("mail.smtp.auth", propiedades.getProperty("mailSmtpAuth"));

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("MonitorGobE@cnti.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(propiedades.getProperty("correoDestino"))); 
            try  {         
            b.Bus();
                 }
            catch (Exception e){
            message.setSubject(propiedades.getProperty("subject"));
            message.setText(propiedades.getProperty("msjText"));
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(propiedades.getProperty("connectCorreo"), propiedades.getProperty("connectContrasena"));
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();
                }
             }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
