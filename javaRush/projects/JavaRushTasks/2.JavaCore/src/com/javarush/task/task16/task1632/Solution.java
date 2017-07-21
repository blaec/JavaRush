package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        for (int i = 0; i < 3; i++) {
            threads.add(new Ball());
        }
        threads.add(new MessageThread());
        threads.add(new Ball());
    }

    public static void main(String[] args) {
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }


    }
    public static class MessageThread extends Thread implements Message{
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            }catch (InterruptedException e)
            {

            }
        }
        public void run()
        {
            while (!isInterrupted()) {}
        }
    }

    public static class Ball extends Thread {
        @Override
        public void run() {

            if (this == threads.get(0)) {
                while (true) {
                    //if (threads.get(3).isAlive()) System.out.println("still alive");
                }
            }
            else if (this == threads.get(1)) {
                try {
                    throw new InterruptedException();
                }
                catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
            else if (this == threads.get(2)) {
                try {
                    while (true) {
                        System.out.println("Ура");
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            else if (this == threads.get(4)) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String value;
                int sum = 0;
                try {
                    while (!(value = reader.readLine()).equals("N")) {
                        sum += Integer.parseInt(value);
                    }
                    System.out.println(sum);
                } catch (IOException e) {
                }
            }
        }
    }
}