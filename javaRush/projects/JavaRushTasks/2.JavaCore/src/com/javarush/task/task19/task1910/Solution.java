package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String toRead = reader.readLine();
        String toWrite = reader.readLine();
        reader.close();

        BufferedReader readFile = new BufferedReader(new FileReader(toRead));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(toWrite));
        StringBuilder sb = new StringBuilder();

        while (readFile.ready())
            sb.append(readFile.readLine());

        writeFile.write(sb.toString().replaceAll("[\\p{Punct}+|\\s]",""));

        readFile.close();
        writeFile.close();

        System.out.println();

    }
}
