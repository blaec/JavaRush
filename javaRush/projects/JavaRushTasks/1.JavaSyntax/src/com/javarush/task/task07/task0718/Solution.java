package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int orderBroken=0;

        for (int i = 0; i < 10; i++) {
            list.add(bf.readLine());
            if (orderBroken == 0 && i > 0 && list.get(i).length() < list.get(i-1).length())
                orderBroken = i;
        }

        if (orderBroken>0)
            System.out.println(orderBroken);
    }
}

