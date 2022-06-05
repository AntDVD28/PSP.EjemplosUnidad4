/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author AntDVD
 */
public class main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://www.iesaguadulce.es/centro/index.php/oferta-formativa/formacion-profesional-a-distancia/dam-modalidad-distancia");

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine, inputText = null;

        while ((inputLine = in.readLine()) != null) {
            inputText = inputText + inputLine;
        }
        
        System.out.println(inputText);
        in.close();
    }

}
