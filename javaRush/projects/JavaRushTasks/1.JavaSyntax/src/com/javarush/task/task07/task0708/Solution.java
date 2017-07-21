package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myList = new ArrayList<String>();
        int arrSize = 5;
        int maxLen = 0;

        for (int i = 0; i < arrSize; i++) {
            myList.add(bf.readLine());
            if (maxLen < myList.get(i).length())
                maxLen = myList.get(i).length();
        }

        for (int x = 0; x < arrSize; x++) {
            if (myList.get(x).length() == maxLen)
                System.out.println(myList.get(x));
        }
}
}
