package com.javarush.task.task16.task1619;

/* 
А без interrupt слабо?
*/

public class Solution {
    static volatile boolean isCancel = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        Thread z = new Thread(new TestThread());
        t.start();
        z.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod()  {
        //TestThread.setCancel(true);
        isCancel = true;
    }

    public static class TestThread implements Runnable {
        private static boolean cancel = false;

        public static void setCancel(boolean cancel) {
            TestThread.cancel = cancel;
        }

        public void run() {
            while (!isCancel) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
