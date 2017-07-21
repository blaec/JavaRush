package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.awt.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readFile = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(args[1]));

        while (readFile.ready()) {
            String[] words = readFile.readLine().split(" ");
            for (int i = 0; i < words.length; i++) {
//                System.out.println(words[i]);
                if (words[i].matches(".*\\d+.*"))
                    writeFile.write(words[i] + " ");
            }

        }

        readFile.close();
        writeFile.close();
    }
}
