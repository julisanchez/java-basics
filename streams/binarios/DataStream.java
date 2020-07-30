package streams.binarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataStream {

    /*
     * Read boolean from file using DataInputStream This Java example shows how to
     * read a Java boolean primitive value from file using readBoolean method of
     * Java DataInputStream class.
     */
    public static void main(String[] args) {

        String strFilePath = "readBoolean.file";

        // Archivo binario (1001 1100 1100 0101 1001 1100 1100 0101)
        // Mantienen una estructura, por ejemplo:
        // String titulo
        // int dia de publicacion
        // int mes
        // int año
        // boolean hay stock
        // Se deben leer en el orden que la estructura esta escrita

        try {
            // FileInputStream: Lee los bytes
            FileInputStream fin = new FileInputStream(strFilePath);

            // DataInputStream: Lee distintos tipos de variables (boolean, int, string, etc).
            // Utiliza el FileInputStream para leer los bytes del archivo y convertirlos a variables
            DataInputStream din = new DataInputStream(fin);

            // Lee un boolean
            boolean b = din.readBoolean();

            System.out.println("boolean : " + b);

            // Cierra el stream
            din.close();

        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundException : " + fe);
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        }
    }
}