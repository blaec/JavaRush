package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        long minByte = Byte.MAX_VALUE;

        while (fis.available() > 0) {
            long nextByte = fis.read();
            minByte = minByte > nextByte ? nextByte : minByte;
        }
        fis.close();
        System.out.println(minByte);
    }
}
