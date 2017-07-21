package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.text.DecimalFormat;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(file1);
        FileOutputStream fos2 = new FileOutputStream(file2);

        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#");

        while (fis1.available() > 0) {
            char value = (char) fis1.read();

            if (value != 32) {
                sb.append(Character.toString(value));
            }
            else {
                String number = String.valueOf(Math.round(Double.parseDouble(sb.toString()))) + " ";
                fos2.write(number.getBytes());
                sb = new StringBuilder();
            }
        }


        String number = String.valueOf(Math.round(Double.parseDouble(sb.toString()))) + " ";
        fos2.write(number.getBytes());

        fis1.close();
        fos2.close();
    }
}
