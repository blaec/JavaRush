package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("aacabb"));
    }

    public static boolean isPalindromePermutation(String s) {
        boolean result = false;

        // Create hash map which counts all chars: key = char, value = count
        Map<Integer, Integer> chars = new HashMap<>();
        char[] string = s.toLowerCase().toCharArray();
        for (int i = 0; i < string.length; i++) {
            int key = string[i];
            int number = 0;
            if (chars.containsKey(key)) {
                number = chars.get(key);
                chars.remove(key);
            }
            number++;
            chars.put(key, number);
        }

        // count odd chars
        int odds = 0;
        Iterator it = chars.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int value = (int) pair.getValue();
            if (value % 2 != 0) { odds++; }
        }

        // palindrome could be created if odd count 0 or 1
        if (odds == 0 || odds == 1) result = true;

        return result;
    }
}
