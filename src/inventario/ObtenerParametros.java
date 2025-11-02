package inventario;

import Servidor.ObtenerTasa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * @author Hector Alvarez
 *  * 
 */
public class ObtenerParametros{
    
    private String nombre, direccion, rif;
    private int ganancia, iva, factura;
    private double tasa;
    private final Properties propiedades;
    private String cadena;
    private boolean activo, errorTasa, dia = true;
    private LocalDate fecha;
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ObtenerParametros(){
        propiedades = new Properties();
        leerParametros();
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
        propiedades.setProperty("FECHA", fecha.format(formato));
    }

    public boolean isDia() {
        return dia;
    }

    public void setDia(boolean dia) {
        this.dia = dia;
        if(dia){
            propiedades.setProperty("DIA", "true");
        }
        else{
            propiedades.setProperty("DIA", "false");
        }
    }
    
    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
        propiedades.setProperty("FACTURA", String.valueOf(factura));
    }
    public boolean isErrorTasa() {
        return errorTasa;
    }

    public boolean isActivo() {
        return activo;
    }

    public boolean setActivo(boolean activo) {
        this.activo = activo;
        if(activo){
            propiedades.setProperty("ACTIVO", "true");
            tasaAutomatica();
        }
        else{
            propiedades.setProperty("ACTIVO", "false");
            setTasa(Double.parseDouble(propiedades.getProperty("TASA")));
        }
        return isErrorTasa();
    }
    
    private void tasaAutomatica(){
        ObtenerTasa obtenerTasa = new ObtenerTasa();
        setTasa(obtenerTasa.getTasa());
        errorTasa = obtenerTasa.isOk();
    }
    
    private void leerParametros(){
        try{
            // Primero buscar en el directorio actual (para cuando se ejecuta desde IDE)
            File archivoLocal = new File("Datos.txt");

            // Si no existe localmente, buscar como recurso del JAR
            if (!archivoLocal.exists()) {
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Datos.txt");
                if (inputStream != null) {
                    propiedades.load(inputStream);
                    inputStream.close();
                    cadena = "Datos.txt (desde recursos JAR)";
                    System.out.println("Cargando desde recursos JAR: " + cadena);
                } else {
                    // Si no está en el JAR, crear uno nuevo
                    crearArchivoConfiguracion(archivoLocal);
                    propiedades.load(new FileInputStream(archivoLocal));
                    cadena = archivoLocal.getAbsolutePath();
                    System.out.println("Cargando desde filesystem: " + cadena);
                }
            } else {
                // Cargar desde filesystem
                propiedades.load(new FileInputStream(archivoLocal));
                cadena = archivoLocal.getAbsolutePath();
                System.out.println("Cargando desde filesystem: " + cadena);
            }

            /**Obtenemos los parametros definidos en el archivo*/
            setNombre(propiedades.getProperty("NOMBRE"));
            setDireccion(propiedades.getProperty("DIRECCION"));
            setRif(propiedades.getProperty("RIF"));
            setGanancia(Integer.parseInt(propiedades.getProperty("GANANCIA")));
            setIva(Integer.parseInt(propiedades.getProperty("IVA")));
            setActivo(Boolean.parseBoolean(propiedades.getProperty("ACTIVO")));
            setFactura(Integer.parseInt(propiedades.getProperty("FACTURA")));
            setDia(Boolean.parseBoolean(propiedades.getProperty("DIA")));
            setFecha(LocalDate.parse(propiedades.getProperty("FECHA"),formato));
            System.out.println(isActivo()+ " desde parametros");

            if(!activo){     
                setTasa(Double.parseDouble(propiedades.getProperty("TASA")));
            } else {
                tasaAutomatica();
            }

        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + cadena);
            JOptionPane.showMessageDialog(null, "Error, archivo de parámetros no existe");
            System.exit(1000);
        }
        catch (NumberFormatException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error, parámetro no numérico");
            System.exit(1000);
        }
        catch (IOException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error, archivo de parámetros no se puede leer");
            System.exit(1000);
        }
    }

    private void crearArchivoConfiguracion(File archivo) throws IOException {
        Properties propsDefault = new Properties();

        // Valores por defecto
        propsDefault.setProperty("NOMBRE", "Mi Empresa");
        propsDefault.setProperty("DIRECCION", "Mi Dirección");
        propsDefault.setProperty("RIF", "J-000000000");
        propsDefault.setProperty("GANANCIA", "30");
        propsDefault.setProperty("IVA", "16");
        propsDefault.setProperty("ACTIVO", "false");
        propsDefault.setProperty("TASA", "1.0");
        propsDefault.setProperty("FACTURA", "1");
        propsDefault.setProperty("DIA", "true");
        propsDefault.setProperty("FECHA", LocalDate.now().format(formato));

        // Crear directorio si no existe
        archivo.getParentFile().mkdirs();

        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            propsDefault.store(fos, "Archivo de configuración generado automáticamente");
        }

        System.out.println("Archivo de configuración creado: " + archivo.getAbsolutePath());
    }

    public void guardar() throws FileNotFoundException, IOException {
        // Siempre guardar en el filesystem, no en el JAR
        File archivoGuardar = new File("Datos.txt");
        propiedades.store(new FileOutputStream(archivoGuardar), "Configuración guardada");
        System.out.println("Configuración guardada en: " + archivoGuardar.getAbsolutePath());
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre){
        this.nombre = nombre;
        propiedades.setProperty("NOMBRE", nombre);
    }

    public String getDireccion() {
        return direccion; 
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
        propiedades.setProperty("DIRECCION", direccion);
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
        propiedades.setProperty("RIF", rif);
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
        propiedades.setProperty("GANANCIA",String.valueOf(ganancia));
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
        propiedades.setProperty("IVA", String.valueOf(iva));
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
        propiedades.setProperty("TASA", String.valueOf(tasa));
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}