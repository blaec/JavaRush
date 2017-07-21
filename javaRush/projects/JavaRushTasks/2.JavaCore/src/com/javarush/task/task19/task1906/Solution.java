package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileRead = reader.readLine();
        String fileWrite = reader.readLine();
        reader.close();

        FileReader read = new FileReader(fileRead);
        FileWriter write = new FileWriter(fileWrite);

        int count = 0;
        while (read.ready()) {
            int data = read.read();
            if (++count % 2 == 0) {
                System.out.println(count);
                write.write(data);
            }
        }

        read.close();
        write.close();
    }
}
