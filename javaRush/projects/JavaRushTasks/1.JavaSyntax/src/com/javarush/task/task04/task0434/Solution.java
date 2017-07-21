package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String line = "";
        int row = 1;
        int col = 1;


        while(row <= 10) {

            col = 1;
            while(col <= 10) {
                int production;
                production = row*col;
                line += production + " ";
                col++;
            }
            System.out.println(line);
            line = "";
            row++;
        }
    }
}
