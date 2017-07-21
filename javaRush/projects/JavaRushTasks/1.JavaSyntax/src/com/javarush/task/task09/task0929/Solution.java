package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args)  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                String sourceFileName = reader.readLine();
                InputStream fileInputStream = getInputStream(sourceFileName);

                String destinationFileName = reader.readLine();
                OutputStream fileOutputStream = getOutputStream(destinationFileName);

                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    fileOutputStream.write(data);
                }

                fileInputStream.close();
                fileOutputStream.close();
                break;
            } catch (IOException e) {
                System.out.println("Файл не существует");
            }
        }

    }

    public static InputStream getInputStream(String fileName) throws IOException {
        (new FileInputStream(fileName)).available();
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

