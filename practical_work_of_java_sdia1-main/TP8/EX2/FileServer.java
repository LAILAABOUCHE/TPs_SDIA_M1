package org.example.EX2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8000);
        Socket s = null;
        System.out.println("waiting for clients...");
        while(true) {
            s = ss.accept();
            System.out.println("a new client has connected!");
            ServerThread st = new ServerThread(s);
            new Thread(st).start();
        }
    }
}
