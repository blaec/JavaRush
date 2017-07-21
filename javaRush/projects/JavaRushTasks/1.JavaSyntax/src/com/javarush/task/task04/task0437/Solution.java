package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            for (int i1 = 1; i1 <= i; i1++)
                System.out.print("8");
            System.out.println();
        }
        /*
        double number=0;
        //напишите тут ваш код
        for (int i = 0; i < 10 ; i++) {
            number += 8 * Math.pow(10,(double)i);
            System.out.println((long)number);
        }
        */
    }
}
