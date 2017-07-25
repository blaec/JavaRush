package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;

public class Aggregator {
    public static void main(String[] args) {
        Strategy strategy = new Strategy() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        Provider provider = new Provider(strategy);
        Controller controller = new Controller(provider);

        System.out.println(controller);
    }
}
