package ve.gob.gobiernoenlinea.monitor;


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
       
       Buscador b = new Buscador () ; //declaro el objeto
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "probadoaplicacion@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("MonitorGobE@cnti.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress("gerardo.perez132@gmail.com")); 
            try  {         
            b.Bus();
                 }
            catch (Exception e){
            message.setSubject("Estatus de gobiernoenlinea.com");
            message.setText(
                "Hola, Soy un Monitor de la web Gobierno en linea " + 
                " Creado por Gerardo" + " Para Avisarte que no e podido acceder a la Web"+
                " Y Probablemente la Web este caida");
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("probadoaplicacion@gmail.com", "aplicacion");
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
