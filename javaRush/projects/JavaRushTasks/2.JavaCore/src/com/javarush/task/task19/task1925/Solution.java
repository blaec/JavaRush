package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder sb = new StringBuilder();

        while (reader.ready()) {
            String line = reader.readLine();
            sb.append(line);
        }

        String[] words = sb.toString().split(" ");
        sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {

            if (words[i].length() > 6) {
                if (sb.length() == 0) {
                    sb.append(words[i]);
                }
                else {
                    sb.append(",");
                    sb.append(words[i]);
                }
            }
        }

        writer.write(sb.toString());

        reader.close();
        writer.close();
    }
}
