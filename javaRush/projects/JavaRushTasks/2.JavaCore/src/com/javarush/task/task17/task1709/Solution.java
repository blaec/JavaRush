package com.javarush.task.task17.task1709;

/* 
Предложения
*/

public class Solution {
    public static int proposal = 0;

    public static void main(String[] args) {
        new AcceptProposal().start();
        new MakeProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                //System.out.println("MakeProposal: proposal = " + proposal + " while thisProposal = " + thisProposal);
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            System.out.println("all made");
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (thisProposal < 10) {
                //System.out.println("AcceptProposal: proposal = " + proposal + " while thisProposal = " + thisProposal);
                if (thisProposal != proposal) {
                    System.out.println("Принято предложение №" + proposal);
                    thisProposal = proposal;
                }

            }
            System.out.println("all accepted");
        }

    }
}
