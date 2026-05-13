package ec.edu.gr02.servicio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversionServicio {

    public String convertir(double valor, String origen, String destino) {

        try {
            // Cambiado de 10.0.2.2 a la IP local de tu PC para que el celular físico pueda conectarse
            String ruta = "http://10.9.4.180:8080/WS_CONV_UNI_RESTFUL_JAVA/webresources/conversion/"
                    + valor + "/" + origen + "/" + destino;

            URL url = new URL(ruta);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String resultado = in.readLine();

            in.close();

            return resultado;

        } catch (Exception e) {
            return "Error conexión";
        }
    }
}