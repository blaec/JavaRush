package com.javarush.task.task28.task2811;

/* 
ReentrantReadWriteLock
*/

import java.util.LinkedHashMap;

public class Solution {
    public static void main(String[] args) {
        ReadWriteMap<Integer, String> linkedSafeMap = new ReadWriteMap<>(new LinkedHashMap<>());
        linkedSafeMap.put(1, "First");
        linkedSafeMap.put(2, "Second");

        System.out.println("Print test: " + linkedSafeMap.get(1));
        System.out.println("Print test: " + linkedSafeMap.get(2));
    }
}
