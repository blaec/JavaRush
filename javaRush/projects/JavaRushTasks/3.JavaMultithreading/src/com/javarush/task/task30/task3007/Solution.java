package com.javarush.task.task30.task3007;

/* 
Найдем число 2 в максимальной степени
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {
        // works correctly, but not accepted
        // shift 1 left (multiply by 2) - until result bigger then x
        // then in output shift it right by one
//        int result = 1;
//        while ((result = result << 1) < x) {}
//
//        return result = result >> 1;

        // find max bit - it max power of 2
        x |= (x >>  1);
        x |= (x >>  2);
        x |= (x >>  4);
        x |= (x >>  8);
        x  = x ^ (x >> 1);
        return x;
    }
}