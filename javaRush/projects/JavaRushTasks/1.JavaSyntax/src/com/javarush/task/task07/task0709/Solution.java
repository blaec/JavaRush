package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        // Initialize
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myList  = new ArrayList<String>();
        int arrSize = 5;
        int minLine = Integer.MAX_VALUE;

        // Populate list & get line w/min length
        for (int i = 0; i < arrSize; i++) {
            myList.add(bf.readLine());
            if (minLine > myList.get(i).length())
                minLine = myList.get(i).length();
        }

        // Display results
        for (int b = 0; b < arrSize; b++) {
            if (myList.get(b).length() == minLine)
                System.out.println(myList.get(b));
        }
    }
}
