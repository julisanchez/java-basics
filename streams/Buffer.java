package streams;

import java.io.*;

// El buffer es un almacenamiento temporal para la informacion que esta esperando ser procesada
// Utilizar un buffer mejora la eficiencia del programa haciendo mas rapida la lectura/escritura
// Se utiliza BufferedReader para lectura y BufferedWriter para escritura

public class Buffer {
    public static void main(String[] args) {
        try {
            FileReader entrada = new FileReader("data.txt");
            BufferedReader minBuffer = new BufferedReader(entrada);
            String linea = "";

            while(linea != null) {
                linea = minBuffer.readLine();

                if(linea != null) System.out.println(linea);
            }

            entrada.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

}