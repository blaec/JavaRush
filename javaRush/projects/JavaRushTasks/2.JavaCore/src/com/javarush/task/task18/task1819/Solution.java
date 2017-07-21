package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis1 =  new FileInputStream(file1);
        byte[] buffer1=null;
        int count1=0;
        if (fis1.available() > 0) {
            buffer1 = new byte[fis1.available()];
            count1 = fis1.read(buffer1);
        }

        FileOutputStream fos1 = new FileOutputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        if (fis2.available() > 0) {
            byte[] buffer2 = new byte[fis2.available()];
            int count2 = fis2.read(buffer2);

            fos1.write(buffer2,0,count2 );
            fos1.write(buffer1,0,count1);
        }


        fos1.close();
        fis1.close();
        fis2.close();
    }
}
