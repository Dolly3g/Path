package com.company;

import java.io.*;

/**
 * Created by dollyg on 3/7/2015.
 */
public class File_Reader {
    private String filename;
    private File file;
    private int length;

    public File_Reader(String filename){
        this.filename = filename;
        this.file = new File(filename);
        length = (int)file.length();
    }

    public String readFile() throws IOException {
        String text =""; //null;
        char cbuf[] = new char[length];
        FileReader file = new FileReader(filename);
        BufferedReader bfr = new BufferedReader(file);
//            String line="";
//                while ((line=bfr.readLine())!=null){
//                    text+=(line+"\n");
//                }
        bfr.read(cbuf);
        text = new String(cbuf);

        return text;
    }
}
