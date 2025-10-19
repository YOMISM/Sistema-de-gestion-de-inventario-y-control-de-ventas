/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author angel
 */
public class ObtenerTasa {
    double tasa;
    String fecha;
    boolean ok;
    public ObtenerTasa(){
           ok = true;
           try {
            // URL de la API
            URL url = new URL("https://ve.dolarapi.com/v1/dolares/oficial");
            
            // Abrir la conexión
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Agregar encabezados necesarios
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // Simular un navegador
            
            // Configurar tiempo de espera
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            // Obtener la respuesta
           int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                // Parsear el JSON
                JSONObject jsonObject = new JSONObject(response.toString());
                
                // Extraer los valores de "promedio" y "fechaActualizacion"
                tasa = jsonObject.getDouble("promedio");
                fecha = jsonObject.getString("fechaActualizacion");
                
            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + responseCode);
            }
        } catch (IOException | JSONException e) {
            // Manejar errores
            System.out.println("Error: " + e.getMessage());
            ok = false;
        }        
    }

    public double getTasa() {
        return tasa;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean isOk() {
        return ok;
    }
       
}
