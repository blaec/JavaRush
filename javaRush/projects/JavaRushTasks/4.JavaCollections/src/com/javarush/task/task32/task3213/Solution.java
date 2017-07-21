package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder sb = new StringBuilder();
        String ouput;
        try {
            while (true) {
                char nextChar;
                int letter = reader.read();
                if (letter == -1) break;
                if (letter != 32) {
                    nextChar = (char) (letter+key);
                }
                else
                    nextChar = (char) letter;
                sb.append(nextChar);
            }
            ouput = sb.toString();
        } catch (Exception e) {
            ouput = "";
        }
        return ouput;
    }

}
