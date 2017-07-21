package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        //abcdefghigklmnopqrstuvwxyz
//        String fileName = "C:\\Users\\blaec\\TEMP_JAVA\\allFilesContent.txt";
//        int number = 40;
//        String text = "TESTSTRING";


        RandomAccessFile ras = new RandomAccessFile(fileName,"rw");
        number = number > ras.length() ? (int) ras.length() : number;
        ras.seek(number);
//        System.out.println(ras.length());
        ras.write(text.getBytes());
        ras.close();
    }
}
