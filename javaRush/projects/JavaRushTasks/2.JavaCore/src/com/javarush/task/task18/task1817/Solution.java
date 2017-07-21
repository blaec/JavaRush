package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        double spaces = 0;
        double chars = 0;

        while (fis.available() > 0) {
            int letter = fis.read();
            chars++;
            if (letter == 32 ) {
                spaces++;
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(spaces/chars*100));
        fis.close();
    }
}
