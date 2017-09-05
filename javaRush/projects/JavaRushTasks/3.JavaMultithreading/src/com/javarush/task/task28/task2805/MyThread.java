package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static final AtomicInteger priority = new AtomicInteger(0);

    public MyThread() {
        this.setPriority(getNextPriority(Thread.MAX_PRIORITY));
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(getNextPriority(Thread.MAX_PRIORITY));
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(getNextPriority(group.getMaxPriority()));
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(getNextPriority(Thread.MAX_PRIORITY));
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(getNextPriority(group.getMaxPriority()));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(getNextPriority(Thread.MAX_PRIORITY));
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(getNextPriority(group.getMaxPriority()));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(getNextPriority(group.getMaxPriority()));
    }

    private int getNextPriority(int maxPriority) {
        int nextPriority = priority.getAndIncrement() % Thread.MAX_PRIORITY + Thread.MIN_PRIORITY;

        return nextPriority > maxPriority ? maxPriority : nextPriority;
    }

}
