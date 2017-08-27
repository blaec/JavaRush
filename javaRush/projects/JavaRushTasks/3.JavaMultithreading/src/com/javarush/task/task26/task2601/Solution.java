package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sort(new Integer[] { 13, 8, 15, 5, 17 })));
//        System.out.println(Arrays.toString(sort(new Integer[] { 13, 9, 15, 11, 17 })));
//        System.out.println(Arrays.toString(sort(new Integer[] { 13, 8, 15, 11, 17 })));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int median;
        if (array.length % 2 == 0)
            median = ((int) array[array.length / 2] + (int) array[array.length / 2 - 1]) / 2;

        else
            median = (int) array[array.length / 2];

        Comparator<Integer> medianSort = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - median) - Math.abs(o2 - median);
            }
        };

        Arrays.sort(array, medianSort);

        return array;
    }
}
