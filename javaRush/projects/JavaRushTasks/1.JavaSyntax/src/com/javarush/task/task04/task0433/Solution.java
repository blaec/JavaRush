package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String sChar = "";
        int r = 10;
        int c;

        while (r>0) {
            c = 10;
            while (c>0) {
                sChar += "S";
                c--;
            }
            System.out.println(sChar);
            sChar = "";
            r--;
        }
    }
}
