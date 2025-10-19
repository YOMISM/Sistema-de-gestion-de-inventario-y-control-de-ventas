/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author angel
 */
public class Monedas {
    int ID_moneda;
    String nombre;
    String Simbolo;
    String plural;
    boolean multiplica;

    public int getID_moneda() {
        return ID_moneda;
    }

    public void setID_moneda(int ID_moneda) {
        this.ID_moneda = ID_moneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return Simbolo;
    }

    public void setSimbolo(String Simbolo) {
        this.Simbolo = Simbolo;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public boolean isMultiplica() {
        return multiplica;
    }

    public void setMultiplica(boolean multiplica) {
        this.multiplica = multiplica;
    }
    
}
