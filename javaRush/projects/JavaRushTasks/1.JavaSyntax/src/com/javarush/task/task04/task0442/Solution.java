package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;

        while (true) {
            int number = Integer.parseInt(bf.readLine());
            sum += number;
            if (number == -1)
                break;
        }

        System.out.println(sum);
    }
}
