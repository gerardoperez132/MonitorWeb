package ve.gob.gobiernoenlinea.buscadorWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import ve.gob.gobiernoenlinea.config.properties;
import java.util.Properties;

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
 Properties propiedades = new properties().getProperties();//Declaro el objeto q contiene los valores de mis propiedades
 String urlEnte = propiedades.getProperty("urlEnte");
    
        URL url = new URL(urlEnte);
        BufferedReader webEnteGobierno = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer datos = new StringBuffer();
        
       while ((datos.append(webEnteGobierno.readLine())) != null) {
           
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

