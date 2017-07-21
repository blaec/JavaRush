package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        long maxByte = 0;

        while (fis.available()>0) {
            int nextByte = fis.read();
            maxByte = maxByte > nextByte ? maxByte : nextByte;
        }
        fis.close();

        System.out.println(maxByte);

    }
}
