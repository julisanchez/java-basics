package sockets;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket ss;

        try {
            // Crea el socket servidor en el puerto 4999
            ss = new ServerSocket(4999);
            // Comienza a aceptar la coneccion del cliente
            // Cuando el cliente se conecte va a devuelver un socket
            // que lo referencie
            Socket s = ss.accept();

            System.out.println("Client connected");

            // Lee y muestra el stream de entrada
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("Client : "+ str);

            // Envia un mensaje al cliente
            PrintWriter pr = new PrintWriter(s.getOutputStream());

            pr.println("Hello");
            pr.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}