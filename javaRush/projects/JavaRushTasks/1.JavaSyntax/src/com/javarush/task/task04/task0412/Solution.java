package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String sNumber = bf.readLine();
        int iNumber = Integer.parseInt(sNumber);

        if (iNumber>0)
            iNumber *= 2;
        else if(iNumber<0)
            iNumber += 1;

        System.out.println(iNumber);
    }

}