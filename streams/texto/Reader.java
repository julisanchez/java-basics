package streams.texto;

import java.io.FileReader;
import java.io.IOException;

// java.io.Reader (clase abstracta): Permite leer archivos de texto
// Subclases: BufferedReader, CharArrayReader, FilterReader, InputStreamReader, PipedReader, String Reader
public class Reader {
    public static void main(String[] args) {
        try {
            FileReader entrada = new FileReader("data.txt");

            int ascii = 0;

            while(ascii != -1) {
                ascii = entrada.read();

                char letra = (char) ascii;

                System.out.print(letra);
            }

            entrada.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}