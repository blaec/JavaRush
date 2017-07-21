package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf=new BufferedReader((new InputStreamReader(System.in)));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());

        if (a > 0 && b > 0 && c > 0)
            System.out.println(3);
        else if (a < 0 && b < 0 && c < 0)
            System.out.println(0);
        else if (a * b * c < 0)
            System.out.println(2);
        else
            System.out.println(1);

    }
}
