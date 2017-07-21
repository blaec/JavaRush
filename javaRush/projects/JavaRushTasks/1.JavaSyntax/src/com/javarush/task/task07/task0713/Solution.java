package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> fullList = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> listElse = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            int number = Integer.parseInt(bf.readLine());
            fullList.add(number);
            if (number % 3 == 0 && number % 2 == 0)  {
                list3.add(number);
                list2.add(number);
            }
            else if (number % 3 == 0) {
                list3.add(number);
            }
            else if (number % 2 == 0) {
                list2.add(number);
            }
            else {
                listElse.add(number);
            }
        }

        printList(list3);
        printList(list2);
        printList(listElse);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer number : list) {
            System.out.println(number);
        }
    }
}
