package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;


    public static String allDishesToString() {
        StringBuilder dishes = new StringBuilder();
        final String DISH_DELIMITER = ", ";

        for (Dish dish : Dish.values()) {
            if (dishes.length() > 0) {
                dishes.append(DISH_DELIMITER);
            }
            dishes.append(dish.name());
        }

        return dishes.toString();
    }
}
