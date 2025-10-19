/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import Servidor.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class AgregarDatos {
    private ResultSet         resultados;
    private PreparedStatement ps;
    private final Connection  conexion = ConexionBD.getInstance();

    public AgregarDatos() {
    }

     public boolean insertarProducto(String codigo, String descripcion, int cantidad, int cantidadMin,float precioCosto, float ganancia, int departamento, float iva, String proveedor){
        boolean funciona = true;
        try{
            if(conexion != null){
                ps = conexion.prepareStatement("INSERT INTO productos "
                        + "(codigo, descripcion, cantidad, cantidadMin, precioCosto, ganancia, ID_departamento, iva, rif_proveedor) "
                        + "VALUES (?,?,?,?,?,?,?,?,?);");
                ps.setString(1, codigo);
                ps.setString(2, descripcion);
                ps.setInt(3, cantidad);
                ps.setInt(4, cantidadMin);
                ps.setFloat(5, precioCosto);
                ps.setFloat(6, ganancia);
                ps.setInt(7,departamento);
                ps.setFloat(8,iva);
                ps.setString(9,proveedor);
                ps.executeUpdate();
                System.out.println("producto agregado con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("el error ta aqui");
            System.out.println(cnfe.getMessage());
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
            funciona = false;
        }
        return funciona;
     }
}
