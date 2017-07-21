package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 1;
        int maxN = 1;

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        //Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) == list.get(i - 1))
                count++;
            else
                count = 1;

            if (maxN < count)
                maxN = count;
        }

        System.out.println(maxN);

    }
}