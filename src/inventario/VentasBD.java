/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author angel
 */
public class VentasBD {
    private PreparedStatement ps;
    private final Connection conexion;

    public VentasBD(Connection conexion) {
        this.conexion = conexion;
    }
    
    public boolean agregarVenta(Ventas venta){
        boolean ok = false;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("INSERT INTO `ventas` (`idVenta`, `fecha`, `id_cliente`, `monto`) VALUES (?, ?, ?, ?);");
                ps.setInt(1, venta.getIdVenta());
                ps.setDate(2, venta.getFecha());
                ps.setString(3, venta.getIdCliente());
                ps.setDouble(4, venta.getMonto());
                ps.executeUpdate(); 
                ok = true;
            }
            else{
                System.out.println("Conexion nula");
            }
            System.out.println("venta registrada");
        }
        catch(SQLException cnfe){
            System.out.println("Error en VentasBD agregarVenta "+ cnfe.getMessage());
        }                    
        return ok;
    }
    
    public Ventas getVenta(int idVenta){
        Ventas venta = new Ventas();
        ResultSet resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM `ventas` WHERE `idVenta` = ?");
                ps.setInt(1, idVenta);
                resultados = ps.executeQuery();
                while(resultados.next()){
                    venta.setIdVenta(resultados.getInt(1));
                    venta.setFecha(resultados.getDate(2));
                    venta.setIdCliente(resultados.getString(3));
                    venta.setMonto(resultados.getDouble(4));
                }              
            }
            else{
                System.out.println("conexion nula");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al obtener proveedor "+ cnfe.getMessage());
        }
        return venta;
    }
    
    public ResultSet getDatosFactura(int idVenta){
        ResultSet resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT \n" +
                                        "    dv.cantidad,\n" +
                                        "    p.descripcion,\n" +
                                        "    dv.precioUnidad\n" +
                                        "FROM \n" +
                                        "    detallesventa dv\n" +
                                        "INNER JOIN \n" +
                                        "    Productos p ON dv.idProducto = p.codigo\n" +
                                        "INNER JOIN \n" +
                                        "    Ventas v ON dv.idVenta = v.IdVenta\n" +
                                        "WHERE \n" +
                                        "    v.IdVenta = " + idVenta);
                
                resultados = ps.executeQuery();
                System.out.println("datos de factura devueltos con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error en VentasBD getDatosFactura "+cnfe.getMessage());
        }
        
        return resultados;
    }
    
    public ResultSet getVentas(){
        ResultSet resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM Ventas");
                resultados = ps.executeQuery();
                System.out.println("ventas devueltas con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error en VentasBD "+cnfe.getMessage());
        }
        
        return resultados;
    }
}
