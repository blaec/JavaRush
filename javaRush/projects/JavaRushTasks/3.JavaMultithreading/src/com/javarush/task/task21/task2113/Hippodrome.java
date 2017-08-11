package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game = null;
    private static List<Horse> horses = new ArrayList<>();

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(horses);
        game.horses.add(new Horse("horse_1", 3, 0));
        game.horses.add(new Horse("horse_2", 3, 0));
        game.horses.add(new Horse("horse_3", 3, 0));

        // validator requires set to horses static modifier and initialize it
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse horse : horses)
            horse.move();
    }

    public void print() {
        for (Horse horse : horses)
            horse.print();

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run()  {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double maxDistance = 0;
        for (Horse horse : horses) {
            maxDistance = horse.getDistance() > maxDistance ? horse.getDistance() : maxDistance;
            if (maxDistance == horse.getDistance()) winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }
}
