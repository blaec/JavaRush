package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int base = 0;

        for (int i = 2; i <= 36; i++) {
            try {
//                Integer.parseUnsignedInt(number, i);
                new BigDecimal(new BigInteger(args[0],i));
//                new BigDecimal(new BigInteger("12AS08z",i));
                base = i;
                break;
            } catch (Exception e) {
                // skip exception and check another base
            }
        }

        String message = base > 0 ? String.valueOf(base) : "incorrect";
        System.out.println(message);
    }
}