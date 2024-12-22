package org.example.EX1;

import java.io.File;

public class EX1 {
    public static void dive(String path, String margin) {
        File root = new File(path);
        File[] list = root.listFiles();
        String signature;

        if(list == null) {
            return;
        }
        for ( File f : list ) {
            signature = "";
            if(f.canRead()) signature+="r";
            if(f.canWrite()) signature+="w";
            if ( f.isDirectory() ) {
                System.out.println(margin + f.getPath() + " <DIR> " + signature);
                dive( f.getAbsolutePath(), margin + "___" );
            }
            else {
                System.out.println(margin + f.getPath() + " <FILE> " + signature);
            }
        }
    }

    public static void main(String[] args) {
        dive("C:\\Users\\hp\\Desktop\\Master\\English","");
    }
}
