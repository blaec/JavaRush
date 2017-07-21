package com.javarush.task.task19.task1909
;
/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String toRead = reader.readLine();
        String toWrite = reader.readLine();
        reader.close();

        BufferedReader fileRead = new BufferedReader(new FileReader(toRead));
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(toWrite));
        StringBuilder sb = new StringBuilder();

        while (fileRead.ready()) {
            sb.append(fileRead.readLine());
        }

        fileWrite.write(sb.toString().replaceAll("\\.","!"));

        fileRead.close();
        fileWrite.close();
    }
}
