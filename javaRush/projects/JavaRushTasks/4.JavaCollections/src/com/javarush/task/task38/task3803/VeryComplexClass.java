package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/


import java.util.HashSet;
import java.util.Set;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object x = new Integer(0);
        System.out.println((String)x);
    }

    public void methodThrowsNullPointerException() {
        Object obj = null;
        obj.toString();
    }

    public static void main(String[] args) {
//        new VeryComplexClass().methodThrowsClassCastException();
//        new VeryComplexClass().methodThrowsNullPointerException();
    }
}
