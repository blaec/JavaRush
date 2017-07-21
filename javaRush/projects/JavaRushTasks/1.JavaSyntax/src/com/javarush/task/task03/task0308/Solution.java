package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(factorial(10));
    }

    private static int factorial(int value) {
         if (value == 1) {
            return 1;
        }
        return factorial(value - 1) * value;

    }
}
