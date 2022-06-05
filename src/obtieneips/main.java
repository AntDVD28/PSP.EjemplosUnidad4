
package obtieneips;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;


/**
 * Programa para mostrar todas las direcciones ips asociadas a los sitios webs contenidos en un fichero
 * @author David Jiménez Riscardo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String nombre_fichero;
        nombre_fichero = leeEntrada();
        muestraIps(nombre_fichero);

    }
    
    /**
     * Método para leer de la entrada estándar
     * @return Cadena introducida por teclado en el caso de que sea válida
     * @throws IOException 
     */
    public static String leeEntrada() throws IOException{
        String entrada = null;
        boolean existe = false;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        do {
            System.out.print("Introduzca el nombre del fichero(FIN para finalizar el programa): ");          
            entrada = br.readLine();
            existe = existFile(entrada);
            if ((entrada.toUpperCase()).equals("FIN")) {
                System.out.println("Programa terminado.");
                System.exit(0);
            }
            if (!entrada.isEmpty() && !existe) {
                System.out.println("El archivo indicado no existe.");
            }
            if (entrada.isEmpty()) {
                System.out.println("Debe de introducir un nombre.");
            }

        } while (!existe || (entrada.toUpperCase()).equals("FIN"));
        br.close();
        
        return entrada;
    }

    /**
     * Método para leer los nombres de los sitios webs contenidos en un fichero,
     * averiguar las direcciones ips asociadas y mostrarlas por pantalla
     *
     * @param nombreFichero Nombre del fichero
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void muestraIps(String nombreFichero) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(nombreFichero);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();

        while (linea != null) {

            if (!linea.isEmpty()) {
                InetAddress ia[] = InetAddress.getAllByName(linea);

                System.out.print(linea + " ");
                for (int i = 0; i < ia.length; i++) {
                    System.out.print(ia[i].getHostAddress() + " ");
                }
                System.out.println();
                ia = null;
            }
            linea = br.readLine();
        }

        if (br != null) {
            br.close();
        }
        if (fr != null) {
            fr.close();
        }
    }

    /**
     * Método para comprobar si un fichero existe
     *
     * @param filename Nombre del fichero
     * @return Devuelve true si existe, false en caso contrario
     */
    public static boolean existFile(String filename) {
        boolean b = false;
        File file = new File(filename);
        if (file.exists()) {
            b = true;
        }
        return b;
    }

}
