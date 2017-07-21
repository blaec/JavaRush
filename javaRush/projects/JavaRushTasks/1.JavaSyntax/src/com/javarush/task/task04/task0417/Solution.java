package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());

        String result = "";
        if (a == b && a == c)
            result = a + " " + b + " " + c;
        else if (a == b )
            result = a + " " + b;
        else if (a == c)
            result = a + " " + c;
        else if (b == c)
            result = b + " " + c;

        if (result.length() > 0)
            System.out.println(result);

    }
}