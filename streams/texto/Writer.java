package streams.texto;

import java.io.FileWriter;
import java.io.IOException;

// Write text files
public class Writer {
    public static void main(String[] args) {

        String frase = "Esto es una prueba de escritura";

        try {
            // Si no existe el fichero lo crea. Si existe lo sobreescribe
            FileWriter escritura = new FileWriter("prueba.txt");

            // Al fichero ya creado le añade el texto
            // FileWriter escritura = new FileWriter("prueba.txt", true);

            for(int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }

            escritura.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}