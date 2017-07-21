package com.javarush.task.task37.task3703;

import java.util.concurrent.ConcurrentSkipListMap;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        // https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentSkipListMap.html
        return ConcurrentSkipListMap.class;
    }
}
