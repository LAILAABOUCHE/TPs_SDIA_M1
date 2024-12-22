package org.example.EX1;

import java.io.*;
import java.net.Socket;

public class Communicator implements Runnable{
    private Socket s;
    public Communicator(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println("start");
        int value;
        try {
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            while(true){
                value = Integer.valueOf(br.readLine());
                System.out.println("one shot "+value);
                if(value > Main.goal) {
                    pw.println("less");
                } else if(value < Main.goal) {
                    pw.println("more");
                } else {
                    pw.println("someone won");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
