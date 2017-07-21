package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

import javax.sound.midi.Soundbank;

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
        public GenerateThread() {
            super(++countCreatedThreads + "");
            this.start();
        }

        @Override
        public String toString() {
            return super.getName() + " created";
        }

        @Override
        public void run() {
            if (Solution.count > countCreatedThreads) {
                GenerateThread ct = new GenerateThread();
                System.out.println(ct);
            }
        }
    }

}
