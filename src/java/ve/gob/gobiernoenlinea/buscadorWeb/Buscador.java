package ve.gob.gobiernoenlinea.buscadorWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author   @gerardoperez132
 */
  
 
public class  Buscador{
 public void Bus () throws MalformedURLException, IOException { 
   //public static void main(String[] args) throws MalformedURLException, IOException {
 String FinalHtml = "</html>";
 String FinalBody = "</body>";
 String datosEncontrados ;
 String urlEnte = "http://gobiernoenlinea.gob.ve/";
    
        URL url = new URL(urlEnte);
        BufferedReader webEnteGobierno = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer datos = new StringBuffer();
        
       while ((datos.append(webEnteGobierno.readLine())) != null) {
        //StringBuffer datos = new StringBuffer();
       // System.out.println("Antes de entrar al ciclo");
        datos.append(webEnteGobierno.readLine()) ;
            
                datos = new StringBuffer(datos);                 
                datosEncontrados = datos.toString();
        System.out.println(":"+datosEncontrados);
        
        if ( datos.indexOf(FinalHtml) > datos.indexOf(FinalBody)) {
                System.out.println(" Fin del Html:"+urlEnte);
                break;
        }
      }
    webEnteGobierno.close();
   }
}

