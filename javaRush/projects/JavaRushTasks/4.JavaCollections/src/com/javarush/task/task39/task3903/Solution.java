package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please type in a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please type in first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please type in second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {

        // precondition: i >= j, so if i < j - swap them
        if (i < j) {
            i = i ^ j;
            j = i ^ j;
            i = i ^ j;
        }
        int d = i - j;

        // let number = 2, i = 2, j = 1 [result 0010 -> 0100 = 4]
        // number >> d
        // 0010 >> 1 =
        // 0001
        //
        // number ^ (number >> d)
        // 0010 XOR
        // 0001 =
        // 0011 [=3]
        //
        // 1 << j
        // 0001 << 1 =
        // 0010
        //
        // (number ^ (number >> d)) & (1 << j)
        // 0011 AND
        // 0010 =
        // 0010
        long y = (number ^ (number >> d)) & (1 << j);

        // number ^ y
        // 0010 XOR
        // 0010 =
        // 0000
        //
        // (y << d)
        // 0010 << 1 =
        // 0100
        //
        // number ^ y ^ (y << d)
        // 0000 XOR
        // 0100 =
        // 0100
        return number ^ y ^ (y << d);

    }
}
