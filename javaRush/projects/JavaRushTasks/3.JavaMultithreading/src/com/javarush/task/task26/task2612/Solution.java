package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/

// http://javatutor.net/articles/blockings
// https://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        //implement logic here, use the lock field
        lock.lock();

        try {
            if (lock.tryLock()) ifLockIsFree();
            else ifLockIsBusy();

        // accepted catch, but more reasonable should by finally
        } catch (Exception e) {
            lock.unlock();
        }
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
