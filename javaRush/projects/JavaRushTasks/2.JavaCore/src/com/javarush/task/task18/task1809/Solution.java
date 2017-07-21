package com.javarush.task.task18.task1809;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
/*
Реверс файла
*/
import java.io.IOException;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f1 = new FileInputStream(reader.readLine()); //считываем первое имя файла
        FileOutputStream f2 = new FileOutputStream(reader.readLine()); //считываем второе имя файла
        byte [] buffer = new byte[f1.available()];
        int buf_size = f1.read(buffer);  //считываем весть файл
        for(int i = buf_size - 1; i >= 0; i--)
        {
            f2.write(buffer[i]);  //записываем в обратном порядке
        }
        reader.close(); //закрываем потоки
        f1.close();
        f2.close();
    }
}