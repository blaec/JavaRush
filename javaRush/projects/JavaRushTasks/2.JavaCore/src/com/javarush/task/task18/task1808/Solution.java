package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String source = reader.readLine();
        String target = reader.readLine();
        String target2 = reader.readLine();
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos2= new FileOutputStream(target);
        FileOutputStream fos3 = new FileOutputStream(target2);

        if (fis.available() > 0 ) {
            int singleByte = 0;
            if (fis.available() % 2 != 0) singleByte = 1;

            byte[] buffer1 = new byte[(int)(fis.available()/2 + singleByte)];
            int count = fis.read(buffer1);
            fos2.write(buffer1,0,count);

            byte[] buffer2 = new byte[fis.available()];
            count = fis.read(buffer2);
            fos3.write(buffer2,0, count);


        }

        fis.close();
        fos2.close();
        fos3.close();
        reader.close();

    }
}
