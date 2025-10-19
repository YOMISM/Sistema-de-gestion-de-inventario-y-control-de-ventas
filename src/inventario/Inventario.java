
package inventario;

import Servidor.ConexionBD;
import java.sql.Connection;
import static ventanas.AlmacenJframe.iniciarAlmacen;



/**
 *
 * @author angel
 */
public class Inventario {

    /**
     * @param args the command line arguments
     */
    Connection conexion;
    public static void main(String[] args) {
        new Inventario();
    }

    public Inventario(){
        conexion = ConexionBD.getInstance();
        iniciarAlmacen(conexion, "Administrador");
    }
    
    
}
