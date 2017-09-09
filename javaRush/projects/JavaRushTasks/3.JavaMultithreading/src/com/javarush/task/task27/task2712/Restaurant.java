package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;

public class Restaurant {
    public static void main(String[] args) {
        Cook cook = new Cook("cooK");
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        Order order = tablet.createOrder();
        cook.update(tablet, order);
    }
}

