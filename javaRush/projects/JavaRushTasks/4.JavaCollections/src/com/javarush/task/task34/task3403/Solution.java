package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        int i = 1;
        while (i != n) {
            i++;
            if (n % i == 0) {
                System.out.print(i + " ");
                if (n == i) break;
                recursion(n / i);
                break;
            }
        }
    }

//    public static void main(String[] args) {
//        recursion(132);
//    }
}
