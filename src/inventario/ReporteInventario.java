/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import Servidor.ConexionBD;
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
public class ReporteInventario {
    public ReporteInventario(Connection conn){
    try {

            // Cargar el archivo .jasper (reporte compilado
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(
                "src/productos.jasper");

            // Parámetros (opcional)
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("TITULO", "Reporte de Prueba");

            // Llenar el reporte con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport, parametros, conn);

            // Exportar a PDF
            

            // Mostrar el reporte en una ventana
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
}
