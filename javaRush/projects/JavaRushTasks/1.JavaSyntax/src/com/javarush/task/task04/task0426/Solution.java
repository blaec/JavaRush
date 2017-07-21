package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
«отрицательное четное число» — если число отрицательное и четное,
«отрицательное нечетное число» — если число отрицательное и нечетное,
«ноль» — если число равно 0,
«положительное четное число» — если число положительное и четное,
«положительное нечетное число» — если число положительное и нечетное.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf=new BufferedReader((new InputStreamReader(System.in)));
        int number = Integer.parseInt(bf.readLine());

        if (number == 0)
            System.out.println("ноль");
        else if (number > 0)
            if (number % 2 == 0)
                System.out.println("положительное четное число");
            else
                System.out.println("положительное нечетное число");
        else
            if (number % 2 == 0)
                System.out.println("отрицательное четное число");
            else
                System.out.println("отрицательное нечетное число");




    }
}
