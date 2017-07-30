package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = -10; i < 10; i++) {
            System.out.println(i + " :" + isPowerOfThree(i));
        }
    }

    public static boolean isPowerOfThree(int n) {
        boolean result = false;

        if (n != 0) {
            double number = Math.log(n) / Math.log(3);
            if (number == (int)number) result = true;
        }

        return result;
    }
}
