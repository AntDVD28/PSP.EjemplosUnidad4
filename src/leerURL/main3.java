/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerURL;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author AntDVD
 */
public class main3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String s = "http://www.iesaguadulce.es/centro/index.php/oferta-formativa/formacion-profesional-a-distancia/dam-modalidad-distancia";
        mostrarContenido(s);
        descargar(s,"fichero.txt");
    }

    public static void mostrarContenido(String url) throws Exception {
        URL ficheroUrl = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()));

        String linea;
        while ((linea = in.readLine()) != null) {
            System.out.println(linea);
        }

        in.close(); // Cerramos la conexión  
    }

    public static void descargar(String url, String ficheroDestino) throws Exception {

        URL ficheroUrl = new URL(url);
        //openStream es una abreviatura de los métodos openConnection() y getInputStream
        //Podríamos haberlo hecho de esta otra forma:
//        URLConnection uc = ficheroUrl.openConnection();
//        InputStream is = uc.getInputStream();
   
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
