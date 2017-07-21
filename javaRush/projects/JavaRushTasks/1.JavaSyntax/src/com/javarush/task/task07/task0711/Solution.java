package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myList = new ArrayList<String>();
        String tempLine = "";

        for (int i = 0; i < 5; i++) {
            myList.add(bf.readLine());
        }

        for (int b = 0; b < 13; b++) {
            tempLine = myList.get(myList.size()-1);
            myList.remove(myList.size()-1);
            myList.add(0,tempLine);
        }

        for (int c = 0; c < myList.size(); c++) {
            System.out.println(myList.get(c));
        }
    }
}
