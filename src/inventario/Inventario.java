
package inventario;

import Servidor.ConexionBD;
import java.sql.Connection;
import javax.swing.JOptionPane;
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
        if (conexion != null){
           iniciarAlmacen(conexion, "Administrador");
        }
        else {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
    }
    
    
}
