package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        int count=0;

        if (fis.available() > 0) {
            byte [] buffer = new byte[fis.available()];
            int data = fis.read(buffer);

            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == 44)
                    count++;
            }
        }
        fis.close();

        System.out.println(count);
    }
}
