package com.javarush.task.task25.task2506;

/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        target.start();  //NEW
        Thread.sleep(1000); //RUNNABLE
        target.join(1000);
        Thread.sleep(4000);
        target.interrupt(); //TERMINATED
        Thread.sleep(500);
    }
}

// Accepted only when main was changed???
class LoggingStateThread extends Thread {
    private Thread thread;
    private State previous;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        printState();
    }

    @Override
    public void run() {
        do {
            if (thread.getState() != previous) printState();
        } while (thread.getState() != State.TERMINATED);
    }

    private void printState() {
        previous = thread.getState();
        System.out.println(previous);
    }
}

