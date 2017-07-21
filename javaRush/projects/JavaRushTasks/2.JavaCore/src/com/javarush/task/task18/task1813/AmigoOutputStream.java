package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    private FileOutputStream fis;
    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream fdObj) throws FileNotFoundException {
        super(String.valueOf(fdObj));
        this.fis = fdObj;
    }

    @Override
    public void write(int b) throws IOException {
        fis.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fis.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fis.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        fis.flush();
        fis.write("JavaRush © All rights reserved.".getBytes());
        fis.close();
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();
    }

    @Override
    public void flush() throws IOException {
        fis.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
