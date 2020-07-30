package sockets;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Se conecta como cliente en localhost, puerto 4999
            // Cada socket tiene un imputStream y un outputStream
            Socket s = new Socket("localhost", 4999);

            // Envia un mensaje al servidor
            PrintWriter pr = new PrintWriter(s.getOutputStream());

            pr.println("Hello");
            pr.flush();

            // Lee y muestra el stream de entrada
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("Server : "+ str);

            // Cierra el socket
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}