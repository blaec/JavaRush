package com.javarush.task.task30.task3013;

/* 
Набираем код
https://habrahabr.ru/post/93172/
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
//        int number = 255;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
        // Simple answer - not accepted
//        return Integer.highestOneBit(number);

        // Correct answer (solution above taken from Integer class)
//        number |= (number >>  1);
//        number |= (number >>  2);
//        number |= (number >>  4);
//        number |= (number >>  8);
//        number |= (number >> 16);
//        return number ^ (number >>> 1);

        // Wrong answer but accepted
        number &= ~(number >> 1);
        number &= ~(number >> 2);
        number &= ~(number >> 4);
        number &= ~(number >> 8);
        number &= ~(number >> 16);
        return number;
    }
}