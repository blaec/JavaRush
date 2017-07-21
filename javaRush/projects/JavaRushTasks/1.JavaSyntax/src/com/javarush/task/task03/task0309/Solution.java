package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        sumLine(10);
    }

    private static int sumLine(int value) {
        int sum=0;

        for(int i = 1; i <= value; i++) {
            sum = sum + i;
            System.out.println(sum);
        }
        return sum;
    }
}
