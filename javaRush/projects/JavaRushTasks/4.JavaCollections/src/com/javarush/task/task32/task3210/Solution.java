package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        //abcdefghigklmnopqrstuvwxyz
//        String fileName = "C:\\Users\\blaec\\TEMP_JAVA\\allFilesContent.txt";
//        int number = 10;
//        String text = "TESTSTRING";

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(number);
        byte[] buffer = new byte[text.length()];
        raf.read(buffer, 0, (int)text.length());
        raf.seek(raf.length());
        if (text.equals(convertByteToString(buffer)))
            raf.write("true".getBytes());
        else
            raf.write("false".getBytes());
        raf.close();
    }

    public static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
