package com.javarush.task.task27.task2705;

/*
Второй вариант deadlock
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        // Thread-0 - locks this and can't enter next locked block (lock) by Thread-0
//        try { Thread.sleep(1); } catch (InterruptedException e) {}
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            // Thread-1 - locks lock and can't enter next locked block (this) by Thread-0
//            try { Thread.sleep(1); } catch (InterruptedException e) {}
            synchronized (this) {
                doSomething();
            }
        }
    }

    private void doSomething() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        new Thread(new Runnable() { @Override public void run() { solution.firstMethod(); }}).start();
//        new Thread(new Runnable() { @Override public void run() { solution.secondMethod(); }}).start();
    }
}