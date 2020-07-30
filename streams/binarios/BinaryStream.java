package streams.binarios;

import java.io.*;
import java.util.ArrayList;

// FileInputStream (leer archivo)
// FileOutputStream (escribir archivo)
public class BinaryStream {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("foto.jpg");

            boolean finalArchivo = false;
            int contador = 0;
            ArrayList<Integer> datosEntrada = new ArrayList<Integer>(80000);

            while(!finalArchivo) {
                int byteEntrada = file.read();

                if(byteEntrada != -1) datosEntrada.add(byteEntrada);
                else finalArchivo = true;

                System.out.println(byteEntrada);

                contador++;
            }

            System.out.println("Cantidad bytes: " + contador);

            crearFichero(datosEntrada.toArray(new Integer[datosEntrada.size()]));

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void crearFichero(Integer[] datosNuevoFichero) {
        try {
            FileOutputStream ficheroNuevo = new FileOutputStream("copia.jpg");

            for(int i = 0; i < datosNuevoFichero.length; i++) {
                ficheroNuevo.write(datosNuevoFichero[i]);
            }

            ficheroNuevo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}