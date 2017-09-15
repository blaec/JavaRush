package com.javarush.task.task30.task3012;

/* 
Получи заданное число
https://toster.ru/q/378857
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(1234);
        for (int i = 1; i <= 20; i++) {
            solution.createExpression(i);
        }

    }

    public void createExpression(int number) {
        List<Integer> signs = new ArrayList<>();
        StringBuilder output = new StringBuilder().append(number + " =");
        int addToNext = 0;

        // Convert to number system with base 3
        String baseThree = (Integer.toString(number, 3));
        char[] digits = baseThree.toCharArray();

        /** Iterate backwards and replace digits to signs
         *  0 -  0
         *  1 -  1
         *  2 - -1 (add 1 to next higher order)
         *  3 -  0 (add 1 to next higher order)
         */
        for (int i = digits.length; i > 0; i--) {
            int digit = Integer.parseInt(String.valueOf(digits[i - 1]));
            digit += addToNext;
            switch (digit) {
                case 2:     signs.add(-1);      addToNext = 1;  break;
                case 3:     signs.add(0);       addToNext = 1;  break;
                default:    signs.add(digit);   addToNext = 0;  break;
            }
        }
        signs.add(addToNext);

        // generate output string according to array of signs
        int power = 0;
        for (Integer sign : signs) {
            switch (sign) {
                case -1:    output.append(" - ").append((int) Math.pow(3,power));   break;
                case 1:     output.append(" + ").append((int) Math.pow(3,power));   break;
            }
            power++;
        }

        System.out.println(output.toString());
    }
}