/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ProveedoresBD {
    private ResultSet resultados;
    private PreparedStatement ps;
    private final Connection conexion;
    
    public ProveedoresBD(Connection con){
        conexion = con;
    }
    
    public ResultSet cargarProveedores(){
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM proveedores");
                resultados = ps.executeQuery();
                System.out.println("Proveedores devueltos con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error en ProveedoresBD "+cnfe.getMessage());
        }
        
        return resultados;
    }
    public Proveedorees buscadorProveedor(String id){
        Proveedorees proveedor = new Proveedorees();
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM proveedores WHERE nombre = ? OR rif_proveedor = ?;");
                ps.setString(1, id);
                ps.setString(2, id);
                resultados = ps.executeQuery();
                while(resultados.next()){
                    proveedor.setRif(resultados.getString(1));
                    System.out.println(proveedor.getRif());
                    proveedor.setNombre(resultados.getString(2));
                    proveedor.setDireccion(resultados.getString(3));
                    proveedor.setTelefono(resultados.getString(4));
                }
                
            }
            else{
                System.out.println("conexion nula");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al obtener proveedor "+ cnfe.getMessage());
        }
        return proveedor;
    }
    
    public Proveedorees getProveedor(String rif){
        Proveedorees proveedor = new Proveedorees();
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM `proveedores` WHERE `rif_proveedor` = ?;");
                ps.setString(1, rif);
                resultados = ps.executeQuery();
                while(resultados.next()){
                    proveedor.setRif(resultados.getString(1));
                    proveedor.setNombre(resultados.getString(2));
                    proveedor.setDireccion(resultados.getString(3));
                    proveedor.setTelefono(resultados.getString(4));
                }
                
            }
            else{
                System.out.println("conexion nula");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al obtener proveedor "+ cnfe.getMessage());
        }
        return proveedor;
    }
    
    public void actualizarProveedor(Proveedorees proveedor){
        try{
            if (conexion != null){
                ps = conexion.prepareStatement("UPDATE `proveedores` SET "
                        + "`nombre`= ?,`direccion`= ?, `telefono`= ?"
                        + "WHERE rif_proveedor = ?;");
                ps.setString(1, proveedor.getNombre());
                ps.setString(2, proveedor.getDireccion());
                ps.setString(3, proveedor.getTelefono());
                ps.setString(4, proveedor.getRif());
                ps.executeUpdate();
                System.out.println("proveedor modificado con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al actualizar el proveedor "+cnfe.getMessage());
        }
    }
    
    public String getNombreProveedor(String codigo) throws SQLException{
        String resultado = "";
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM `proveedores` WHERE `rif_proveedores` = ?");
                ps.setString(1, codigo);
                resultados = ps.executeQuery();
            }
        }
        catch(SQLException cnfe){
            System.out.println(cnfe.getSQLState());
        }
        while(resultados.next()){
            resultado = resultados.getString(2);
        }
        return resultado;
        
    }
    
    public String rifProveedor(String nombre) throws SQLException{
        resultados = null;
        String resultado = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM proveedores WHERE nombre LIKE " + "'"+nombre+"'");
                resultados = ps.executeQuery();
            }
        }
        catch(SQLException cnfe){
            System.out.println("error en proveedores");
            System.out.println(cnfe.getSQLState());
        }
        while (resultados.next()){
            resultado = resultados.getString(1);
        }
        return resultado;   
    }
    
    public boolean SetProveedor(String rif_proveedor, String nombre, String Direccion, String telefono ){
               boolean funciona = true;
        try{
            if(conexion != null){
                ps = conexion.prepareStatement("INSERT INTO `proveedores` (`rif_proveedor`, `nombre`, `direccion`, `telefono`) "
                        + "VALUES (?,?,?,?);");
                ps.setString(1, rif_proveedor);
                ps.setString(2, nombre);
                ps.setString(3, Direccion);
                ps.setString(4, telefono);
                ps.executeUpdate();
                System.out.println("proveedor agregado con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println(cnfe.getMessage());
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
            funciona = false;
        }
        return funciona; 
    }
    
    public void eliminarProveedor(String rif){
        try{
            if(conexion != null){
                ps = conexion.prepareCall("DELETE FROM proveedores WHERE `proveedores`.`rif_proveedor` = ?");
                ps.setString(1, rif);
                ps.executeUpdate();

            }
        }
        catch(Exception e){
                System.out.println("Error al eliminar proveedor " + e.getMessage());               
        }
    }
    
}
//