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
public class ClientesBD {
    private ResultSet resultados;
    private PreparedStatement ps;
    private final Connection conexion;

    public ClientesBD(Connection conexion) {
        this.conexion = conexion;
    }
    
    public ResultSet cargarClientes(){
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM cliente");
                resultados = ps.executeQuery();
                System.out.println("Clientes devueltos con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error en ClientesBD "+cnfe.getMessage());
        }
        return resultados;
        
    }
    public Clientes getCliente(String idCliente){
        Clientes cliente = new Clientes();
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM `cliente` WHERE idCliente = ?;");
                ps.setString(1, idCliente);
                resultados = ps.executeQuery();
                while(resultados.next()){
                    cliente.setIdentificador(resultados.getString(1));
                    cliente.setNombre(resultados.getString(2));
                    cliente.setDireccion(resultados.getString(3));
                    cliente.setTelefono(resultados.getString(4));
                }
                
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al obtener cliente "+ cnfe.getMessage());
        }
        return cliente;
    }
    
    public boolean SetCliente(String idCliente, String nombre, String Direccion, String telefono ){
               boolean funciona = true;
        try{
            if(conexion != null){
                ps = conexion.prepareStatement("INSERT INTO `cliente` (`idCliente`, `nombre`, `direccion`, `telefono`) "
                        + "VALUES (?,?,?,?);");
                ps.setString(1, idCliente);
                ps.setString(2, nombre);
                ps.setString(3, Direccion);
                ps.setString(4, telefono);
                ps.executeUpdate();
                System.out.println("cliente agregado con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println(cnfe.getMessage());
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
            funciona = false;
        }
        return funciona; 
    }
    
    public void actualizarCliente(Clientes cliente){
        try{
            if (conexion != null){
                ps = conexion.prepareStatement("UPDATE `cliente` SET "
                        + "`nombre`= ?,`direccion`= ?, `telefono`= ?"
                        + "WHERE idCliente = ?;");
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getDireccion());
                ps.setString(3, cliente.getTelefono());
                ps.setString(4, cliente.getIdentificador());
                ps.executeUpdate();
                System.out.println("cliente modificado con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al actualizar el cliente "+cnfe.getMessage());
        }
    }
    
    public void eliminarCliente(String identificador){
        try{
            if(conexion != null){
                ps = conexion.prepareCall("DELETE FROM cliente WHERE `cliente`.`idCliente` = ?");
                ps.setString(1, identificador);
                ps.executeUpdate();

            }
        }
        catch(Exception e){
                System.out.println("Error al eliminar cliente " + e.getMessage());               
        }
    }
    
}
