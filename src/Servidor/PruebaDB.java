package Servidor;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author angel
 */
public class PruebaDB {

    public PruebaDB() {
                try {

            // Conectar a la base de datos MySQL
            Connection conn = ConexionBD.getInstance();

            // Cargar el archivo .jasper (reporte compilado
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(
                "src/Invoice.jasper");

            // Parámetros (opcional)
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("TITULO", "Reporte de Prueba");

            // Llenar el reporte con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport, parametros, conn);

            // Exportar a PDF
            

            // Mostrar el reporte en una ventana
            JasperViewer.viewReport(jasperPrint, false);

            // Cerrar la conexión
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    public static void main(String[] args) {
        new PruebaDB();
    }
}
