package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
//        System.out.println("MS about to enter");
        synchronized (mail) {
//            System.out.println("MS got inside");
            long beforeTime = System.currentTimeMillis();
            //сделайте что-то тут - do something here
            try {
//                System.out.println("MS waiting...");
                mail.wait();
            } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();
            long afterTime = System.currentTimeMillis();
            System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
        }
//        System.out.println("\nMS got out");
    }
}
