package com.javarush.task.task04.task0427;

/* 
Описываем числа
«четное однозначное число» — если число четное и имеет одну цифру,
«нечетное однозначное число» — если число нечетное и имеет одну цифру,
«четное двузначное число» — если число четное и имеет две цифры,
«нечетное двузначное число» — если число нечетное и имеет две цифры,
«четное трехзначное число» — если число четное и имеет три цифры,
«нечетное трехзначное число» — если число нечетное и имеет три цифры.
*/

import java.io.*;

public class Solution {
    public static String result = "";

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bf=new BufferedReader((new InputStreamReader(System.in)));
        String sNumber = bf.readLine();
        int iNumber = Integer.parseInt(sNumber);

        if (iNumber % 2 == 0) {
            result = "четное";
            valueSize(sNumber);
        }
        else {
            result = "нечетное";
            valueSize(sNumber);
        }

        if (iNumber>0 && iNumber < 1000)
            System.out.println(result);
    }

    public static void valueSize(String number) {
        if (number.length() == 1)
            result += " однозначное число";
        else if (number.length() == 2)
            result += " двузначное число";
        else if (number.length() == 3)
            result += " трехзначное число";

    }
}
