/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author angel
 */
public class ConexionBD {
    private static Connection conexion = null;
    
    private static Connection conectarBD(){
        String url = "jdbc:mysql://" + "localhost:33065" + "/" + "inventario";
        String usuario = "root";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection(url, usuario, "");
            System.out.println("conexion exitosa");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("error al conectar a la base de datos");
        }
        return conexion;
    }
    private static Connection conectarBD(String manejador, String host, String BD, String usuario, String contrasena){
        String url = "jdbc:" + manejador + "://" + host + "/" + BD;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection(url, usuario, contrasena);
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("error");
        }
        return conexion;
        
    }
        public static Connection getInstance(){
        if (conexion == null){
            conexion = conectarBD();
        }
        return conexion;
    }
}
