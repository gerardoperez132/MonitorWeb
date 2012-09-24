package ve.gob.gobiernoenlinea.config;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author gerardo
 */
public class properties {
 
  public Properties getProperties() {
        try {
            //se crea una instancia a la clase Properties
            Properties propiedades = new Properties();
            //se leen el archivo .properties
            propiedades.load( getClass().getResourceAsStream("mail.properties") );
            //si el archivo de propiedades NO esta vacio retornan las propiedes leidas
            if (!propiedades.isEmpty()) {                
                return propiedades;
            } else {//sino  retornara NULL
                return null;
            }
        } catch (IOException ex) {
            return null;
        }
   }
}   

