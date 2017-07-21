package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> myList = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            myList.add("new string " + i);
        }

        System.out.println(myList.size());
        for (int b = 0; b < myList.size(); b++) {
            System.out.println(myList.get(b));
        }
    }
}
