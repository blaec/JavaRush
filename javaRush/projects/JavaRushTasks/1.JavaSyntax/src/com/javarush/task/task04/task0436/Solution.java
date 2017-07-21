package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());

        String line = "";

        for (int r = 1; r <= m ; r++) {
            for (int i = 1; i <= n; i++) {
                line += 8;
            }
            System.out.println(line);
            line = "";
        }


    }
}
