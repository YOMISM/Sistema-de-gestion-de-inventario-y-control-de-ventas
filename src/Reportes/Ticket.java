/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.output.PrinterOutputStream;
import inventario.Clientes;
import inventario.ClientesBD;
import inventario.ObtenerParametros;
import inventario.Ventas;
import inventario.VentasBD;
import javax.print.PrintService;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author angel
 */
public class Ticket {
    private EscPos escpos;
    private final int numeroFactura;
    private final Connection conexion;
    private final ObtenerParametros parametros;
    private final double tasa;
    
    private Ticket(int numeroFactura, ObtenerParametros parametros, Connection conexion){
        this.conexion = conexion;
        this.numeroFactura = numeroFactura;
        this.parametros = parametros;
        tasa = parametros.getTasa();
    }
    public boolean conectarImpresora() {
        try {
        
            // Conectar a la impresora (ajusta el nombre según lo que veas en la lista)
            PrintService printService = PrinterOutputStream.getPrintServiceByName("POS-80");
            if (printService == null) {
                System.out.println("Impresora POS-80 no encontrada.");
            }
            
            if (printService != null) {
                PrinterOutputStream printerOutputStream = new PrinterOutputStream(printService);
                escpos = new EscPos(printerOutputStream);
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public void cerrarConexion() {
        try {
            if (escpos != null) {
                escpos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void crearTicket() throws SQLException{
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fecha = sdf.format(new Date());
            
            Style titulo = new Style()
                .setFontSize(Style.FontSize._2, Style.FontSize._2)
                .setBold(true)
                .setJustification(Style.Justification.Center);
            
            Style normal = new Style()
                .setJustification(Style.Justification.Left_Default);
            
            Style derecha = new Style()
                .setJustification(Style.Justification.Right);
            
            Style info = new Style().setFontSize(Style.FontSize._1, Style.FontSize._1);
            // Encabezado 
            escpos.writeLF(titulo, "PAPELERIA A&M EL CARRIL")
                  .writeLF(normal, "Fecha: " + fecha)
                  .writeLF("------------------------------------------------")
                  .writeLF("ARTICULO         CANT   PRECIO")
                  .writeLF("------------------------------------------------");                  
                    
            //Detalles de venta  
            VentasBD ventas = new VentasBD(conexion);
            System.out.println(conexion.getClientInfo());
            System.out.println(numeroFactura);
            ResultSet detallesVenta = ventas.getDatosFactura(numeroFactura);
            double total = 0;
            while (detallesVenta.next()){
                int cantidad = detallesVenta.getInt(1);
                String producto = detallesVenta.getString(2); 
                double precio = detallesVenta.getDouble(3) * tasa;
                total = cantidad * precio;
                escpos.writeLF(producto+"         "+cantidad+"     "+precio+"Bs.");
            }
            escpos.writeLF("------------------------------------------------");
            
            //Totales
            escpos.writeLF(derecha, "TOTAL:        "+redondear(total)+"Bs.")
                  .writeLF("------------------------------------------------");
           
            //Final
            escpos.writeLF(titulo, "¡GRACIAS POR SU COMPRA!")
                  .writeLF(info, "TICKET NO FISCAL")
                  .feed(3)
                  .cut(EscPos.CutMode.FULL);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void imprimir(int numeroFactura, ObtenerParametros parametros, Connection conexion) throws SQLException{
        Ticket impresora = new Ticket(numeroFactura, parametros, conexion);
        if (impresora.conectarImpresora()) {
            System.out.println("Conexión exitosa");
            impresora.crearTicket();
            impresora.cerrarConexion();
        } else {
            System.out.println("Error al conectar con la impresora");
        }
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    private double redondear(double numero){
        int decimales = 2;
        double resultado;
        BigDecimal bd = new BigDecimal(numero);
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        resultado = bd.doubleValue();
    return resultado;
    }
    
    private Clientes cargarCliente(int numeroFactura, Connection conexion){
        Clientes cliente = new Clientes();
        ClientesBD clienteBD = new ClientesBD(conexion);
        VentasBD ventaBD = new VentasBD(conexion);
        Ventas venta = new Ventas();
        venta = ventaBD.getVenta(numeroFactura);
        cliente = clienteBD.getCliente(venta.getIdCliente());
        return cliente;
    }
}
