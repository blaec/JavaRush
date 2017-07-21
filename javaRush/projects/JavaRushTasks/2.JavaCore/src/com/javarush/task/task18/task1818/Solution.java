package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream fos1 = new FileOutputStream(file1,true);
        FileInputStream fis2 = new FileInputStream(file2);
        FileInputStream fis3 = new FileInputStream(file3);

        if (fis2.available() > 0) {
            byte[] buffer = new byte[fis2.available()];
            int count = fis2.read(buffer);
            fos1.write(buffer,0,count);
        }

        if (fis3.available() > 0) {
            byte[] buffer = new byte[fis3.available()];
            int count = fis3.read(buffer);
            fos1.write(buffer,0,count);
        }

        fos1.close();
        fis2.close();
        fis3.close();
    }
}
