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
public class UsuariosBD {

    private ResultSet resultados;
    private PreparedStatement ps;
    private final Connection conexion;
    
    public UsuariosBD(Connection conexion) {
        this.conexion = conexion;
    }
    
    public boolean accederUsuario(String nombre, String clave){
        boolean acceder = false;
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM `usuarios` WHERE `nombre` LIKE ? AND `clave` LIKE ?;");
                ps.setString(1, nombre);
                ps.setString(2, clave);
                resultados = ps.executeQuery();
                while(resultados.next()){
                    System.out.println(resultados.getString(3));
                    if(resultados.getString(3) != null && resultados.getString(4)!=null){                       
                        acceder = true;
                        System.out.println("Incio de seccion exitoso");
                    }
                    else{
                        System.out.println("Datos incorrectos");
                    }
                }
                
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error al iniciar seccion "+ cnfe.getMessage());
        }      
        
    return acceder;
    }
}
