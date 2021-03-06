package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream element;
    public QuestionFileOutputStream(AmigoOutputStream element) {
        this.element = element;
    }

    @Override
    public void flush() throws IOException {
        element.flush();
    }

    @Override
    public void write(int b) throws IOException {
        element.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        element.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        element.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String answer = reader.readLine();
        if (answer.equals("Д"))
            element.close();
    }
}

