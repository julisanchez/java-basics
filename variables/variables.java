package variables;

public class variables {
    public static void main(String[] args) {
        // Los tipos de variables mas usados son (string, int y double)
        String texto = "Hello World!";
        int entero = 35;
        double decimal = 3.14;

        // Con System.out.println podemos mostrar en pantalla sus valores
        System.out.println(texto);
        System.out.println(entero);
        System.out.println(decimal);

        // Las variables tambien se pueden declarar sin ningun valor
        String noInicializado;

        // A las variables se les puede asignar un valor o modificar el actual
        noInicializado = "Ahora si no estoy vacia";
        texto = "Me modificaron";
    }

}