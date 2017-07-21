package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        if (m <= 0) throw new NumberFormatException();
        int n = Integer.parseInt(reader.readLine());
        if (n <= 0) throw new NumberFormatException();
        System.out.println(getNOD(m,n));
    }

    public static int getNOD(int m, int n) {
        int r = 0;

        while (n != 0) {
            r = m % n;
            m = n;
            n = r;
        }

        return m;
    }
}
