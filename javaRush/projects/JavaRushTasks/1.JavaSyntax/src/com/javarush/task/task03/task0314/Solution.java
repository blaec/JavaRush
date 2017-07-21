package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for(int c=1; c<=10; c++) {
            for(int r=1; r<=10; r++) {
                System.out.print(c * r + " ");
            }
            System.out.println();
        }
    }
}
