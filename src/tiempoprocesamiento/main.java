
package tiempoprocesamiento;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import static leerURL.main3.mostrarContenido;

/**
 * Ejemplo en el que mostramos el tiempo invertido en mostrar por pantalla el código de una web
 * @author AntDVD
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String s = "http://www.iesaguadulce.es/centro/index.php/oferta-formativa/formacion-profesional-a-distancia/dam-modalidad-distancia";
        mostrarContenido(s);
    }
    
    public static void mostrarContenido(String url) throws Exception {
        URL ficheroUrl = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()));
        
        //anota la lectura del reloj del Sistema antes de inciar el procesamiento
        long tiempoInicio = System.currentTimeMillis();
        
        String linea;
        while ((linea = in.readLine()) != null) {
            System.out.println(linea);
        }
        //anota la lectura del reloj del Sistema al finalizar el procesamiento
        long tiempoFin= System.currentTimeMillis();
        
        long tiempoProceso= tiempoFin - tiempoInicio;
        System.out.println("Tiempo en procesar petición: "+ tiempoProceso);

        in.close(); // Cerramos la conexión  
    }
}
