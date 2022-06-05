
package pronostico;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

/**
 * Programa para descargar el tiempo de una población dada por el usuario
 * @author david Jiménez Riscardo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        //En este ejemplo no hago una gestión exhaustiva de la entrada de usuario, ya realizada en el ejercicio 1
        String poblacion, nombre_fichero;
        System.out.print("Introduzca población: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        poblacion = br.readLine();
        nombre_fichero = poblacion;
        descargar(poblacion,nombre_fichero+".html");
    }
    
    /**
     * Método para descargar el contenido de una página web y copiarlo en un fichero nuevo
     * @param poblacion Nombre de la poblacion
     * @param ficheroDestino Nombre del fichero de destino
     * @throws Exception 
     */
    public static void descargar(String poblacion, String ficheroDestino) throws Exception {

        URL ficheroUrl = new URL("https://www.eltiempo.es/"+poblacion+".html");
   
        InputStream is = ficheroUrl.openStream();
        OutputStream os = new FileOutputStream(ficheroDestino); // path y nombre del nuevo fichero creado

        byte[] buffer = new byte[2048];
        int longitud;

        while ((longitud = is.read(buffer)) != -1) {
            os.write(buffer, 0, longitud);
        }

        is.close();  // Cerramos la conexión entrada
        os.close(); // Cerramos la conexión salida
    }
    
}
