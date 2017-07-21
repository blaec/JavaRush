package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        BufferedReader fileRead = new BufferedReader(new FileReader(name));

        while (fileRead.ready()) {
            String line = fileRead.readLine();
            int count = 0;
            for (int i = 0; i < words.size(); i++) {
                Pattern p = Pattern.compile(words.get(i));
                Matcher m = p.matcher(line);
                while (m.find())
                    count++;
            }
            if (count == 2)
                System.out.println(line);
        }

        fileRead.close();
    }
}
