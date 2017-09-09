package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> orderList = new ArrayList<>();
        Map<String, Dish> menu = new HashMap<>();

        writeMessage(Dish.allDishesToString());

        for (Dish dish : Dish.values()) {
            menu.put(dish.toString(), dish);
        }

        String dish;
        while (!(dish = reader.readLine()).equals("exit")) {
            if (menu.containsKey(dish)) {
                orderList.add(menu.get(dish));
            }
        }

        return orderList;
    }
}
