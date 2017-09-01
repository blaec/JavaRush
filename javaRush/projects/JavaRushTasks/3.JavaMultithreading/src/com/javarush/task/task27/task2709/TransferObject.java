package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get()  {
        while (!isValuePresent) {
//            System.out.println("... and waiting to get.");
            try { wait(); } catch (InterruptedException e) { }
        }
        isValuePresent = false;
        notify();
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value)  {
        while (isValuePresent) {
//            System.out.println("... and waiting to put.");
            try { wait(); } catch (InterruptedException e) { }
        }
        isValuePresent = true;
        notify();
        this.value = value;
        System.out.println("Put: " + value);
    }
}
