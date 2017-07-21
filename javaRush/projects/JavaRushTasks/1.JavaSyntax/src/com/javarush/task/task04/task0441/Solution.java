package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers=new ArrayList<Integer>();
        numbers.add(Integer.parseInt(bf.readLine()));
        numbers.add(Integer.parseInt(bf.readLine()));
        numbers.add(Integer.parseInt(bf.readLine()));

        Collections.sort(numbers);

        System.out.println(numbers.get(1));
    }
}
