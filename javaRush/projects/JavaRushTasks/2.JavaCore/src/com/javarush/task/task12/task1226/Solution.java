package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public class Cat implements Climb, Run {
        @Override
        public void climb() {

        }

        @Override
        public void run() {

        }
    }

    public class Dog implements Run{
        @Override
        public void run() {

        }
    }

    public class Tiger extends Cat {
    }

    public class Duck implements Run, Fly{
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }

    public interface Fly {
        public void fly();
    }
    public interface Climb {
        public void climb();
    }
    public interface Run {
        public void run();
    }
}
