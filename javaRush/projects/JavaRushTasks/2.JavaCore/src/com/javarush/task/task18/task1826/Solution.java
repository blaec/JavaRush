package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String action = args[0];
        String source = args[1];
        String target = args[2];

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(target);
        if (fis.available()>0) {
            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            if (action.equals("-e"))
                encrypt(buffer);
            else
                dencrypt(buffer);
            fos.write(buffer,0,count);
        }
        fos.close();
        fis.close();
    }

    public static byte[] encrypt(byte[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i]++;
        }

        return values;
    }

    public static byte[] dencrypt(byte[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i]--;
        }

        return values;
    }

}
