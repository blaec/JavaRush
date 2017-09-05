package com.javarush.task.task28.task2812;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* 
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        List<Future<?>> futures = new ArrayList<Future<?>>();
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
//            Future<?> f = executor.submit(new Runnable() {
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
//            futures.add(f);
        }

//        executor.shutdownNow();

        for (Runnable future : executor.shutdownNow()) {
            System.out.println(future);
        }

//        for(Future<?> future : futures){
//            if (!future.isDone()) System.out.println(future.toString() + " was not completed");
//        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
