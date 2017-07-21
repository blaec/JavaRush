package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[3];
        list[0] = new ArrayList<>();
        list[0].add("list1-sting1");
        list[0].add("list1-sting2");
        list[0].add("list1-sting3");

        list[1] = new ArrayList<>();
        list[1].add("list2-sting1");
        list[1].add("list2-sting2");

        list[2] = new ArrayList<>();
        list[2].add("list3-sting1");
        list[2].add("list3-sting2");
        list[2].add("list3-sting3");
        list[2].add("list3-sting4");

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}