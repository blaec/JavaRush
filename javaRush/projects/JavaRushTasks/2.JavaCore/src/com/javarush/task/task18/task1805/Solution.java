package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        HashSet<Integer> bytes = new HashSet<>();

        while (fis.available() > 0) {
            int value = fis.read();
            bytes.add(value);
        }

        System.out.println(bytes);

        StringBuilder sb = new StringBuilder();
        for (int value : bytes) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(value);
        }
        System.out.println(sb);
        System.out.println(String.valueOf(fis));
        fis.close();

    }
}
