package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,String> files = new TreeMap<>();
        String readFile = "";
        String writeFile = "";
        while (!(readFile = reader.readLine()).equals("end")) {
            int part = Integer.parseInt(readFile.split(".part")[1]);
            files.put(part,readFile);
            if (writeFile.length() == 0)
                writeFile = readFile.split(".part")[0];
        }
        reader.close();

        Iterator it = files.entrySet().iterator();
        FileOutputStream fos = new FileOutputStream(writeFile);
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            FileInputStream fis = new FileInputStream(pair.getValue().toString());

            if (fis.available()>0) {
                byte[] buffer = new byte[fis.available()];
                int count = fis.read(buffer);
                fos.write(buffer,0,count);
            }
            fis.close();
        }
        fos.close();

    }
}
