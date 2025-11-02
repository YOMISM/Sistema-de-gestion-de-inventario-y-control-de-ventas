/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class ProductosBD {
    private ResultSet resultados;
    private PreparedStatement ps;
    private final Connection conexion;

    public ProductosBD(Connection conexion) {
        this.conexion = conexion;
    }
    
    public Productos getProducto(String codigo) throws SQLException{
        Productos producto = new Productos();
        resultados = null;
            if(conexion == null || codigo.trim().isEmpty()){
                return null;
            }
        try{
                ps = conexion.prepareCall("SELECT * FROM `productos` WHERE `codigo` = ?");
                ps.setString(1, codigo);
                resultados = ps.executeQuery();
                if(resultados.next()){
                    producto.setCodigo(resultados.getString(1));
                    producto.setNombre(resultados.getString(2)); 
                    producto.setCantidad(resultados.getInt(3));
                    producto.setCantidadMin(resultados.getInt(4));
                    producto.setPrecioCosto(resultados.getFloat(5));
                    producto.setGanancia(resultados.getFloat(6));
                    producto.setDepartamento(resultados.getInt(7));
                    producto.setIva(resultados.getFloat(8));
                    producto.setRif(resultados.getString(9));
                }
                System.out.println("producto "+ producto.getNombre() + " devuelto con exito");
            
        }
        catch(SQLException cnfe){
            System.err.println("Error en ProductosBD getProducto "+ cnfe.getMessage());
            producto = null;
        }
        return producto;
    }
    
    public ResultSet obtenerProductos(){
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM productos");
                resultados = ps.executeQuery();
                System.out.println("Productos devueltos con exito");
            }
        }
        catch(SQLException cnfe){
            System.err.println("Error en ProductosBD obtenerProductos "+cnfe.getMessage());
        }
        
        return resultados;
    }
    
    public ResultSet getProductosDepartamentos(int departamento){
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM productos WHERE ID_departamento = " + departamento);
                
                resultados = ps.executeQuery();
                System.out.println("Departamentos devueltos con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println(cnfe.getMessage());
        }
        
        return resultados;
    }
    
    public void updateProducto(Productos producto){
        try{
            if (conexion != null){
                ps = conexion.prepareStatement("UPDATE `productos` SET "
                        + "`descripcion`= ?,`cantidadMin`= ?,"
                        + "`precioCosto`= ?,`ganancia`= ?,`ID_departamento`= ?,"
                        + "`iva`= ?, WHERE codigo = ?;");
                ps.setString(1, producto.getNombre());
                ps.setInt(2, producto.getCantidadMin());
                ps.setFloat(3, producto.getPrecioCosto());
                ps.setFloat(4, producto.getGanancia());
                ps.setInt(5,producto.getDepartamento());
                ps.setFloat(6, producto.getIva());
                ps.setString(7, producto.getCodigo());
                ps.executeUpdate();
                System.out.println("producto modificado con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al actualizar el producto "+cnfe.getMessage());
        }
    }
    
    public void actualizarCantidad(Productos producto){
        try{
            if (conexion != null){
                ps = conexion.prepareStatement("UPDATE `productos` SET "
                        + "`cantidad`= ? WHERE codigo = ?;");
                ps.setInt(1, producto.getCantidad());
                ps.setString(2, producto.getCodigo());

                ps.executeUpdate();
                System.out.println("producto modificado con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al actualizar el producto "+cnfe.getMessage());
        }
    }
    
    public void eliminarProductos(String codigo){
        try{
            if(conexion != null){
                ps = conexion.prepareCall("DELETE FROM productos WHERE `productos`.`codigo` = ?");
                ps.setString(1, codigo);
                ps.executeUpdate();

            }
        }
        catch(SQLException e){
                System.out.println("Error al eliminar producto " + e.getMessage());               
        }
    }
    
    public Productos buscadorProductos(String dato){
        Productos producto = new Productos();
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM productos WHERE descripcion = ? OR codigo = ?;");
                ps.setString(1, dato);
                ps.setString(2, dato);
                resultados = ps.executeQuery();
                while(resultados.next()){
                    producto.setCodigo(resultados.getString(1));
                    producto.setNombre(resultados.getString(2)); 
                    producto.setCantidad(resultados.getInt(3));
                    producto.setPrecioCosto(resultados.getFloat(5));
                    producto.setGanancia(resultados.getFloat(6));
                    producto.setIva(resultados.getFloat(8));
                }
                
            }
            else{
                System.out.println("conexion nula");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al obtener producto "+ cnfe.getMessage());
        }
        return producto;
    }
    
    public ArrayList getProductosEnCantidadMinima(){
        ArrayList<Productos> productos = new ArrayList();
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM productos WHERE cantidad <= cantidadMin;");
                resultados = ps.executeQuery();
            }
            while(resultados.next()){
                Productos producto = new Productos();
                producto.setCodigo(resultados.getString(1));
                producto.setNombre(resultados.getString(2)); 
                producto.setCantidad(resultados.getInt(3));
                producto.setCantidadMin(resultados.getInt(4));
                producto.setPrecioCosto(resultados.getFloat(5));
                producto.setGanancia(resultados.getFloat(6));
                producto.setDepartamento(resultados.getInt(7));
                producto.setIva(resultados.getFloat(8));
                producto.setRif(resultados.getString(9));
                productos.add(producto);        
            }
        }
        catch(SQLException cnfe){
            System.err.println("Error en ProductosBD getProductosEnCantidadMinima "+cnfe.getMessage());
            productos = null;
        }
        return productos;
    }
}
