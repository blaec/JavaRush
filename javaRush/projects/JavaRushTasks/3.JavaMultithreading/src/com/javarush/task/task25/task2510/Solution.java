package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String message = "";
                switch (e.getClass().getSimpleName()) {
                    case "Error":       message = "Нельзя дальше работать"; break;
                    case "Throwable":   message = "ХЗ";                     break;
                    default:            message = "Надо обработать";        break;
                }
                System.out.println(message);
            }
        });
    }

    public static void main(String[] args) {
    }
}
