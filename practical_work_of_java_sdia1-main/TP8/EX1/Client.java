package org.example.EX1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 8000);
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);

        System.out.println("try to guess the correct number (between 0 and 1) : ");

        String result = "";
        Scanner scanner = new Scanner(System.in);
        do {

            int guess = scanner.nextInt();
            pw.println(guess);

            result = br.readLine();
            System.out.println(result);

        }while(result.equals("more") || result.equals("less"));

    }
}
