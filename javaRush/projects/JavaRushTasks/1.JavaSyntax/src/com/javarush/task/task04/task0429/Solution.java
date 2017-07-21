package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int  b = in.nextInt();
        int  c = in.nextInt();
        int[] number = {a, b, c};
        int negative=0;
        int positive=0;
        for ( int i = 0; i < number.length; i++){
            if ( number[i]> 0){
                positive++;
            }
            else if ( number[i]< 0){
                negative++;
            }
        }

        System.out.println("количество отрицательных чисел: "+negative+
                "количество положительных чисел: "+positive);

    }

}
