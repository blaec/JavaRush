package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game = null;
    private List<Horse> horses = null;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("horse_1", 3, 0));
        game.horses.add(new Horse("horse_2", 3, 0));
        game.horses.add(new Horse("horse_3", 3, 0));
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse horse : horses)
            horse.move();
    }

    public void print() {}

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
}
