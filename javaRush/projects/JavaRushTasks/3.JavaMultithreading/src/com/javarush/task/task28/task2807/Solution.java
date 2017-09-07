package com.javarush.task.task28.task2807;

import java.util.Queue;
import java.util.concurrent.*;

/* 
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                                                                       5,
                                                                       1000,
                                                                        TimeUnit.MILLISECONDS,
                                                                        new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.prestartAllCoreThreads();


        for (int i = 0; i < 10; i++) {
            final int id = i + 1;
            threadPoolExecutor.getQueue().add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(id);
                }
            });
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);

        /* output example
        pool-1-thread-2, localId=2
        pool-1-thread-3, localId=3
        pool-1-thread-1, localId=1
        pool-1-thread-3, localId=5
        pool-1-thread-2, localId=4
        pool-1-thread-3, localId=7
        pool-1-thread-1, localId=6
        pool-1-thread-3, localId=9
        pool-1-thread-2, localId=8
        pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}