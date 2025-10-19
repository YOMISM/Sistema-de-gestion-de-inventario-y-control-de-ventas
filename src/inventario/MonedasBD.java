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
public class MonedasBD {
private ResultSet resultados;
private PreparedStatement ps;
private final Connection conexion;

    public MonedasBD(Connection conexion) {
        this.conexion = conexion;
    }
    
    public ResultSet cargarMonedas(){
        resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM monedas");
                resultados = ps.executeQuery();
                System.out.println("Monedas devueltas con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error en MonedasBD "+ cnfe.getMessage());
        }
        return resultados;
    }
    
    public ResultSet cargarDepartamentos(){
    resultados = null;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM departamentos");
                resultados = ps.executeQuery();
                System.out.println("Departamentos devueltos con exito");
            }
        }
        catch(SQLException cnfe){
            System.out.println("Error en DepartamentoBD "+cnfe.getMessage());
        }
        
        return resultados;
    }
    
    public String getNombreDepartamento(int codigo) throws SQLException{
        String resultado = " ";
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM `departamentos` WHERE `ID_departamento` = " + codigo);
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
    
        public int codigoDepartamento(String nombre) throws SQLException{
        resultados = null;
        int resultado = 0;
        try{
            if(conexion != null){
                ps = conexion.prepareCall("SELECT * FROM departamentos WHERE departamentoNombre LIKE " + "'"+nombre+"'");
                resultados = ps.executeQuery();
            }
        }
        catch(SQLException cnfe){
            System.out.println("error en departamentos");
            System.out.println(cnfe.getSQLState());
        }
        try{
        while (resultados.next()){
            resultado = resultados.getInt(1);
        }
        }
        catch(Exception e){
            
        }
        return resultado;
        
    }
    
    
}
