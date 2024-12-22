package org.example.EX2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8000);

        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = s.getOutputStream();
        PrintWriter fw = new PrintWriter(os,true);

        Scanner scanner = new Scanner(System.in);

        System.out.println("write the filename that you need to read it's content :");

        fw.println(scanner.nextLine());

        String receivedContent = br.readLine();

        System.out.println("the received content is : "+receivedContent);
    }
}
