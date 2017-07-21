package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public Cat(String name) {
        this.name = name;
        age = 1;
        weight = 1;
        color = "black";
        address = null;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        color = "black";
        address = null;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        weight = 1;
        color = "black";
        address = null;
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        age = 1;
        address = null;
        name = null;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.address = address;
        this.color = color;
        age = 1;
        name = null;
    }

    public static void main(String[] args) {

    }
}
