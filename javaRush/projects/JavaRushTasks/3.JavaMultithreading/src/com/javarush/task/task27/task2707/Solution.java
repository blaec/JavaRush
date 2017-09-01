package com.javarush.task.task27.task2707;

import java.util.Calendar;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
//        System.out.println("1-" + Thread.currentThread().getName() + " " + Calendar.getInstance().getTime());
        synchronized (obj1) {
//            System.out.println("2-" + Thread.currentThread().getName() + " " + Calendar.getInstance().getTime());
            synchronized (obj2) {
//                System.out.println("3-" + Thread.currentThread().getName() + " " + Calendar.getInstance().getTime());
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread1 = new Thread() {
            @Override
            public void run() {

                /*
                *   <b>someMethodWithSynchronizedBlocks sync order obj1 -> obj2</b>
                *   1st thread locks obj1 for 1 sec., 2nd thread waits before obj1 block
                *   when 1 sec passed - 1st thread locks obj2 for a bit and releases 2 blocks
                *   2nd thread - locks obj1, then obj2, prints to console and releases both blocks
                *   when 2 secs passes - 2nd thread already TERMINATED
                *
                *   <b>someMethodWithSynchronizedBlocks sync order obj2 -> obj1</b>
                *   1st thread locks obj1 for 1 sec., meanwhile 2nd thread locks obj2 block and waits for block obj1
                *   when 1 sec passed - 1st thread attempts to locks obj2 and fails
                *   deadlock created - 1st thread attempts to lock obj2 while holding obj1
                *                      2nd thread attempts to lock obj1 while holding obj2
                *   when 2 secs passes - state of 2nd thread is BLOCKED
                 */
                synchronized (o1) {
                    try { Thread.sleep(1000); } catch (InterruptedException e) { }
                    synchronized (o2) {}
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };

        thread1.start();
        thread2.start();
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        if (thread2.getState() == Thread.State.BLOCKED) return false;
        else                                            return true;
    }



    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
