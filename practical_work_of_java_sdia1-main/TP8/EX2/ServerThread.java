package org.example.EX2;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket s;
    private InputStream is;
    private InputStreamReader isr;
    private BufferedReader br;
    private OutputStream os;
    private PrintWriter pw;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            // initialize the receiving elements
            is = s.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // initialize the sending elements
            os = s.getOutputStream();
            pw = new PrintWriter(os, true);

            // read what the client has sent
            String filename = br.readLine();

            // initialize the file elements
            File file = new File("src\\main\\java\\org\\example\\EX2\\"+filename+".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderForFile = new BufferedReader(fileReader);

            // get the content of the file
            String contentFile = bufferedReaderForFile.readLine();

            // send the content
            pw.println(contentFile);

            System.out.println("client has been received successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
