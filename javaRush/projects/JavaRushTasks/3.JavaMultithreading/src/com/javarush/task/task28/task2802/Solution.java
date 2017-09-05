package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public AmigoThreadFactory() {

            // Group's created here with its index
            SecurityManager securityManager = System.getSecurityManager();
            group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = String.format("%s-pool-%s-thread-",group.getName(), poolNumber.getAndIncrement());
        }

        @Override
        public Thread newThread(Runnable r) {

            // Initialize Thread and set its id within group
            Thread result = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);

            // Change Thread settings
            if (result.isDaemon())  {
                result.setDaemon(false);
            }
            if (result.getPriority() != Thread.NORM_PRIORITY){
                result.setPriority(Thread.NORM_PRIORITY);
            }

            return result;
        }
    }
}
