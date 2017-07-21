package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw;

        try {
            String fileName = br.readLine();
            bw = new BufferedWriter(new FileWriter("C:\\CCC Images\\" + fileName));
            while (true) {
                String line = br.readLine();
                bw.write(line);
                bw.newLine();
                if (line.equals("exit"))
                    break;            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
