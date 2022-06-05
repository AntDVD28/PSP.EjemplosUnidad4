/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerURL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author AntDVD
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://ftp.es.debian.org/debian/README.mirrors.txt");
        //conecta a esa URL
        url.openConnection();
        //Asocia un flujo de entrada a la conexi�n URL
        InputStream is = url.openStream();
        //Crea flujo de salida asociado a destino
        FileOutputStream os = new FileOutputStream("fichero.txt");
        byte[] buffer = new byte[2048];
        int BytesLeidos, totalBytesLeidos = 0;
        //mientras hay bytes
        while ((BytesLeidos = is.read(buffer)) > 0) {
            //almacena lo que lee en el buffer
            os.write(buffer, 0, BytesLeidos);
            totalBytesLeidos += BytesLeidos;
        }
        System.out.println("Total bytes leidos: "+totalBytesLeidos);
    }

}
