package variables.strings;

public class strings {
    public static void main(String[] args) {
        String hola = "Hola";
        String nombre = "Sara";

        // Se pueden concatenar strings con (+)
        String conctatenado = hola + " " + nombre;

        System.out.println("El String concatenado es: " + conctatenado);

        // Mostrar la cantidad de caracteres de un string
        int length = conctatenado.length();
        System.out.println("Su longitud es: " + length);
    }
}