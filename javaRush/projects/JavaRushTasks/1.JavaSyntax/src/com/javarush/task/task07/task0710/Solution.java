package com.javarush.task.task07.task0710;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myList = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            myList.add(0,bf.readLine());
        }

        for (int b = 0; b < myList.size(); b++) {
            System.out.println(myList.get(b));
        }
    }
}
