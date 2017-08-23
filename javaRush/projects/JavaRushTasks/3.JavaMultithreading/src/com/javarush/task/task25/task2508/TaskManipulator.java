package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread innerThread;

    @Override
    public void run() {
        // Accepted when try-catch block was inside while block??? Which is infinite loop
        // This version works better
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(innerThread.getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) { }
    }

    @Override
    public void start(String threadName) {
        innerThread = new Thread(this, threadName);
        innerThread.start();
    }

    @Override
    public void stop() {
        innerThread.interrupt();
    }
}
