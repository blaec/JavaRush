package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myList = new ArrayList<String>(10);
        int minPos = 0;
        int maxPos = 0;

        for (int i = 0; i <= myList.size(); i++) {
            myList.add(bf.readLine());
            maxPos = (myList.get(maxPos).length() < myList.get(i).length()) ? i : maxPos;
            minPos = (myList.get(minPos).length() > myList.get(i).length()) ? i : minPos;
        }

        System.out.println(myList.get(Math.min(maxPos,minPos)));


    }
}
