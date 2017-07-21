package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String text = bf.readLine();
        int n = Integer.parseInt(bf.readLine());

        while (n>0) {
            System.out.println(text);
            n--;
        }

    }
}
