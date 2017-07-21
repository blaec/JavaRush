package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader((new InputStreamReader(System.in)));

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(Integer.parseInt(bf.readLine()));
        numbers.add(Integer.parseInt(bf.readLine()));
        numbers.add(Integer.parseInt(bf.readLine()));

        Collections.sort(numbers, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return -num1.compareTo(num2);
            }
        });

        for(Integer number: numbers) {
            System.out.println(number);

        }
    }
}
