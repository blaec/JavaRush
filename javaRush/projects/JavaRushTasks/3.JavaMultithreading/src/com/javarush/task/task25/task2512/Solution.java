package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
    }

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.getUncaughtExceptionHandler();
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Exception e) {
//            Solution.uncaughtException(thread, e);
        }
    }
}
