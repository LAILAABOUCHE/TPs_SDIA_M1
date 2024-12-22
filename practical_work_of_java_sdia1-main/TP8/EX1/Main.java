package org.example.EX1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static int goal = (int)(Math.random()*100);

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8000);
        Socket s;
        while(true) {
            s = ss.accept();
            new Thread(new Communicator(s)).start();
        }
    }
}
