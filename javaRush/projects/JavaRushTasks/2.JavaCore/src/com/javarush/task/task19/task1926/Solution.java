package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));

        while (r.ready()) {
            System.out.println(new StringBuilder(r.readLine()).reverse().toString());
        }

        r.close();
    }
}