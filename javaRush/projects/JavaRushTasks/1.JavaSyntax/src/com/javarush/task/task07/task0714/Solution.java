package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myList = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            myList.add(bf.readLine());
        }
        myList.remove(2);

        for (int b = myList.size()-1; b >= 0; b--) {
            System.out.println(myList.get(b));
        }
    }
}


