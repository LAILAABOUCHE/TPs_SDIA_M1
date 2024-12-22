package org.example.EX1;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 12345)) {
            System.out.println("Connected to the server!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;
            while (true) {
                System.out.print("Client: ");
                clientMessage = console.readLine();
                output.println(clientMessage);
                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client exiting...");
                    break;
                }

                serverMessage = input.readLine();
                if (serverMessage == null || serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected!");
                    break;
                }
                System.out.println("Server: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

