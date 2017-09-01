package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
//        System.out.println("Ps about to enter");
        synchronized (mail) {
//            System.out.println("Ps got inside");
            String name = Thread.currentThread().getName();
            try {
                Thread.sleep(1000);
                //сделайте что-то тут - do something here

                mail.setText("Person [" + name + "] has written an email 'AAA'");
                //сделайте что-то тут - do something here
//                System.out.println("Ps wakes up next thread");
                mail.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("Ps got out");
    }
}
