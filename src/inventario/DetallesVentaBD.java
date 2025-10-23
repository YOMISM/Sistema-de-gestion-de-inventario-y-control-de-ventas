/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class DetallesVentaBD {
    private PreparedStatement ps;
    private final Connection conexion;

    public DetallesVentaBD(Connection conexion) {
        this.conexion = conexion;
    }
    
    public boolean setDetalles(DetallesVenta detalles){
        boolean ok = false;
        System.out.println("detallesVenta, El valor de VentaID es " + detalles.getIdVenta());
        System.out.println("detallesVenta, El valor de IdProducto es "+ detalles.getIdProducto());
        
        try{
            if(conexion != null){
                ps = conexion.prepareStatement("INSERT INTO `detallesventa` (`idDetalleVenta`, `idVenta`, "
                        + "`idProducto`, `cantidad`, `precioUnidad`) "
                        + "VALUES (?, ?, ?, ?, ?);");
                ps.setString(1, null);
                ps.setInt(2, detalles.getIdVenta());
                ps.setString(3, detalles.getIdProducto());
                ps.setInt(4, detalles.getCantidad());
                ps.setDouble(5, redondear(detalles.getPrecioUnidad()));
                ps.executeUpdate();
                System.out.println("detalles venta agregado con exito");
                ok = true;
            }
        }
        catch(SQLException cnfe){
            System.err.println("DetallesVentaBD setDetalles "+cnfe.getMessage());
            JOptionPane.showMessageDialog(null,"DetallesVentaBD setDetalles " +cnfe.getMessage());
        }
        return ok;
    }
    
        private double redondear(double numero){
            int decimales = 2;
            double resultado;
            BigDecimal bd = new BigDecimal(numero);
            bd = bd.setScale(decimales, RoundingMode.HALF_UP);
            resultado = bd.doubleValue();
        return resultado;
    }
    
}
