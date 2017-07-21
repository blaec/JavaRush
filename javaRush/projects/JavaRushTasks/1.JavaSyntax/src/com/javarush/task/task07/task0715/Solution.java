package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> myList = new ArrayList<String>();
        String word = "именно";
        myList.add("мама");
        myList.add("мыла");
        myList.add("раму");

        for (int b = 3; b > 0; b--) {
            myList.add(b,word);
        }

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}
