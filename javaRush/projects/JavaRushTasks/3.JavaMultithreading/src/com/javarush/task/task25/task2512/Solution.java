package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        List<String> messages = new ArrayList<>();

        t.interrupt();

        while (e != null) {
            messages.add(e.toString());
            e = e.getCause();
        }

        for (int i = messages.size() - 1; i >= 0; i--) {
            System.out.println(messages.get(i));
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread();
        Solution solution = new Solution();
        solution.uncaughtException(thread, new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
